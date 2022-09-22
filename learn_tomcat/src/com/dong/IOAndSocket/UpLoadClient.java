package com.dong.IOAndSocket;

import java.io.*;
import java.net.Socket;

/**
 * @author dfx
 */
public class UpLoadClient {
    public static void main(String[] args) throws IOException {
        //1.声明客户端对象
        Socket socket = new Socket("127.0.0.1", 9900);
        //2.声明文件输入流对象
//        File file = new File("D:\\uploads");
//        if (!file.exists()){
//            file.mkdirs();
//        }
        FileInputStream fis = new FileInputStream("learn_tomcat\\src\\b.txt");
        //3.使用socket创建网络字节输出流对象
        OutputStream os = socket.getOutputStream();

        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1){
            os.write(bytes,0,len);
        }
        //上传完文件后，要给服务器写一个结束标记
        socket.shutdownOutput();

        //4.使用socket创建网络字节输出流对象,接受服务器回写的数据
        InputStream is = socket.getInputStream();
        while ((len = is.read(bytes)) != -1){
            System.out.println(new String(bytes,0,len));
        }

        fis.close();
        socket.close();

    }
}
