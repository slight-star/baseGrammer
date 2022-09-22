package cn.bistu.web.listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author dfx
 */
@WebListener
public class ContextLoaderListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent){
        //服务器启动时启动
        //加载资源
        //1.获取servletContext对象
        ServletContext servletContext = servletContextEvent.getServletContext();

        //2.加载资源文件
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");

        //3.获取真实路径
        String realPath = servletContext.getRealPath(contextConfigLocation);

        //4.加载进内存
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(realPath);
            System.out.println(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if (fis != null){
                fis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("监听器启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent){
        System.out.println("监听器销毁");
    }
}
