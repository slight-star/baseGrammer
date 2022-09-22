package com.dong.datasource.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author dfx
 */
public class DruidDemo1 {
    public static void main(String[] args) throws Exception {
        //1.加载配置文件
        InputStream is = DruidDemo1.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties pro = new Properties();
        pro.load(is);

//        URL res = DruidDemo1.class.getClassLoader().getResource("druid.properties");
//        String path = res.getPath();
//
//        Properties pro = new Properties();
//        pro.load(new FileReader(path));

        //2.获取连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);

        //3.获取连接
        Connection conn = ds.getConnection();
        System.out.println(conn);

    }
}
