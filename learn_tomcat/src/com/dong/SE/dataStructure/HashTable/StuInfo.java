package com.dong.SE.dataStructure.HashTable;

import java.util.Objects;

/**
 * @author dfx
 */
public class StuInfo {
    private int age;
    private int count;

    public StuInfo(int age, int count) {
        this.age = age;
        this.count = count;
    }

    public StuInfo(int age) {
        this.age = age;
    }

    public StuInfo() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int hashCode(){
        return age;
    }

    @Override
    public String toString() {
        return "StuInfo{" +
                "age=" + age +
                ", count=" + count +
                '}';
    }
}
