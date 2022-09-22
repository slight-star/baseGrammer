package com.project3.domain;
/**
 * model 表示机器型号
 * display 表示显示器名称
 * type 表示机器的类型
 */
public class NoteBook implements Equipment{
    private String model;
    private Double price;

    public NoteBook() {
    }

    public NoteBook(String model, Double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String getDescription() {
        return model + "(" + price + ")";
    }
}
