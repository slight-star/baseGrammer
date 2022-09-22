package com.dong.IOAndSocket;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * @author dfx
 */
public class UpLoadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9900);

        //让服务器一直处于监听状态
        while (true){
            Socket socket = server.accept();

            //使用多线程，提高程序效率
            new Thread(new Runnable() {
                @Override
                public void run() {
                    FileOutputStream fos = null;
                    try {
                        InputStream is = socket.getInputStream();

                        String fileName = "test"+System.currentTimeMillis()+ new Random().nextInt(99999);
                        fos = new FileOutputStream("learn_tomcat\\src\\statics\\"+fileName+".txt");
                        byte[] bytes = new byte[1024];
                        int len;
                        while ((len = is.read(bytes)) != -1){
                            fos.write(bytes,0,len);
                        }

                        OutputStream os = socket.getOutputStream();
                        os.write("服务器已收到,上传成功".getBytes());


                    }catch (IOException e){
                        System.out.println(e);
                    }finally{
                        if (fos != null){
                            try {
                                fos.close();
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
                    }
                }
            }).start();

        }
    }
}
