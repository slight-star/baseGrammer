package cn.bistu.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author dfx
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 50;

        //1.创建一个对象，在内存中图片（验证码图片对象）
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //2.美化图片
        //2.1填充背景色
        Graphics g = image.getGraphics();//画笔对象
        g.setColor(Color.pink);//设置画笔颜色
        g.fillRect(0,0,width,height);

        //2.2画边框
        g.setColor(Color.yellow);
        g.drawRect(0,0,width-1,height-1);

        //2.3写验证码
        g.setColor(Color.yellow);
        g.setFont(new Font("黑体", Font.BOLD, 30));
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ012345689";
        Random random = new Random();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            sb.append(ch);
            g.drawString(ch+"",width/5*i, height/2);
        }
        String checkCode_session = sb.toString();
        //将验证码保存入session中
        request.getSession().setAttribute("checkCode_session",checkCode_session);
//        System.out.println(checkCode_session);
        System.out.println("设置的session:"+request.getSession().getAttribute("checkCode_session"));

        //2.4画线
        g.setColor(Color.RED);
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width-1)+1;
            int y1 = random.nextInt(height-1)+1;

            int x2 = random.nextInt(width-1)+1;
            int y2 = random.nextInt(height-1)+1;
            g.drawLine(x1,y1,x2,y2);

        }

        //3.将图片输出到页面展示
        ImageIO.write(image,"png",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
