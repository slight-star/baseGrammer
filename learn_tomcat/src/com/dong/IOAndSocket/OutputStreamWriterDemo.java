package com.dong.IOAndSocket;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author dfx
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) throws IOException {
        write_gbk();
        write_utf_8();
    }

    private static void write_utf_8() throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("learn_tomcat\\src\\UTF8_demo.txt"),"utf8");
        osw.write("你好!");
        osw.close();
    }

    private static void write_gbk() throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("learn_tomcat\\src\\我是GBK文件.txt"),"gbk");
        osw.write("你好!112397989997");
        osw.close();
    }
}
