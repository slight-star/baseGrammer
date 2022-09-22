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
import java.util.Map;

/**
 * @author dfx
 */
@WebServlet("/delMovieServlet")
public class delMovieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取id
        String Id = request.getParameter("movieId");
        System.out.println("********");
        System.out.println("删除："+Id);
        String _currentPage = request.getParameter("currentPage");
        System.out.println("当前页"+_currentPage);

//        Map<String, String[]> parameterMap = request.getParameterMap();
//        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()){
//            System.out.println(entry.getKey()+"  "+ Arrays.toString(entry.getValue()));
//        }

        int movieId = Integer.parseInt(Id);
        int currentPage = Integer.parseInt(_currentPage);

        //2.根据id删除
        MovieService service = new MovieServiceImpl();
        service.delMovie(movieId);

        //获取查询条件
        Map<String, String[]> conditions = request.getParameterMap();
        conditions.remove("currentPage");
        conditions.remove("rows");

        //3.获取删除的数据所在的那一页
        PageBean<Movie> pb = service.findMovieByPage(new Integer(currentPage).toString(), new Integer(10).toString(), conditions);

        //4.将pb存入request
        request.setAttribute("pb", pb);

        //5.转发list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
