package com.dong.base.tcpudp;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 例题3：从客户端发送文件给服务器，服务端保存到本地，并返回“发送成功”给客户端，并关闭相应连接
 */
public class TCPtest3 {
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet,8899);

            os = socket.getOutputStream();

            FileInputStream fis = new FileInputStream(new File("无标题.png"));
            bis = new BufferedInputStream(fis);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1){
                os.write(buffer,0,len);
            }
            //关闭图片输出
            socket.shutdownOutput();

            //5.接受来自服务器端的数据，并显示在控制台上
            is = socket.getInputStream();
            //使用bytearray.. 防止显示时乱码
            baos = new ByteArrayOutputStream();
            byte[] buff = new byte[20];

            while((len = is.read(buff)) != -1){
                baos.write(buff,0,len);
            }
            System.out.println(baos.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void server()  {

        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        BufferedOutputStream bos = null;
        OutputStream os = null;
        try {
            ss = new ServerSocket(8899);
            //获取传过来的socket
            socket = ss.accept();
            //获取socket中的输入流
            is = socket.getInputStream();
            //读取输入流中的数据
            FileOutputStream fos = new FileOutputStream(new File("客户端传过来的图片2.png"));
            bos = new BufferedOutputStream(fos);
            byte[] buffer = new byte[5];
            int len;
            while((len = is.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
            System.out.println("图片传输完成");
            //6.服务器端给客户端反馈
            os = socket.getOutputStream();
            os.write("你好，照片已经收到".getBytes(StandardCharsets.UTF_8));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
