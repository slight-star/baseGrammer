package cn.bistu.web.servlet;

import cn.bistu.service.MovieService;
import cn.bistu.service.MovieServiceImpl;
import com.sample.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author dfx
 */
@WebServlet("/findMovieServlet")
public class FindMovieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String movieId = request.getParameter("movieId");
        MovieService service = new MovieServiceImpl();
        Movie movie = service.findMovie(Integer.parseInt(movieId));
        request.setAttribute("movie", movie);
        //转发
        request.getRequestDispatcher("/updateMovie.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
