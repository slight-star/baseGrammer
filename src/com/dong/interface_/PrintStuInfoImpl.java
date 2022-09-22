package com.dong.interface_;

import com.dong.base.Student;
import com.dong.interface_.PrintStuInfo;

public class PrintStuInfoImpl implements PrintStuInfo {
    @Override
    public void printStuInfo(Student stu) {
        System.out.println(stu.getId()+' '+stu.getName()+' '+stu.getAge()+' '+stu.getScore());
    }
}
