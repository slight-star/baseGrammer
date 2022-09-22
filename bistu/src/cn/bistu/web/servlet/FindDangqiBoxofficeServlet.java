package cn.bistu.web.servlet;


import cn.bistu.dao.MovieDaoImpl;
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
@WebServlet("/findDangqiBoxofficeServlet")
public class FindDangqiBoxofficeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String year = request.getParameter("year");
        List dangqiBoxoffice = new MovieDaoImpl().findDangqiBoxoffice(Integer.parseInt(year));
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(dangqiBoxoffice);
//        System.out.println(json);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
