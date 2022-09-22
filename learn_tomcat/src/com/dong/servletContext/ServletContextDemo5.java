package com.dong.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author dfx
 */
@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //   域对象
        //1.也可以从httpServlet获取
        ServletContext context = this.getServletContext();

        String path1 = context.getRealPath("/b.txt");
        System.out.println(path1);
        File file = new File(path1);
        System.out.println(file);

        String path2 = context.getRealPath("/WEB-INF/c.txt");
        System.out.println(path2);
        file = new File(path2);
        System.out.println(file);

        FileInputStream fis = null;
        // 2.造流
        fis = new FileInputStream(file);
        // 3.读数据
        byte[] buffer = new byte[10];
        int len;//记录每次读取的长度
        while((len = fis.read(buffer)) != -1){
            String str = new String(buffer, 0, len);
            System.out.println(str);
        }

        String path3 = context.getRealPath("/WEB-INF/classes/a.txt"); //src目录下的资源访问
        System.out.println(path3);
        file = new File(path3);
        System.out.println(file);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
