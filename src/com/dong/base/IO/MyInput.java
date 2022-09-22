package com.dong.base.IO;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyInput {
    public static void main(String[] args) {
        MyInput mi = new MyInput();
        int a = readInt();
        System.out.println(a);
    }

    public static String readString(){
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String str = null;
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return str;
    }

    public static int readInt(){
        return Integer.parseInt(readString());
    }

    @Test
    public void test(){
        File f = new File("新建文本文档.txt");
        System.out.println(f.length());
    }
}
