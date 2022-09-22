package com.dong.base;

import com.dong.interface_.PrintStuInfoImpl;

public class Application {
    public static void main(String[] args) {

        Student stu1 = new Student();
        Student stu2 = new Student();

        stu1.setId("1111");
        stu1.setName("张三");
        stu1.setAge(19);
        stu1.setScore(99);

        stu2.setId("2222");
        stu2.setName("李四");
        stu2.setAge(18);
        stu2.setScore(100);

        PrintStuInfoImpl p1 = new PrintStuInfoImpl();
        p1.printStuInfo(stu1);
        p1.printStuInfo(stu2);

        Employee A = new Employee("A",30,8000);
        Employee B = new Employee("B",35,9000);

        System.out.println(A.getName()+" "+A.getAge()+" "+A.getSalary());
        System.out.println(B.getName()+" "+B.getAge()+" "+B.getSalary());

        Student stu = new Student();

        Person per = stu; //向上转型
        per.go();
        //((Student)per).run();

        Person person = new Student();
        person.go();
        Student student = (Student)person; //向下转型
        student.run();
        student.go();

        System.out.println(stu.equals(per));
        System.out.println(stu == per);

        String str1 = "";
        String str2 = null;
        System.out.println(str1.equals(str2));
        System.out.println(str1 == str2);

        new Action().run();

    }
}
