package com.dong.IOAndSocket;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author dfx
 */
public class ObjectInputStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("learn_tomcat\\src\\student.txt"));
        Object o = ois.readObject();
        System.out.println(o);
        ois.close();
    }
}
