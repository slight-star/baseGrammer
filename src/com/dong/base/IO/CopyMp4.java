package com.dong.base.IO;

import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;

public class CopyMp4 {
    public static void main(String[] args) throws IOException {
        File srcFile = new File("E:\\B站视频\\670646175"); //源文件夹路径

        copyFolder(srcFile);
    }

    private static void copyFolder(File srcFile) throws IOException {
        // 判断该File是文件夹还是文件
        File[] files = srcFile.listFiles();
        System.out.println();
        for (File f : files) {
            // 如果是文件夹则递归调用
            if (f.isDirectory()){
                copyFolder(f);
            }else{
                //如果是文件则复制
                copyFile(f);
                System.out.println(f.getName());
            }
        }
    }

    // 用字节缓冲流实现文件复制
    private static void copyFile(File srcFile) throws IOException {
        FileInputStream fis = new FileInputStream(srcFile);
        BufferedInputStream bis = new BufferedInputStream(fis);

        File destFile = new File("E:\\B站视频\\VUE学习视频\\"+srcFile.getName());// 这里写目的文件夹路径
        FileOutputStream fos = new FileOutputStream(destFile);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        byte[] buffer = new byte[1024];
        int len = 0;
        while((len = bis.read(buffer)) != -1){
            bos.write(buffer,0,len);
        }

        bos.close();
        bis.close();


    }
}
