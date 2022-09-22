package com.dong.datasource.druid;

/**
 * @author dfx
 */

import com.dong.util.JDBCUtils2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用新的工具类
 */
public class DruidDemo2 {
    public static void main(String[] args) {
        /**
         * 给account表添加一条数据
         */
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            //1.获取数据库链接
            conn = JDBCUtils2.getConnection();
            //2.定义sql
            String sql = "insert into account values(null,?,?);";
            //3.创建sql执行对象
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"王五");
            pstmt.setDouble(2,888);
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUtils2.close(pstmt, conn);
        }

    }
}
