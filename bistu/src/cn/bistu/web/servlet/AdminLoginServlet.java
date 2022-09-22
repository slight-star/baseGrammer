package cn.bistu.web.servlet;

import cn.bistu.domain.AdminUser;
import cn.bistu.service.AdminUserService;
import cn.bistu.service.AdminUserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author dfx
 */
@WebServlet("/adminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("管理员开始登录");
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.校验验证码
        String verifycode = request.getParameter("verifycode");
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        //移除验证码session,确保一次性
        session.removeAttribute("checkCode_session");
        if (!verifycode.equalsIgnoreCase(checkCode_session)){
            //验证码不正确
            //提示信息
            request.setAttribute("login_msg", "验证码错误！");
            //跳转登录页面
            request.getRequestDispatcher("/jsps/admin/adminLogin.jsp").forward(request, response);
            return;
        }
        //3.获取表单数据，封装
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        AdminUser adminUser = new AdminUser(username, password);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        Map<String, String[]> map = request.getParameterMap();
        //使用BeanUtils封装
        AdminUser adminUser = new AdminUser();
        try {
            BeanUtils.populate(adminUser, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4.调用service,验证查询用户信息
        AdminUserService service = new AdminUserServiceImpl();
        AdminUser loginUser = service.login(adminUser);

        //5.转发
        if (loginUser != null){
            //登录成功
            //将用户存入session
            session.setAttribute("user", loginUser.getUsername());
            //重定向到首页  因为没有需要传递的数据，所以用重定向，跳到新页面
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }else{
            //登录失败
            //提示信息
            request.setAttribute("login_msg", "用户名或密码错误！");
            //跳转登录页面
            request.getRequestDispatcher("/jsps/admin/adminLogin.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
