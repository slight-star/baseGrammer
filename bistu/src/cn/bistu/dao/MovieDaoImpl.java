package cn.bistu.dao;


import cn.bistu.util.JDBCUtils;
import com.sample.Movie;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author dfx
 */
public class MovieDaoImpl implements MovieDao{
    /**
     * 创建jdbctemplate对象(Spring提供的)，共用连接池 JDBCUtils.getDataSource()
     */
    private JdbcTemplate template =  new JdbcTemplate(JDBCUtils.getDataSource());


    /**
     * 查询每年的年度票房
     * @return
     */
    public List findYearBoxoffice(){
        //1.编写sql
        String sql = "select round(sum(totalBoxoffice)/10000,2) as totalBoxoffice,year as year from movie where year>=2000 group by year order by year";
        //2.调用query方法
        List<Map<String, Object>> maps = template.queryForList(sql);
        return maps;
    }

    /**
     * 查询每年schedule票房
     * @param year
     * @return
     */
    public List findDangqiBoxoffice(int year){
        String sql = "select round(sum(totalBoxoffice)/10000,2) as totalBoxoffice,schedule from movie where schedule!='' and year = ? " +
                "group by schedule " +
                "order by field (schedule,'元旦档','春节档','情人节档','妇女节档','清明档','五一档','端午档','六一档','暑期档','七夕档','中秋档','国庆档','贺岁档')";
        List<Map<String, Object>> maps = template.queryForList(sql,year);
        return maps;

    }

    /**
     * 查询每年上映数量
     * @return
     */
    public List findMovieCount() {
        String sql = "select count(*) as count,year as year from movie where year>=2000 group by year order by year;";
        List<Map<String, Object>> maps = template.queryForList(sql);
        return maps;
    }

    /**
     * 查询每年前10电影
     * @param year
     * @return
     */
    public List findMovieTop(int year){
        String sql = "select title,totalBoxoffice,year from movie where year=? order by totalBoxoffice desc limit 10;";
        List<Map<String, Object>> maps = template.queryForList(sql, year);
        return maps;
    }

    public List findTypeTop() {
        String sql = "select count(*) as value,type1 as name from movie group by type1 order by value desc limit 10;";
        List<Map<String, Object>> maps = template.queryForList(sql);
        return maps;
    }

    //查询电影列表
    @Override
    public List findMovieList() {
        String sql = "select title, actor,director,totalBoxoffice from movie;";
        List<Map<String, Object>> maps = template.queryForList(sql);
        return maps;
    }

    @Override
    public int findMovieTotalCount() {
//        String sql = "select count(title) from movie;";
//        String sql = "select count(0) from movie;";
//
//        Integer count = template.queryForObject(sql, Integer.class);
        //上面的太慢了，无奈新建一个表，保存数据记录数
        String sql = "select movie_count from movie_count;";
        Integer count = template.queryForObject(sql, Integer.class);

        return count;
    }



    @Override
    public void addMovie(Movie movie) {

        String sql = "insert into movie( title, actor, director, mainType, releaseDate, totalBoxOffice) values(?, ?, ?, ?, ?, ?) ";
        int update = template.update(sql, movie.getTitle(), movie.getActor(), movie.getDirector(), movie.getMainType(), movie.getReleaseDate(), movie.getTotalBoxoffice());

        if (update > 0){
            int count = findMovieTotalCount();
            updateMovieCount(count+1);
        }
    }

    @Override
    public void delMovie(int movieId) {
        String sql = "delete from movie where movieId = ?";
        int update = template.update(sql, movieId);

        if (update > 0){
            int count = findMovieTotalCount();
            updateMovieCount(count-1);
        }
    }

    @Override
    public void updateMovieCount(int count) {
        String sql = "update movie_count set movie_count = ? ";
        template.update(sql, count);
    }

    @Override
    public Movie findMovie(int movieId) {
        String sql = "select * from movie where movieId = ?";
        List<Movie> movies = template.query(sql, new BeanPropertyRowMapper<Movie>(Movie.class), movieId);
        return movies.get(0);
    }

    @Override
    public void updateMovie(Movie movie) {
        String sql = "update movie set title = ?, actor = ?, director = ?, mainType = ?, releaseDate = ?, totalBoxoffice = ? where movieId = ?";
        int update = template.update(sql, movie.getTitle(), movie.getActor(), movie.getDirector(), movie.getMainType(), movie.getReleaseDate(), movie.getTotalBoxoffice(), movie.getMovieId());

    }

    @Override
    public int findMovieCountByConditions(Map<String, String[]> conditions) {
        String sql = "select count(*) from movie where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        //遍历条件
        Set<String> keySet = conditions.keySet();
        //定义参数集合
        List<Object> params = new ArrayList<Object>();
        //遍历条件添加到sql语句
        for (String key : keySet){
            //排除当前页和行数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //条件值
            String value = conditions.get(key)[0];
            if(value != null && !"".equals(value)){
                sb.append(" and "+key+" like ? ");
                params.add("'%"+value+"%'");
            }
        }

        sql = sb.toString();

        Integer count = template.queryForObject(sql, Integer.class, params.toArray());
        return count;
    }

    //条件查询
    @Override
    public List<Movie> findMovieByPage(int start, int rows, Map<String, String[]> conditions) {
        String sql = "select movieId, title, actor, director, releaseDate, totalBoxOffice from movie where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        //遍历条件
        Set<String> keySet = conditions.keySet();
        //定义参数集合
        List<Object> params = new ArrayList<Object>();
        //遍历条件添加到sql语句
        for (String key : keySet){
            //排除当前页和行数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //条件值
            String value = conditions.get(key)[0];
            if(value != null && !"".equals(value)){
                sb.append(" and "+key+" like ? ");
                params.add("'%"+value+"%'");
            }
        }
        sb.append(" limit ?,?");
        params.add(start);
        params.add(rows);

        sql = sb.toString();

        List<Movie> movies = template.query(sql, new BeanPropertyRowMapper<Movie>(Movie.class), params.toArray());
        return movies;
    }
}