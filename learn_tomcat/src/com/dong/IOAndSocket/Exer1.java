package com.dong.IOAndSocket;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Set;

/**
 * @author dfx
 */
public class Exer1 {
    public static void main(String[] args) throws IOException {
        //对文本中的每一行内容进行排序并输出到另一个文件
        //1.声明一个map
        long s = System.currentTimeMillis();
        HashMap<String, String> map = new HashMap<>();
        //2.声明字符输入输出缓冲流
        BufferedReader br = new BufferedReader(new FileReader("learn_tomcat\\src\\a.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("learn_tomcat\\src\\b.txt"));
        String line;
        while ((line = br.readLine()) != null){
            String[] arr = line.split("\\.");
            map.put(arr[0],arr[1]);
        }
        Set<String> keySet = map.keySet();
        for (String key : keySet){
            bw.write(map.get(key));
            bw.write("\r\n");
        }

        bw.close();
        br.close();

    }

    @Test
    public void test1() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src\\我是GBK文件.txt"));
        String line;
        while ((line = br.readLine())!=null){
            System.out.println(line);
        }

        br.close();
    }
}
