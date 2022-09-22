package com.dong.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author dfx
 */
public class JDBCDemo4 {
    public static void main(String[] args) {
        Statement statement = null;
        Connection conn = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.创建驱动管理对象，获取数据库连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db4?serverTimezone=GMT", "root", "123456");
            //3.获取sql处理对象
            statement = conn.createStatement();
            //4.定义SQL语句
            String sql = "delete from account where id = 3;";
            //5.执行SQL
            int count = statement.executeUpdate(sql);
            //6.处理结果
            System.out.println(count);
            if (count > 0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
