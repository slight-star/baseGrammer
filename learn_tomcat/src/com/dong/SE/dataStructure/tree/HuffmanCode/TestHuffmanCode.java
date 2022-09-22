package com.dong.SE.dataStructure.tree.HuffmanCode;

import java.io.*;
import java.util.*;

/**
 * @author dfx
 */
public class TestHuffmanCode {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        String s = "can you can a can as a can canner can a can.";
//        byte[] bytes = s.getBytes();
//        System.out.println(new String(bytes));
//        //哈夫曼编码
//        byte[] b = huffmanZip(bytes);
//        System.out.println(new String(b));//不解码的话，输出来是乱码
//        //解码
//        byte[] newBytes = decode(b,huffCodes);
//        System.out.println(new String(newBytes));

        //压缩
        String src = "learn_tomcat/src/com/dong/SE/dataStructure/tree/HuffmanCode/1.png";
        String zipDst = "learn_tomcat/src/com/dong/SE/dataStructure/tree/HuffmanCode/2.zip";
        zipFile(src,zipDst);
        String unzipDst = "learn_tomcat/src/com/dong/SE/dataStructure/tree/HuffmanCode/3.png";
        unzipFile(zipDst, unzipDst);


    }

    private static void unzipFile(String zipDst, String unzipDst) throws IOException, ClassNotFoundException {
        //创建一个对象输入流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(zipDst));
        //获取byte数组
        byte[] b = (byte[])ois.readObject();
        //获取哈夫曼编码表
        Map<Byte,String> huffCodes = (Map<Byte, String>) ois.readObject();
        ois.close();
        ois.close();
        //解码
        byte[] decodeBytes = decode(b, huffCodes);
        //创建输出流
        FileOutputStream fos = new FileOutputStream(unzipDst);
        //写出数据
        fos.write(decodeBytes);
        fos.close();
    }

    /**
     * 压缩文件
     * @param src
     * @param dst
     * @throws IOException
     */
    public static void zipFile(String src, String dst) throws IOException {
        //创建输入流获取源文件
        FileInputStream fis = new FileInputStream(src);
        //创建一个和输入流指向的文件大小一样的byte数组
        byte[] bytes = new byte[fis.available()];
        //读取文件内容
        fis.read(bytes);
        fis.close();
        //使用哈夫曼编码进行编码
        byte[] byteZip = huffmanZip(bytes);
        System.out.println(bytes.length);
        System.out.println(byteZip.length);
        //创建输出流输出编码后的文件
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dst));
        //把压缩后的byte数组写入文件
        oos.writeObject(byteZip);
        //把哈夫曼编码表写入文件
        oos.writeObject(huffCodes);
        oos.close();
        oos.close();
    }

    /**
     * 解码
     * @param bytes
     * @param huffCodes  编码时生成的，哈夫曼编码表
     * @return
     */
    private static byte[] decode(byte[] bytes,Map<Byte,String> huffCodes){
        //把byte数组转为二进制字符串
        StringBuilder sb = new StringBuilder();
//        for (byte b : bytes){
//            //将十进制 转成二进制
////            String s = Integer.toBinaryString(b);
////            System.out.println(s);
//
//            sb.append(byteToBitStr(b));
//        }
        for (int i = 0; i<bytes.length; i++){
            byte b = bytes[i];
            //是否是最后一个
            boolean flag = (i==bytes.length-1);
            sb.append(byteToBitStr(!flag,b));
        }
        System.out.println(sb.toString());
        //把字符串按照指定的哈夫曼编码解码
        //把哈夫曼编码的键值对进行调换
        Map<String,Byte> map = new HashMap<>();
        for (Map.Entry<Byte,String> entry : huffCodes.entrySet()){
            map.put(entry.getValue(), entry.getKey());
        }
        //创建一个集合，用于存byte
        List<Byte> list = new ArrayList<>();
        //处理字符串
        for (int i = 0; i < sb.length();){
            int count = 1;
            boolean flag = true;
            Byte b = null;
            //截取出一个byte
            while (flag){
                String key = sb.substring(i, i + count);
                b = map.get(key);
                if (b == null){
                    //没有对应的编码
                    count++;
                }else {
                    //有对应的编码，已获得
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        //把集合转为数组
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++){
            b[i] = list.get(i);
        }
        return b;
    }

    /**
     * 将十进制数，转成8位的二进制数。因为byte的整数补码
     * 负数前面都是1（全长32位太长了），我们只要后8位
     * 正数前面都是0，前面的0不显示，后面可能不满8位,我们要添0补全8位
     * @param flag  是否补0
     * @param b
     * @return
     */
    private static String byteToBitStr(boolean flag, byte b){
        int temp = b;
        if (flag){
            temp |= 256; //对256取或运算 因为 1 0000 0000 或是有1则为1
            String str = Integer.toBinaryString(temp);
            return str.substring(str.length()-8); //取最后8位
        }else {
            //不补0
            return Integer.toBinaryString(temp);
        }


    }


    /**
     * 编码压缩
     * @param bytes
     * @return
     */
    private static byte[] huffmanZip(byte[] bytes) {
        //先统计每个byte出现的次数，并放入一个集合中
        List<Node> nodes = getNodes(bytes);
        System.out.println(nodes);
        //创建一个哈夫曼树
        Node huffmanTree = createHuffmanTree(nodes);
        System.out.println(huffmanTree);
        //进行哈夫曼编码
        //创建哈夫曼编码表
        Map<Byte,String> huffCodes = getCodes(huffmanTree);
        System.out.println(huffCodes);
        //编码
        byte[] zip = zip(bytes, huffCodes);

        return zip;
    }

    private static byte[] zip(byte[] bytes, Map<Byte, String> huffCodes) {
        //将需要压缩的byte数组处理成一个二进制的字符串
//        String s = new String(bytes);
//        System.out.println(s);
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes){
            sb.append(huffCodes.get(b));
        }
        //定义一个新的byte数组
        //先确定长度
        int len ;
        if (sb.length() % 8 == 0){
            len = sb.length() / 8;
        }else{
            len = sb.length() / 8 + 1;
        }
//        System.out.println(sb);
        //用于存储压缩后的byte
        byte[] zip = new byte[len];
        //将每8位二进制转为数字
        int index = 0;
        for (int i = 0; i < sb.length(); i += 8){
            String strByte;
            if (i + 8 > sb.length()){
                strByte = sb.substring(i,sb.length());
            }else {
                strByte = sb.substring(i, i+8);
            }
            byte byt = (byte)Integer.parseInt(strByte,2);//将字符串按照二进制转换成十进制数
            System.out.println(strByte + " " + byt);
            //存储进新数组
            zip[index] = byt;
            index++;
        }

        return zip;
    }

    static StringBuilder sb = new StringBuilder();
    static Map<Byte,String> huffCodes = new HashMap<>();

    private static Map<Byte,String> getCodes(Node huffmanTree) {
        if (huffmanTree == null){
            return null;
        }
        getCodes(huffmanTree.getLeft(),"0",sb);
        getCodes(huffmanTree.getRight(),"1",sb);
        return huffCodes;
    }

    private static void getCodes(Node node, String code, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder(sb);
        sb2 = sb2.append(code);
        if (node.getData() == null) {
            //说明不是叶子结点
            getCodes(node.getLeft(),"0",sb2);
            getCodes(node.getRight(),"1",sb2);
        }else{
            //是叶子节点
            huffCodes.put(node.getData(),sb2.toString());
        }
    }

    //创建哈夫曼树
    private static Node createHuffmanTree(List<Node> nodes) {
        //循环为所有节点的权重进行排序，每次取最小的两个组成新子树
        while (nodes.size() > 1){
            Collections.sort(nodes);
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            //组成新子树
            Node parent = new Node(null,left.getWeight()+right.getWeight());
            parent.setLeft(left);
            parent.setRight(right);
            //添加到子树列表中
            nodes.add(parent);
            //删除前两个节点
            nodes.remove(left);
            nodes.remove(right);
        }
        return nodes.get(0);
    }

    /**
     * 将bytes数组转换为node集合
     * @param bytes
     * @return
     */
    private static List<Node> getNodes(byte[] bytes) {
        ArrayList<Node> nodes = new ArrayList<>();
        //统计每个byte出现了多少次
        HashMap<Byte, Integer> map = new HashMap<>();
        for (byte b : bytes){
            Integer count = map.get(b);
            if (count != null){
                map.put(b,++count);
            }else {
                map.put(b,1);
            }
        }
        //把每一个键值对转为一个node对象
        for (Map.Entry<Byte,Integer> entry : map.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }
}
