package cn.bistu.web.servlet;

import cn.bistu.domain.PageBean;
import cn.bistu.service.MovieService;
import cn.bistu.service.MovieServiceImpl;
import com.sample.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dfx
 */
@WebServlet("/addMovieServlet")
public class AddMovieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码格式
        request.setCharacterEncoding("utf-8");
        //2.获取数据
        String title = request.getParameter("title");
        String actor = request.getParameter("actor");
        String director = request.getParameter("director");
        String mainType = request.getParameter("mainType");
        String totalBoxoffice = request.getParameter("totalBoxoffice");
        String releaseDate = request.getParameter("releaseDate");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            parse = sdf.parse(releaseDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(parse);

        Movie movie = new Movie();

        movie.setTitle(title);
        movie.setActor(actor);
        movie.setDirector(director);
        movie.setMainType(mainType);
        movie.setTotalBoxoffice(Double.parseDouble(totalBoxoffice));
        movie.setReleaseDate(parse);
        movie.setYear(parse.getYear());
        //3.添加数据
        MovieService service = new MovieServiceImpl();
        service.addMovie(movie);

//        System.out.println(movie.getMovieId());
        //4.转发
        int movieCount = service.findMovieCount();
        int lastPage = movieCount % 10 == 0 ? movieCount/10 : movieCount/10 +1;
        response.sendRedirect(request.getContextPath()+"/findMovieByPageServlet?currentPage="+lastPage+ "&rows=10");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
