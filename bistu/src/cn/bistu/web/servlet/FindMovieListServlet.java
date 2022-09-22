package cn.bistu.web.servlet;

import cn.bistu.service.MovieService;
import cn.bistu.service.MovieServiceImpl;

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
@WebServlet("/findMovieListServlet")
public class FindMovieListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建movieService
        MovieService service = new MovieServiceImpl();
        //2.接收结果
        List movies = service.findMovieList();
//        System.out.println(movies);
        //3.将list存入request域
        request.setAttribute("movies", movies);
        //4.转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request, response);//转发不需要加虚拟目录
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
