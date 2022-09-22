package com.dong.SE.lambda;

import com.dong.domain.Student;

import java.util.Arrays;

/**
 * @author dfx
 */
public class LambdaDemo1 {
    private static void invokeCook(Cook cook){
        cook.makeFood();
    }
    private static void invokeCalc(int a, int b, Calculator c){
        int sum = c.calc(a,b);
        System.out.println(sum);
    }
    public static void main(String[] args) {

        //无参无返回值的lambda表达式
        //使用匿名内部类
        invokeCook(new Cook() {
            @Override
            public void makeFood() {
                System.out.println("吃饭啦");
            }
        });

        invokeCook(()->{
            System.out.println("lambda  吃饭啦");
        });

        //有参有返回值的lambda表达式
        Student stu1 = new Student();stu1.setName("张三");stu1.setScore(66.0);
        Student stu2 = new Student();stu2.setName("李四");stu2.setScore(60.0);
        Student stu3 = new Student();stu3.setName("王五");stu3.setScore(99.0);
        Student[] students = {stu1, stu2, stu3};

        //对分数进行升序(前边-后边)排序
        //匿名内部类排序
//        Arrays.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return (int) (o1.getScore() - o2.getScore());
//            }
//        });

        //lambda函数排序
        Arrays.sort(students,(Student s1,Student s2)->{return (int)(s1.getScore() - s2.getScore());});

        for (Student stu: students){
            System.out.println(stu);
        }

        //有参有返回值的lambda表达式
        invokeCalc(10, 20, new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a+b;
            }
        });

        invokeCalc(10,20,(int a, int b)->{return a+b;});

        //使用匿名内部类创建多线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"新线程创立了");
            }
        }).start();

        //使用lambda表达式，实现多线程
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"新线程创立了");
        }).start();
    }
}
