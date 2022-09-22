package com.project3.domain;

public class Designer extends Programmer{
    private Double bonus;

    public Designer(int id, String name, int age, double salary, Equipment equipment, Double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public Designer() {
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetails() + "\t\t设计师\t" + getStatus() + "\t" + getBonus() +"\t\t\t\t" + getEquipment().getDescription();
    }

    public String getDetailsForTeam(){
        return getTeamBaseDetails() + "\t设计师" + "\t" +getBonus()+ "\t";
    }
}
