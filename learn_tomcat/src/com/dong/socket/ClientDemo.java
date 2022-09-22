package com.dong.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author dfx
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        //1.创建一个客户端对象，构造方法绑定客户端的IP和端口号
        Socket socket = new Socket("127.0.0.1", 9900);
        //2.使用socket获取网络字节输出流对象
        OutputStream os = socket.getOutputStream();
        //3.使用write方法给服务器发送数据
        os.write("客户端 发送给 服务器：你好啊服务器！".getBytes());
        //4.使用socket获取网络字节输入对象
        InputStream is = socket.getInputStream();

        //5.使用read方法获取服务器回写的数据
        while (true){

            byte[] bytes = new byte[1024];
//        int len;
//        while ((len = is.read(bytes)) != -1){
//            System.out.println(new String(bytes,0,len));
//        }

            int len = is.read(bytes);
            System.out.println(new String(bytes,0,len));
        }

        //6.释放资源
//        socket.close();

    }
}
