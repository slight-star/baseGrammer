package com.dong.IOAndSocket;

import java.io.*;

/**
 * @author dfx
 */
public class TransDemo {
    public static void main(String[] args) throws IOException {
        InputStreamReader isw = new InputStreamReader(new FileInputStream("learn_tomcat\\src\\我是GBK文件.txt"), "GBK");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("learn_tomcat\\src\\我是utf8文件.txt"), "utf8");
        char[] chars = new char[2];
        int len;
        while ((len = isw.read(chars)) != -1){
            System.out.println(chars);
            osw.write(chars,0,len);
        }

        osw.close();
        isw.close();

    }
}
