package cn.bistu.web.servlet;

import cn.bistu.service.MovieService;
import cn.bistu.service.MovieServiceImpl;
import com.sample.Movie;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

/**
 * @author dfx
 */
@WebServlet("/updateMovieServlet")
public class UpdateMovieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        //用javabean封装对象
        Movie movie = new Movie();
        //自己指定一个类型转换器（将String转成Date）
        DateConverter converter = new DateConverter();
        converter.setPattern(new String("yyyy-MM-dd"));
        ConvertUtils.register(converter,Date.class);
        try {
            BeanUtils.populate(movie, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        MovieService service = new MovieServiceImpl();
        service.updateMovie(movie);

        //重定向到列表页
        response.sendRedirect(request.getContextPath()+"/findMovieByPageServlet?currentPage=1&rows=10");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
