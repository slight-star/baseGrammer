package com.dong.IOAndSocket;

import com.dong.domain.Student;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author dfx
 */
public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        Student stu = new Student();
        stu.setName("小明");
        ObjectOutputStream oop = new ObjectOutputStream(new FileOutputStream("learn_tomcat\\src\\student.txt"));
        oop.writeObject(stu);
        oop.close();
    }
}
