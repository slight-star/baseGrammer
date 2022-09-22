package com.dong.servlet;

import com.dong.dao.UserDao;
import com.dong.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author dfx
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    //版本2
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //1.设置request编码
        request.setCharacterEncoding("utf-8");
        //2.获取参数map集合
        Map<String, String[]> map = request.getParameterMap();
        //3.使用JavaBean接受用户参数
        User user = new User();
        try {
            BeanUtils.populate(user,map);//这个方法会遍历map<key, value>中的key，如果bean中有这个属性，就把这个key对应的value值赋给bean的属性
        } catch (Exception e) {
            e.printStackTrace();
        }

        //5.比较用户名和密码
        User login = new UserDao().login(user);
        request.setAttribute("login_error","1");
        if (login == null){
            //转发到login.jsp
//            request.setAttribute("login_error","用户名或密码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            //用户名密码正确
            //重定向到首页，显示xxx欢迎您
            request.getSession().setAttribute("user",user.getUsername());
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }

        /*
        //4.获取验证码进行比较
        String checkCode_session = (String)request.getSession().getAttribute("checkCode_session");
//        System.out.println("输出session:"+checkCode_session);
        String checkCode = request.getParameter("checkCode");
        request.setAttribute("checkCodemsg","");
        if (!checkCode_session.equalsIgnoreCase(checkCode)){
            //如果不一致，重定向到login.jsp,重定向是两次请求，用session
            request.setAttribute("checkCodemsg","验证码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else{
            //5.比较用户名和密码
            User login = new UserDao().login(user);
            request.setAttribute("login_error","1");
            if (login == null){
                //转发到login.jsp
                request.setAttribute("login_error","用户名或密码错误！");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }else {
                //用户名密码正确
                //重定向到首页，显示xxx欢迎您
                request.getSession().setAttribute("user",user.getUsername());
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }
        }*/

    }
    /* 版本1
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取
        User loginUser = new User();
//        loginUser.setUsername(request.getParameter("username"));
////        loginUser.setPassword(request.getParameter("password"));
        //使用BeanUtils简化封装过程
        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(loginUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        User user = new UserDao().login(loginUser);
        if (user != null){
            //重定向
            request.setAttribute("user",user);
            request.getRequestDispatcher("successServlet").forward(request,response);
        }else{
            //重定向
            request.getRequestDispatcher("failServlet").forward(request,response);
        }
    }
    */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
