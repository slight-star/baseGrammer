package com.dong.SE.digui;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/**
 * @author dfx
 */
public class FileFilterDemo {
    public static void main(String[] args) {
        File path = new File("learn_tomcat\\src");
//        filterFile(path);
        filterFile2(path);
    }

    private static void filterFile(File path) {
        File[] files = path.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory()) {
                    return true;
                }
                return pathname.getName().toLowerCase().endsWith(".java");
            }
        });

        for (File file : files){
            if (file.isFile()){
                System.out.println(file);
            }
            if (file.isDirectory()){
                filterFile(file);
            }
        }
    }

    private static void filterFile2(File path) {
        File[] files = path.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return dir.isDirectory() || name.toLowerCase().endsWith(".java");
            }
        });

//        for (File file : files){
//            if (file.isFile()){
//                System.out.println(file);
//            }
//            if (file.isDirectory()){
//                filterFile(file);
//            }
//        }
    }
}
