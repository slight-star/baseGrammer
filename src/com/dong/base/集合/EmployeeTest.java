package com.dong.base.集合;

import com.dong.base.Person;
import org.junit.Test;

import java.util.*;

public class EmployeeTest {
    public static void main(String[] args) {
        Collection employee_set = new TreeSet();
        employee_set.add(new Employee("小asd",12,new MyDate(2008,10,1)));
        employee_set.add(new Employee("小hua",18,new MyDate(2000,5,1)));
        employee_set.add(new Employee("小bgs",18,new MyDate(2000,6,1)));
        employee_set.add(new Employee("小sdf",20,new MyDate(1998,8,1)));
        employee_set.add(new Employee("小der",30,new MyDate(1988,10,5)));

        Iterator iterator = employee_set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test(){
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee){
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;

                    MyDate b1 = e1.getBirthday();
                    MyDate b2 = e2.getBirthday();

                    return b1.compareTo(b2);
                }
                throw new RuntimeException("传入的数据类型不一致！");
            }
        };

        Collection employee_set = new TreeSet(com);

        employee_set.add(new Employee("小asd",12,new MyDate(2008,10,1)));
        employee_set.add(new Employee("小hua",18,new MyDate(2000,5,1)));
        employee_set.add(new Employee("小bgs",18,new MyDate(2000,6,1)));
        employee_set.add(new Employee("小sdf",20,new MyDate(1998,8,1)));
        employee_set.add(new Employee("小der",30,new MyDate(1988,10,5)));

        Iterator iterator = employee_set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


}
