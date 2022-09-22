package com.dong.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author dfx
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        //1.创建服务器ServerSocket对象,指定端口号
        ServerSocket server = new ServerSocket(9900);
        //2.使用serverSocket对象的accept方法，获取客户端对象
        Socket socket = server.accept();
        //3.使用客户端对象获取字节输入流
        InputStream is = socket.getInputStream();

        while (true){
            //4.使用read获取客户端发送的对象
            byte[] bytes = new byte[1024];
//        int len;
//        while ((len = is.read(bytes)) != -1){
//            System.out.println(new String(bytes,0,len));
//        }
            int len = is.read(bytes);
            System.out.println(new String(bytes,0,len));
            //5.使用客户端获取字节输出对象
            OutputStream os = socket.getOutputStream();
            //6.使用write给客户端回写数据
            os.write("服务器 发送 客户端：你好啊客户端".getBytes());

        }
        //7.释放资源
//        socket.close();
//        server.close();

    }
}
