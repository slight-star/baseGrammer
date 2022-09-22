package com.dong.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author dfx
 */
public class Student implements Serializable{
    private static final long serialVersionUID = -6849754667710L;

    private Integer id;
    private String name;
    private Integer age;
    private Double score;
    private Date birthday;
    private Timestamp insert_time;
    private String sex;

    public String a;
    protected String b;
    String c;


    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Timestamp getInsert_time() {
        return insert_time;
    }

    public void setInsert_time(Timestamp insert_time) {
        this.insert_time = insert_time;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void eat(){
        System.out.println("开始吃饭");
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", birthday=" + birthday +
                ", insert_time=" + insert_time +
                ", sex='" + sex + '\'' +
                '}';
    }
}
