package cn.bistu.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author dfx
 */
//@WebFilter(value = "/*",dispatcherTypes ={DispatcherType.FORWARD, DispatcherType.REQUEST})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //强制转换
        HttpServletRequest request = (HttpServletRequest) req;
        //获取请求或转发的uri
        String uri = request.getRequestURI();
        //判断是否是请求登录资源
        if (uri.contains("login") || uri.contains("CheckCodeServlet") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/img/")){
            //用户想要登录，放行
            chain.doFilter(req, resp);
        }else{
            //不是直接请求登录资源
            //判断是否一登录
            Object user = request.getSession().getAttribute("user");
            if (user != null){
                //已登录，放行
                chain.doFilter(req, resp);
            }else{
                //转发到登录页面，反馈您还未登录
                request.setAttribute("login_msg","您还未登录！");
                request.getRequestDispatcher("/jsps/user/login.jsp").forward(request,resp);
            }
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
