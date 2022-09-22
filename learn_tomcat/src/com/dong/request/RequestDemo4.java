package com.dong.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author dfx
 */
@WebServlet("/requestDemo4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 演示获取请求头数据:referer
        String referer = req.getHeader("referer");
        System.out.println(referer);
        //防盗链
        if (referer != null){
            if (referer.contains("learn_tomcat")){
                //正常访问
//                System.out.println("播放电影");
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().write("可以播放电影");
            }else{
                //盗链
//                System.out.println("想看吗，来优酷吧");
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().write("想看吗，来优酷吧");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
