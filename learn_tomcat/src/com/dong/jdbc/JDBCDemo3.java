package com.dong.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author dfx
 */
public class JDBCDemo3 {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection conn = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.使用驱动管理类，获取数据库连接,得到数据库连接对象 static方法
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db4?serverTimezone=GMT", "root", "123456");
            //3.使用数据库连接对象，获取执行SQL对象
            stmt = conn.createStatement();
            //4.定义SQL语句
            String sql = "update account set balance = 1000 where name = 'wangwu';";
            //5.执行SQL语句
            int count = stmt.executeUpdate(sql);
            //6.处理结果
            System.out.println(count);
            if (count > 0){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (stmt != null){
                try {
                    stmt.close();
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
