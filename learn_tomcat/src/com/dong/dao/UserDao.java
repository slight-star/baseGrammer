package com.dong.dao;

/**
 * @author dfx
 */

import com.dong.domain.User;
import com.dong.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 操作数据库中user表的类
 */
public class UserDao {

    /**
     * 创建JDBCTemplate对象,共用连接池
     */
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());



    /**
     * 登录方法
     * @param loginuser
     * @return
     */
    public User login(User loginUser){
        //1.编写sql
        String sql = "select * from user where username = ? and password = ?";
        //2.调用query方法
        User user = null;
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginUser.getUsername(), loginUser.getPassword());
            System.out.println("开始登录");
        } catch (DataAccessException e) {
//            e.printStackTrace();
            return null;
        }
        return user;

    }


    public User findUsername(User loginUser){
        //1.编写sql
        String sql = "select * from user where username = ? ";
        //2.调用query方法
        User user = null;
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginUser.getUsername());
        } catch (DataAccessException e) {
//            e.printStackTrace();
            return null;
        }
        return user;

    }

    public void addUser(User user) {
        String sql = "insert into user(username,password) values(?,?) ";
        int update = template.update(sql, user.getUsername(), user.getPassword());
    }
}
