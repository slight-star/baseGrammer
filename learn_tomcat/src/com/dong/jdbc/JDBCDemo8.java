package com.dong.jdbc;

import com.dong.domain.Student;
import com.dong.util.JDBCUtils1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dfx
 */
public class JDBCDemo8 {
    public static void main(String[] args) {
        List<Student> list = new JDBCDemo8().findAll();
        System.out.println(list);
        System.out.println(list.size());
        for (Student stu: list){
            System.out.println(stu);
        }
        System.out.println("------------------");
        list = new JDBCDemo8().findAll2();
        System.out.println(list);
        System.out.println(list.size());
        for (Student stu: list){
            System.out.println(stu);
        }
    }

    /**
     * 查询所有student对象
     */
    public List<Student> findAll(){
        List<Student> list = new ArrayList<Student>();
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.使用驱动管理类，连接数据库
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db4?serverTimezone=GMT", "root", "123456");
            //3.创建sql处理对象
            stmt = conn.createStatement();
            //4.定义sql语句
            String sql = "select * from student;";
            //5.执行SQL语句
            rs = stmt.executeQuery(sql);
            //6.处理结果
            Student stu = null;
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                double score = rs.getDouble("score");
                Date birthday = rs.getDate("birthday");
                Timestamp insert_time = rs.getTimestamp("insert_time");
                String sex = rs.getString("sex");
                //创建student对象
                stu = new Student();
                stu.setId(id);
                stu.setName(name);
                stu.setAge(age);
                stu.setScore(score);
                stu.setBirthday(birthday);
                stu.setInsert_time(insert_time);
                stu.setSex(sex);

                //装载集合
                list.add(stu);
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

        return list;
    }

    public List<Student> findAll2(){
        List<Student> list = new ArrayList<Student>();
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;
        try {
//            //1.注册驱动
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            //2.使用驱动管理类，连接数据库
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db4?serverTimezone=GMT", "root", "123456");
            conn = JDBCUtils1.getConnection();

            //3.创建sql处理对象
            stmt = conn.createStatement();
            //4.定义sql语句
            String sql = "select * from student;";
            //5.执行SQL语句
            rs = stmt.executeQuery(sql);
            //6.处理结果
            Student stu = null;
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                double score = rs.getDouble("score");
                Date birthday = rs.getDate("birthday");
                Timestamp insert_time = rs.getTimestamp("insert_time");
                String sex = rs.getString("sex");
                //创建student对象
                stu = new Student();
                stu.setId(id);
                stu.setName(name);
                stu.setAge(age);
                stu.setScore(score);
                stu.setBirthday(birthday);
                stu.setInsert_time(insert_time);
                stu.setSex(sex);

                //装载集合
                list.add(stu);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUtils1.close(rs,stmt,conn);
        }

        return list;
    }

}
