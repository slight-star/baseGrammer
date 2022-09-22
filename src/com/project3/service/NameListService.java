package com.project3.service;

import com.project3.domain.*;

/**
 * @Description 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法。
 */
public class NameListService {
    private Employee[] employees;

    /**
     * 给employees及数组元素进行初始化
     */
    public NameListService() {
//        1.根据项目提供的Data类构建相应大小的employees数组
//        2.再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，以及相关联的Equipment子类的对象
//        3.将对象存于数组中
        employees = new Employee[Data.EMPLOYEES.length];
        for(int i=0; i<employees.length; i++){
            // 获取员工的类型
            int type = Integer.parseInt(Data.EMPLOYEES[i][0]);

            // 获取员工的基本信息
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            Double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);

            Equipment equipment;
            Double bonus;
            int stock;

            switch(type){
                case Data.EMPLOYEE:// 11
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case Data.PROGRAMMER:// 12
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                case Data.DESIGNER:// 13
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;
                case Data.ARCHITECT:// 14
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
                    break;
            }
        }
    }

    /**
     * 获取指定index上的员工的设备
     * @param i
     * @return
     */
    private Equipment createEquipment(int i) {
        int equipment_type = Integer.parseInt(Data.EQUIPMENTS[i][0]);
        Equipment equipment = null;
        switch(equipment_type){
            case Data.PC:// 21
                String model = Data.EQUIPMENTS[i][1];
                String display = Data.EQUIPMENTS[i][2];
                equipment = new PC(model, display);
                break;
            case Data.NOTEBOOK:// 22
                String model1 = Data.EQUIPMENTS[i][1];
                Double price = Double.parseDouble(Data.EQUIPMENTS[i][2]);
                equipment = new NoteBook(model1, price);
                break;
            case Data.PRINTER:// 23
                String name = Data.EQUIPMENTS[i][1];
                String type = Data.EQUIPMENTS[i][2];
                equipment = new Printer(name,type);
                break;
        }
        return equipment;
    }

    /**
     * 获取当前所有员工
     * @return
     */
    public Employee[] getAllEmployees() {
        return employees;
    }

    /**
     * 获取指定ID的员工
     * @param id
     * @return
     * @throws TeamException
     */
    public Employee getEmployee(int id) throws TeamException{
        for (int i=0; i<employees.length; i++){
            if (id == employees[i].getId()){
                return employees[i];
            }
        }
        // 如果没有找到ID，则抛出异常
        throw new TeamException("没有找到该ID");
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }
}
