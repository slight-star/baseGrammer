package com.dong.jdbc;

import java.sql.*;

/**
 * @author dfx
 */
public class JDBCDemo6 {
    public static void main(String[] args) {
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.使用驱动管理类，获取数据库连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db4?serverTimezone=GMT", "root", "123456");
            //3.获取sql处理对象
            stmt = conn.createStatement();
            //4.定义sql语句
            String sql = "select * from account;";
            //5.执行sql语句
            rs = stmt.executeQuery(sql);
            //6.处理结果
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double balance = rs.getDouble("balance");
                System.out.println(id+"--------"+name+"--------"+balance);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
