package com.dong.IOAndSocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dfx
 */
public class BS_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        ExecutorService es = Executors.newFixedThreadPool(1);
        //浏览器解析服务器回写的html页面，页面中如果有图片，那么浏览器就会单独开启一个线程，读取服务器的图片
        //我们就得让服务器一直处于监听状态，客户端请求一次，服务器就回写一次
        while (true){
            es.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName());
                        Socket socket = server.accept();
                        InputStream is = socket.getInputStream();
                        //将网络字节输入流转换为字符缓冲输入流
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        String line = br.readLine();
                        System.out.println(line);

                        //将第一行按 空格 划分
                        String[] arr = line.split(" ");
                        String htmlPath = arr[1].substring(1);

                        FileInputStream fis = new FileInputStream(htmlPath);
                        OutputStream os = socket.getOutputStream();
                        os.write("HTTP/1.1 200 OK\r\n".getBytes());
                        os.write("Content-Type:text/html;charset=utf-8\r\n".getBytes());
                        os.write("\r\n".getBytes());

                        byte[] bytes = new byte[1024];
                        int len;
                        while ((len = fis.read(bytes)) != -1){
                            os.write(bytes,0,len);
                        }
                        fis.close();
                        socket.close();
                    }catch (IOException e){
                        System.out.println(e);
                    }
                }
            });
        }

    }
}
