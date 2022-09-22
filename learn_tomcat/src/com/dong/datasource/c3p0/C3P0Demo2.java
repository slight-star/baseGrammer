package com.dong.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author dfx
 */
public class C3P0Demo2 {
    public static void main(String[] args) throws SQLException {
        //1.获取DataSource，使用默认配置
        ComboPooledDataSource ds = new ComboPooledDataSource();
        //2.获取连接
        for (int i = 1; i<=11; i++){
            Connection conn = ds.getConnection();
            System.out.println(i + ": " + conn);
            if (i==5){
                conn.close();
            }
        }
    }

    @Test
    public void testNamedConfig() throws SQLException, InterruptedException {
        //1.获取DataSource,使用指定名称配置
        ComboPooledDataSource ds = new ComboPooledDataSource("otherc3p0");
        //2.获取连接
        for (int i = 0; i < 20; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i +": " + conn);
//            Thread.currentThread().sleep(2000);
            if (i==5){
                conn.close();
            }
        }
    }
}
