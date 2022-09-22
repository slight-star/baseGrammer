package com.dong.IOAndSocket;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author dfx
 */
public class CopyDirectory {
    public static void main(String[] args) {
        String sourcePath = "E:\\百度文库";
        String targetPath = "D:\\百度文库复制";

        try {
            copyDirectory(sourcePath,targetPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyDirectory(String sourcePath, String targetPath) throws IOException {

        //遍历源路径下的所有文件
        File sourceDir = new File(sourcePath);
        File[] files = sourceDir.listFiles();
        for (File file : files){
            System.out.println("原路径："+sourcePath);
            if (file.isDirectory()){
                new File(targetPath,file.getName()).mkdirs();
                copyDirectory(file.getPath(),targetPath+File.separator+file.getName());
            }else{
//                String sourceParent = "";
//                if (sourcePath.contains(".")){
//                    sourceParent = file.getParent();
//                }else{
//                    sourceParent = sourcePath;
//                }
//
//                System.out.println("原文件夹"+sourceParent);
//                String s = sourceParent.replace(sourcePath,targetPath);
//                System.out.println(s+" ->"+sourcePath+" "+targetPath);
//                String targetParent = sourceParent.replace(sourcePath,targetPath);
//                System.out.println("复制后的路径"+targetParent);

//                FileInputStream fis = new FileInputStream(new File(sourceParent,file.getName()));
//                new File(targetParent).mkdirs();
//                FileOutputStream fos = new FileOutputStream(new File(targetParent,file.getName()));

                    FileInputStream fis = new FileInputStream(file);
                    FileOutputStream fos = new FileOutputStream(new File(targetPath, file.getName()));

                    byte[] bytes = new byte[1024];
                    int len = 0;
                    while ((len = fis.read(bytes)) != -1){
                        fos.write(bytes,0,len);
                }

                fos.close();
                fis.close();
                System.out.println();
            }
        }
    }

    private static void bianliFile(String sourcePath, String targetPath) {
        //遍历源路径下的所有文件
        File sourceDir = new File(sourcePath);
        File[] files = sourceDir.listFiles();
        for (File file : files){
            if (file.isDirectory()){
                bianliFile(file.getPath(),targetPath);
            }
            if (file.isFile()){
                System.out.println(file.getParent()+" "+file.getName());
                String targetParent = file.getPath();
                targetParent = targetParent.replace(sourcePath,targetPath);
                System.out.println(targetParent);
            }
        }
    }
}
