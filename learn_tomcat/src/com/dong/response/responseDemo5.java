package com.dong.response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author dfx
 */
@WebServlet("/responseDemo5")
public class responseDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //告诉浏览器响应体的数据格式
        response.setContentType("text/html;charset=utf-8");
        //获取字节输出流
        ServletOutputStream sos = response.getOutputStream();
        //输出数据
        sos.write("你好啊 自己  response".getBytes("utf-8"));
        System.out.println();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
