package com.dong.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dfx
 */
@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置相应的消息体的数据格式
        response.setContentType("text/html;charset=utf-8");
        //1.获取所有cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;//false表示没有lasttime 这个cookie
        //2.遍历所有cookie
        if (cookies != null && cookies.length != 0){
            for(Cookie cookie : cookies){
                //3.获取cookie名称
                String name = cookie.getName();
                //4.判断名称是否是 lastTime
                if ("lastTime".equals(name)){
                    flag = true;
                    //有该cookie，表示不是第一次访问
                    String value = cookie.getValue();
                    System.out.println("解码前："+value);
                    value = URLDecoder.decode(value, "utf-8");
                    System.out.println("解码后："+value);
                    response.getWriter().write("<h1>欢迎回来，您上次访问时间为："+value+"</h1>");

                    //获取当前时间的字符串
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String date_str = sdf.format(date);
                    //因为cookie值中有空格，使用url编码
                    System.out.println("编码前："+date_str);
                    date_str = URLEncoder.encode(date_str, "utf-8");
                    System.out.println("编码后："+date_str);

                    cookie.setValue(date_str);
                    //设置cookie的存活时间
                    cookie.setMaxAge(60*60*24*30);//一个月
                    response.addCookie(cookie);
                    break;
                }
            }
        }
        if (cookies == null || cookies.length == 0 || flag == false){
            System.out.println("第一次访问");
            //获取当前时间的字符串
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String date_str = sdf.format(date);
            System.out.println("编码前："+date_str);
            date_str = URLEncoder.encode(date_str, "utf-8");
            System.out.println("编码后："+date_str);
            Cookie cookie = new Cookie("lastTime", date_str);
            //设置cookie的存活时间
            cookie.setMaxAge(60*60*24*30);//一个月
            //添加cookie
            response.addCookie(cookie);

            //响应消息
            response.getWriter().write("<h1>您好，欢迎首次访问！</h1>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
