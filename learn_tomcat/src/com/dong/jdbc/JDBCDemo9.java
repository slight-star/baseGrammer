package com.dong.jdbc;

import com.dong.util.JDBCUtils1;

import java.sql.*;
import java.util.Scanner;

/**
 * @author dfx
 */
public class JDBCDemo9 {

    public static void main(String[] args) {
        //1.键盘录入用户名和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        //2.调用登录方法
        boolean flag = new JDBCDemo9().login2(username,password);
        if (flag){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败,用户名或密码错误");
        }
    }

    public boolean login(String username, String password){
        //判断输入是否为空
        if (username == null || password == null){
            return false;
        }
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //1.获取连接
            conn = JDBCUtils1.getConnection();
            //2.获取处理sql的对象
            stmt = conn.createStatement();
            //3.定义sql
            String sql = "select * from user where username ='"+ username +"' and password = '"+ password +"'";
            //4.执行sql
            rs = stmt.executeQuery(sql);
            return rs.next();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils1.close(rs,stmt,conn);
        }
        return false;
    }


    /**
     * 使用preparedstatement登录
     * @param username
     * @param password
     * @return
     */
    public boolean login2(String username, String password){
        //判断输入是否为空
        if (username == null || password == null){
            return false;
        }
        Connection conn = null;
        PreparedStatement pstmt =  null;
        ResultSet rs = null;
        try {
            //1.获取连接
            conn = JDBCUtils1.getConnection();
            //3.定义sql
            String sql = "select * from user where username = ? and password = ?";
            //2.获取处理sql的对象
            pstmt = conn.prepareStatement(sql);
            //给?赋值
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            //4.pstmt执行sql,不需要传sql
            rs = pstmt.executeQuery();
            return rs.next();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils1.close(rs,pstmt,conn);
        }
        return false;
    }
}
