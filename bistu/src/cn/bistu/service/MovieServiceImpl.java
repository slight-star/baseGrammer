package cn.bistu.service;

import cn.bistu.dao.MovieDao;
import cn.bistu.dao.MovieDaoImpl;
import cn.bistu.domain.PageBean;
import com.sample.Movie;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author dfx
 */
public class MovieServiceImpl implements MovieService {
    private MovieDao dao = new MovieDaoImpl();

    @Override
    public List findMovieList() {
        return dao.findMovieList();
    }

    /*
    @Override
    public PageBean<Movie> findMovieByPage(PageBean<Movie> pb) {
        //设置总记录数
        int totalCount = dao.findMovieTotalCount();
        pb.setTotalCount(totalCount);

        //设置总页码数
        int totalPages = totalCount % pb.getRows() == 0 ? totalCount / pb.getRows() : totalCount / pb.getRows() + 1;
        pb.setTotalPage(totalPages);

        //设置某一页的查询结果
        int start = (pb.getCurrentPage() - 1) * pb.getRows();
        List<Movie> list = dao.findMovieByPage(start, pb.getRows(), conditions);
        pb.setList(list);

        return pb;
    }*/

    //分页条件查询
    @Override
    public PageBean<Movie> findMovieByPage(String _currentPage, String _rows, Map<String, String[]> conditions) {
        PageBean<com.sample.Movie> pb = new PageBean<>();
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //设置总记录数
        //判断条件是否为空
        boolean flag = true;
        Set<String> keySet = conditions.keySet();
        for (String key : keySet){
            if (key != "currentPage" || key != "rows"){
                //得到条件的值
                String value = conditions.get(key)[0];
                if("".equals(value) || value == null){
                    flag = false;
                }
            }
        }

        int totalCount = 0;
        //如果条件不为空
        if (!flag){
            totalCount = dao.findMovieCountByConditions(conditions);
            pb.setTotalCount(totalCount);
            System.out.println("符合条件的总记录数"+totalCount);
        }else{
            //如果条件为空
            totalCount = dao.findMovieTotalCount();
            pb.setTotalCount(totalCount);
            System.out.println("当前总记录数"+totalCount);
        }

        //设置总页码数
        int totalPages = (totalCount % rows) == 0 ? (totalCount / rows) : (totalCount / rows) + 1;
        pb.setTotalPage(totalPages);

        //设置某一页的查询结果
        int start = (currentPage - 1) * rows;
        List<Movie> list = dao.findMovieByPage(start, rows, conditions);
        pb.setList(list);

        return pb;
    }

    @Override
    public void addMovie(Movie movie) {
        dao.addMovie(movie);
    }

    @Override
    public int findMovieCount() {
        return dao.findMovieTotalCount();
    }

    @Override
    public void delMovie(int movieId) {
        dao.delMovie(movieId);
    }

    @Override
    public Movie findMovie(int movieId) {
        return dao.findMovie(movieId);
    }

    @Override
    public void updateMovie(Movie movie) {
        dao.updateMovie(movie);
    }

    @Override
    public void delSelectedMovie(String[] movieIds) {
        if (movieIds != null && movieIds.length > 0){
            for (String s : movieIds){
                int movieId = Integer.parseInt(s);
                dao.delMovie(movieId);
            }
        }
    }
}
