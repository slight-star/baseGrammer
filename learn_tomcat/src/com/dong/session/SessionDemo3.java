package com.dong.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author dfx
 */
@WebServlet("/SessionDemo3")
public class SessionDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //希望浏览器关闭后，session也能相同

        //1.获取session
        HttpSession session = request.getSession();
        System.out.println(session);

        //2.设置cookie
        Cookie jsessionid = new Cookie("JSESSIONID", session.getId());
        //3.设置cookie存活时间
        jsessionid.setMaxAge(60*60);
        response.addCookie(jsessionid);
        session.setAttribute("msg","测试");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
