package com.dong.IOAndSocket;

import java.io.File;

/**
 * @author dfx
 */
public class FileDemo {
    public static void main(String[] args) {
        File file = new File("learn_tomcat\\src\\com\\dong");
        String[] list = file.list();
        for (String filename : list){
            System.out.println(filename);
        }

        System.out.println("********");
        File[] files = file.listFiles();
        for (File f:files){
            System.out.println(f);
        }
    }
}
