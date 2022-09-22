package com.dong.servlet;

import com.dong.service.ProvinceService;
import com.dong.service.serviceImpl.ProvinceServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author dfx
 */
@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProvinceService service = new ProvinceServiceImpl();
//        List province = service.findProvince();
//
//        //将数据序列化为json
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(province);
//        System.out.println(json);

        String json = service.findAllJson();//缓存
        System.out.println(json);

        //响应结果
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);

//        request.setAttribute("province",province);
//        request.getRequestDispatcher("/province.html").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
