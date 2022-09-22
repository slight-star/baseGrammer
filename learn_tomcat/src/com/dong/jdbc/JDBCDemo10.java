package com.dong.jdbc;

import com.dong.util.JDBCUtils1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author dfx
 */
public class JDBCDemo10 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {
            //1.获取连接
            conn = JDBCUtils1.getConnection();
            //开启事务
            conn.setAutoCommit(false);
            //2.定义sql
            String sql1 = "update account set balance = balance - ? where id = ?";
            String sql2 = "update account set balance = balance + ? where id = ?";
            //3.创建执行sql对象
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            //4.传递参数
            pstmt1.setDouble(1,500);
            pstmt1.setDouble(2,1);

            pstmt2.setDouble(1,500);
            pstmt2.setDouble(2,2);
            //5.执行sql
            pstmt1.executeUpdate();
//            int i = 3/0;
            pstmt2.executeUpdate();
            //提交事务
            conn.commit();
        } catch (Exception e) {
            //回滚事务
            try {
                if (conn != null){
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtils1.close(pstmt1,conn);
            JDBCUtils1.close(pstmt2,null);
        }

    }
}
