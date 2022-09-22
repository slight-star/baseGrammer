package com.dong.base.tcpudp;

import java.io.*;
import java.net.*;

//http://localhost:8080/examples/爱情与友情.jpg?username=Max
//协议    主机名     端口号        资源地址        参数列表
public class URLtest {
    public static void main(String[] args)  {
        HttpURLConnection urlConnection = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL url = null;
            url = new URL("http://localhost:8080/examples/"+ URLEncoder.encode("爱情与友情.jpg","utf-8")+"");
//            System.out.println(url.getProtocol());
//            System.out.println(url.getHost());
//            System.out.println(url.getPort());
//            System.out.println(url.getPath());
//            System.out.println(url.getQuery());
            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.connect();

            is = urlConnection.getInputStream();

            fos = new FileOutputStream(new File("从URL下载下来的图片.jpg"));
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[5];
            int len;
            while((len = is.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
            System.out.println("下载完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (urlConnection != null){
                urlConnection.disconnect();
            }
        }
    }
}
