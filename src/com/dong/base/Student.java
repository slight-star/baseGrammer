package com.dong.base;

public class Student extends Person{
    private String name;
    private String id;
    private float score;

    public Student() {
    }

    public Student(String name){
        this.name = name;
    }

    public Student(int age, String name, String id, float score) {
        super(age);
        this.name = name;
        this.id = id;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public void run() {
        System.out.println("子类run");
    }


    @Override
    public void go() {
        System.out.println("子类go");
    }

}
