package com.dong.servlet;

import com.dong.dao.UserDao;
import com.dong.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author dfx
 */
@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //设置响应的格式为json
//        response.setContentType("application/json;charset=utf-8");
        String username = request.getParameter("username");
        User user = new User();
        user.setUsername(username);
        User findeUser = new UserDao().findUsername(user);

        HashMap<String, Object> map = new HashMap<>();
        if (findeUser == null){
            map.put("userExist",false);
            map.put("msg","可用");
        }else{
            map.put("userExist",true);
            map.put("msg","此用户名已存在");
        }

        //将map转为json,然后传给客户端
        ObjectMapper mapper = new ObjectMapper();

//        mapper.writeValue(response.getWriter(),map); //这样也可以，response.getWriter() 就是一个输出流
        String json = mapper.writeValueAsString(map);

        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
