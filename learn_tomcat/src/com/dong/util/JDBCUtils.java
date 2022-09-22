package com.dong.util;

/**
 * @author dfx
 */

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 使用druid连接池
 */
public class JDBCUtils {

    private static DataSource ds;

    static{
        //1.加载配置文件
        Properties pro = new Properties();
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        /*
        JDBCUtilsConfig.class是获得当前对象所属的class对象
        getClassLoader()是取得该Class对象的类装载器
        getResourceAsStream(“database.properties”) 调用类加载器的方法加载 资源，返回的是字节流
        使用Properties类是为了可以从.properties属性文件对应的文件输入流中，加载属性列表到Properties类对象，然后通过getProperty方法用指定的键在此属性列表中搜索属性
         */
        try {
            pro.load(is);
            //2.初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
    /**
     * 获取连接池对象
     */
    public static DataSource getDataSource(){
        return ds;
    }

    /**
     * 获取连接connection对象
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
