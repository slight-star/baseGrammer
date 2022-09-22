package com.dong.work;

public class Test {
    public static void main(String[] args) {
        ArrayListUtil list = new ArrayListUtil();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.Size);
        list.setSize(10);
        System.out.println(list.Size);
        System.out.println(list.get(5));
        System.out.println(list.isEmpty());
        System.out.println(list.equals(123));
        list.clear();
        System.out.println(list.isEmpty());
        System.out.println(list.size());

        StringUtil str = new StringUtil("hello");
        System.out.println(str.length());
        System.out.println(str.indexOf('l'));
        System.out.println(str.lastIndexOf('l'));
    }
}
