package com.dong.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author dfx
 */
public class JDBCDemo2 {
    public static void main(String[] args){
        Statement stmt = null;
        Connection conn = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取connection对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db4?serverTimezone=GMT", "root", "123456");
            //3.获取执行sql的statement对象
            stmt = conn.createStatement();
            //4.定义SQL语句
            String sql = "insert into account values(null,'wangwu',800);";
            //5.执行SQL语句
            int count = stmt.executeUpdate(sql);
            //6.处理结果
            System.out.println(count);
            if (count > 0){
                System.out.println("添加数据成功");
            }else{
                System.out.println("添加数据失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //7.释放资源 避免空指针异常
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
