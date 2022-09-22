package cn.bistu.web.servlet;

import cn.bistu.service.MovieService;
import cn.bistu.service.MovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author dfx
 */
@WebServlet("/delSelectedServlet")
public class DelSelectedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] movieIds = request.getParameterValues("movieId");
        MovieService service = new MovieServiceImpl();
        service.delSelectedMovie(movieIds);
        //重定向
        response.sendRedirect(request.getContextPath()+"/findMovieByPageServlet?currentPage=1&rows=10");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
