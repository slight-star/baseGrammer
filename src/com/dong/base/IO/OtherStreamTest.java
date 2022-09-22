package com.dong.base.IO;

import org.junit.Test;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class OtherStreamTest {

    @Test
    public void test1(){
        Scanner sc = new Scanner(System.in);
        String str = "";
        while(true){
            System.out.println("请输入");
            str = sc.nextLine();
            if ("e".equalsIgnoreCase(str) || "exit".equalsIgnoreCase(str)){
                System.out.println("程序结束");
                break;
            }
            str = str.toUpperCase(Locale.ROOT);
            System.out.println(str);
        }
        return;
    }

    @Test
    public void test2(){
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            while(true){
                System.out.println("请输入字符串：");
                String str = br.readLine();
                if("e".equalsIgnoreCase(str) || "exit".equalsIgnoreCase(str)){
                    System.out.println("程序结束！");
                    break;
                }else{
                    System.out.println(str.toUpperCase(Locale.ROOT));
                }
            }
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

        return;
    }

    @Test
    public void test3(){
//        把原来在控制台的输出弄到文件中
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("E:\\io\\text.txt"),true);

            ps = new PrintStream(fos);
            if (ps != null){
                System.setOut(ps);
            }

            for (int i =0; i <= 255; i++){
                System.out.print((char)i);
                if (i % 50 == 0){
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null){
                try {
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void myInput(){

    }
}
