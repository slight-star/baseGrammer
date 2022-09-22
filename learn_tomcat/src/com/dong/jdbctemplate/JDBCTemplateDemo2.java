package com.dong.jdbctemplate;

import com.dong.domain.Student;
import com.dong.util.JDBCUtils2;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author dfx
 */
public class JDBCTemplateDemo2 {
    @Test
    public void test1(){
        JdbcTemplate template = new JdbcTemplate(JDBCUtils2.getDataSource());
        String sql = "insert into Student(id,name,sex) values(?,?,?)";
        int count = template.update(sql, 666, "周星驰", "男");
        System.out.println(count);
    }

    @Test
    public void test2(){
        JdbcTemplate template = new JdbcTemplate(JDBCUtils2.getDataSource());
        String sql = "delete from student where id = ?";
        int count = template.update(sql, 666);
        System.out.println(count);
    }

    @Test
    public void test4(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils2.getDataSource());
        String sql = "select * from student where id = ?";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, 111);
        System.out.println(map);

    }

    @Test
    public void test5(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils2.getDataSource());
        String sql = "select * from student where id = ? or id = ?";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, 111, 222);
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
    }

    @Test
    public void test6(){
        JdbcTemplate template = new JdbcTemplate(JDBCUtils2.getDataSource());
        String sql = "select * from student";
        List<Student> list = template.query(sql, new BeanPropertyRowMapper<>(Student.class));
        for (Student student : list) {
            System.out.println(student);
        }
    }

    @Test
    public void test7(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils2.getDataSource());
        String sql = "select count(id) from student";
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(count);

    }
}
