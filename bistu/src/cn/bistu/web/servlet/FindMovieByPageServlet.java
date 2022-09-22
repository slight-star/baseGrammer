package cn.bistu.web.servlet;

import cn.bistu.domain.PageBean;
import cn.bistu.service.MovieService;
import cn.bistu.service.MovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author dfx
 */
@WebServlet("/findMovieByPageServlet")
public class FindMovieByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1.获取参数
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        if ("".equals(currentPage) || currentPage == null){
            currentPage = "1";
        }
        if ("".equals(rows) || rows == null){
            rows = "10";
        }

        //获取查询条件
        Map<String, String[]> conditions = request.getParameterMap();



        //2.创建并初始化，pageBean

        MovieService service = new MovieServiceImpl();
        PageBean<com.sample.Movie> pb = service.findMovieByPage(currentPage, rows, conditions);

        //3.将pb存入request
        request.setAttribute("pb", pb);
        request.setAttribute("conditions",conditions);

        //4.转发list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
