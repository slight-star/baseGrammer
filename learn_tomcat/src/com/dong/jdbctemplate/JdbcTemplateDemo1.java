package com.dong.jdbctemplate;

import com.dong.util.JDBCUtils2;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author dfx
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //1.创建template对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils2.getDataSource());
        //2.调用方法
        String sql = "update account set balance = ? where id = ?";
        int count = template.update(sql, 5000, 4);
        System.out.println(count);
    }
}
