package com.dong.base.IO;

import org.junit.Test;

import java.io.*;

public class FileIInputOutputStreamTest {

    // 使用字节流处理FileInputStream可能出现乱码
    @Test
    public void testFileInputStream() throws IOException {
        FileInputStream fis = null;
        try {
            // 1.造文件
            File file = new File("hello.txt");
            // 2.造流
            fis = new FileInputStream(file);
            // 3.读数据
            byte[] buffer = new byte[10];
            int len;//记录每次读取的长度
            while((len = fis.read(buffer)) != -1){
                String str = new String(buffer, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭流
            try {
                if(fis != null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void testPic() throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File("无标题.png");
            File destFile = new File("无标题1.png");

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            byte[] buffer = new byte[5];
            int len;
            while((len = fis.read(buffer)) != -1){
                String str = new String(buffer);
                System.out.print(str);
                fos.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis != null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fis != null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
