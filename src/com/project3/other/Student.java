package com.project3.other;

public class Student {
    private int id;
    public void regist(int id) throws Exception {
        if(id > 0){
            this.id = id;
        }else{
            throw new Exception("您输入的数据非法！");
        }
    }
}
