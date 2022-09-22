package com.dong.SE.digui;

import java.io.File;

/**
 * @author dfx
 */
public class FileDiguiDemo {
    public static void main(String[] args) {
        File path = new File("learn_tomcat\\src");
//        bianliFile(path);
        searchFile(path);
    }

    private static void bianliFile(File path){
        File[] files = path.listFiles();
        for (File file:files){
            System.out.println(file);
            if (file.isDirectory()){
                bianliFile(file);
            }
        }
    }

    private static void searchFile(File path){
        File[] files = path.listFiles();
        for (File file:files){
            if (file.getPath().endsWith(".java")){
                System.out.println(file);
            }
            if (file.isDirectory()){
                searchFile(file);
            }
        }
    }
}
