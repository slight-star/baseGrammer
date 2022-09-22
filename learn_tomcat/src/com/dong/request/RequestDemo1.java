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
@WebServlet("/servletDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求方式      GET
        String method = request.getMethod();
        System.out.println(method);
        //2.获取虚拟目录      /learn_tomcat
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        //3.获取servlet路径     /servletDemo1
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        //4.获取get方式请求参数 name=456&password=678
        String queryString = request.getQueryString();
        System.out.println(queryString);
        //5.获取请求URI\URL     /learn_tomcat/servletDemo1
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        StringBuffer requestURL = request.getRequestURL(); //http://localhost/learn_tomcat/servletDemo1
        System.out.println(requestURL);
        //6.获取协议及版本     HTTP/1.1
        String protocol = request.getProtocol();
        System.out.println(protocol);
        //7.获取客户机的IP地址  0:0:0:0:0:0:0:1
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
    }
}
