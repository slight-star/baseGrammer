package com.dong.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * @author dfx
 */
@WebServlet("/requestDemo6")
public class requestDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //根据参数名获取参数值
//        String username = request.getParameter("username");
//        System.out.println(username);
        //根据参数名获取参数值数组
//        String[] hobbies = request.getParameterValues("hobby");
//        for (String hobby : hobbies) {
//            System.out.println(hobby);
//        }
        //获取所有请求的参数名称
//        Enumeration<String> parameterNames = request.getParameterNames();
//        while (parameterNames.hasMoreElements()){
//            String s = parameterNames.nextElement();
//            System.out.println(s);
//            String value = request.getParameter(s);
//            System.out.println(value);
//            System.out.println("--------");
//        }

        //获取所有参数与值
        Map<String, String[]> parameterMap = request.getParameterMap();
//        //遍历
//        Set<String> keySet = parameterMap.keySet();  //获取所有键组成的集合
//        for (String name: keySet){
//            System.out.println(name);
//            //根据键获取值
//            String[] values = parameterMap.get(name);
//            for (String value: values){
//                System.out.println(value);
//            }
//        }

        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        System.out.println(entries.toString());
        System.out.println("-----------");
        for (Map.Entry<String, String[]> entry: entries){
            System.out.println(entry.getKey());
            for (String value: entry.getValue()){
                System.out.println(value);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
