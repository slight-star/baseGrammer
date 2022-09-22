package com.dong.dao;

import com.dong.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author dfx
 */
public class MovieDao {
    /**
     * 创建jdbctemplate对象，共用连接池
     */
    private JdbcTemplate template =  new JdbcTemplate(JDBCUtils.getDataSource());


    /**
     * 查询每年的年度票房
     * @return
     */
    public List findYearBoxoffice(){
        //1.编写sql
        String sql = "select round(sum(总票房)/10000,2) as totalBoxoffice,年份 as year from movie where 年份>=2000 group by 年份 order by 年份";
        //2.调用query方法
        List<Map<String, Object>> maps = template.queryForList(sql);
//        System.out.println("dao:"+maps);
        return maps;
    }

    /**
     * 查询每年档期票房
     * @param year
     * @return
     */
    public List findDangqiBoxoffice(int year){
        String sql = "select round(sum(总票房)/10000,2) as totalBoxoffice,档期 from movie where 档期!='' and 年份 = ? " +
                "group by 档期 " +
                "order by field (档期,'元旦档','春节档','情人节档','妇女节档','清明档','五一档','端午档','六一档','暑期档','七夕档','中秋档','国庆档','贺岁档')";
        List<Map<String, Object>> maps = template.queryForList(sql,year);
        return maps;

    }

    /**
     * 查询每年上映数量
     * @return
     */
    public List findMovieCount() {
        String sql = "select count(*) as count,年份 as year from movie where 年份>=2000 group by 年份 order by 年份;";
        List<Map<String, Object>> maps = template.queryForList(sql);
        return maps;
    }

    /**
     * 查询每年前10电影
     * @param year
     * @return
     */
    public List findMovieTop(int year){
        String sql = "select 影片名称,总票房,年份 from movie where 年份=? order by 总票房 desc limit 10;";
        List<Map<String, Object>> maps = template.queryForList(sql, year);
        return maps;
    }

    public List findTypeTop() {
        String sql = "select count(*) as value,类型1 as name from movie group by 类型1 order by value desc limit 10;";
        List<Map<String, Object>> maps = template.queryForList(sql);
        return maps;
    }
}