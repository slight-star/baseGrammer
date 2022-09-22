package com.dong.base.IO;

import org.junit.Test;

import java.io.*;
import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

public class copyTest {

    public static void main(String[] args) {
        String srcPath = "无标题.png";
        String destPath = "无标题_复制.png";

        long start = System.currentTimeMillis();
        testFileInputStreamFileOutputStreamCopy(srcPath,destPath);
        long end = System.currentTimeMillis();
        System.out.println(end-start);

        start = System.currentTimeMillis();
        testBufferedInputStreamBufferedOutputStreamCopy(srcPath,destPath);
        end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static void testFileInputStreamFileOutputStreamCopy(String srcPath, String destPath)  {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            byte[] buffer = new byte[5];
            int len;
            while((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void testBufferedInputStreamBufferedOutputStreamCopy(String srcPath, String destPath) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[5];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void encodeTest() throws IOException {
        File srcFile = new File("无标题.png");
        File destFile = new File("无标题_加密.png");

        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(destFile);

        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);


        int b = 0;
        while((b = bis.read()) != -1){
            bos.write(b ^ 5);
        }

        bis.close();
        bos.close();
    }

    @Test
    public void decodeTest() throws IOException {
        File srcFile = new File("无标题_加密.png");
        File destFile = new File("无标题_解密.png");

        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(destFile);

        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        int b = 0;
        while((b = bis.read()) != -1){
            bos.write(b ^ 5);
        }

        bis.close();
        bos.close();
    }

    @Test
    public void wordCount(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            File srcFile = new File("新建文本文档.txt");
            File destFile = new File("wordCount.txt");

            HashMap<Character, Integer> wordMap = new HashMap<>();

            FileReader fr = new FileReader(srcFile);
            FileWriter fw = new FileWriter(destFile);

            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);

            char[] cbuf = new char[1];
            int c;
            Integer value = new Integer(0);
            Character key;
            while((c = br.read(cbuf)) != -1){
//                key = (char)c;
                key = cbuf[0];
                if (wordMap.get(key) != null){
                    value = wordMap.get(key) + 1;
                    wordMap.put(key,value);
                }else{
                    wordMap.put(key,1);
                }
            }

//            bw.write(wordMap.toString());
            // 遍历map，再写入数据
            for (Map.Entry<Character, Integer> entry : wordMap.entrySet()) {
                switch(entry.getKey()){
                    case ' ':
                        bw.write("空格=" + entry.getValue());
                        break;
                    case '\t':
                        bw.write("tab键=" + entry.getValue());
                        break;
                    case '\r':
                        bw.write("回车=" + entry.getValue());
                        break;
                    case '\n':
                        bw.write("换行=" + entry.getValue());
                        break;
                    default:
                        bw.write(entry.getKey() + "=" + entry.getValue());
                        break;
                }
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bw != null){
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    @Test
    public void changeEncode(){
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            File srcFile = new File("新建文本文档.txt");
            File destFile = new File("新建文本文档GBK.txt");

            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            isr = new InputStreamReader(fis);
            osw = new OutputStreamWriter(fos,"GBK");

            char[] cbuf = new char[5];
            int len;
            while((len = isr.read(cbuf)) != -1){
                osw.write(cbuf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(isr != null){
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(osw != null){
                    osw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
