package com.dong.SE.dataStructure;

import org.junit.Test;

import java.util.Arrays;

@SuppressWarnings("all")
public class MyArray {
    private int[] myArray;

    public MyArray(){
        myArray = new int[0];
    }

    //给数组扩容，末尾加上一个元素
    public void add(int value){
        int[] newArr = new int[myArray.length + 1];
        for (int i = 0; i < myArray.length; i++) {
            newArr[i] = myArray[i];
        }
        newArr[myArray.length] = value;
        myArray = newArr;
    }

    //展示元素内容
    public void show(){
        System.out.println(Arrays.toString(myArray));
    }

    //设置元素内容
    public void set(int index, int value){
        if (index < 0 || index > myArray.length){
            throw new RuntimeException("下标越界");
        }
        myArray[index] = value;
    }

    //得到元素内容
    public int get(int index){
        if (index < 0 || index > myArray.length){
            throw new RuntimeException("下标越界");
        }
        return myArray[index];
    }

    //删除某下标的元素
    public void delete(int index){
        if (index < 0 || index > myArray.length){
            throw new RuntimeException("下标越界");
        }
        int[] newArr = new int[myArray.length-1];
        for (int i = 0; i < newArr.length; i++) {
            if (i < index){
                newArr[i] = myArray[i];
            }else{
                newArr[i] = myArray[i+1];
            }
        }
        myArray = newArr;
    }

    //插入元素到指定位置
    public void insert(int index, int value){
        if (index < 0 || index > myArray.length){
            throw new RuntimeException("下标越界");
        }
        int[] newArr = new int[myArray.length+1];
        for (int i = 0; i < myArray.length; i++) {
            if (i < index){
                newArr[i] = myArray[i];
            }else{
                newArr[i+1] = myArray[i];
            }
        }
        newArr[index] = value;
        myArray = newArr;
    }

    //得到长度
    public int size(){
        return myArray.length;
    }

    //线性查找
    public int search(int target){
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] == target){
                return i;
            }
        }
        return -1;
    }
    
    //二分查找
    public int binarySearch(int target){
        //记录下标
        int index = -1;

        int left = 0;
        int right = myArray.length-1;
        int mid = (left + right) / 2;

        while(left <= right){
            //看中间元素是不是要查找的元素
            if (myArray[mid] == target){
                index = mid;
                break;
            }else{
                //看是不是比中间元素左边
                if (target < myArray[mid]){
                    right = mid-1;
                }else{
                    //是在中间元素右边
                    left = mid+1;
                }
                mid = (left + right) / 2;
            }
        }
        return index;
    }



    @Test
    public void test(){
        MyArray myArr = new MyArray();
        myArr.show();

        myArr.add(99);
        myArr.add(98);
        myArr.add(97);
        myArr.show();

        myArr.set(1,88);
        myArr.show();

        System.out.println(myArr.get(2));

        myArr.insert(2,100);
        myArr.show();
        myArr.insert(0,101);
        myArr.show();

        myArr.delete(4);
        myArr.show();
        myArr.delete(1);
        myArr.show();

        myArr.insert(3,99);
        myArr.show();
        myArr.insert(0,111);
        myArr.show();

        int index = myArr.search(102);
        System.out.println("线性查找："+index);

        myArr.show();
        while(myArr.size() != 0){
            myArr.delete(0);
        }
        myArr.add(1);
        myArr.add(2);
        myArr.add(3);
        myArr.add(4);
        myArr.add(5);
        myArr.show();
        int index2 = myArr.binarySearch(5);
        System.out.println("二分查找："+index2);

    }
}
