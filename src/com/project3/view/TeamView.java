package com.project3.view;

import com.project3.domain.Employee;
import com.project3.domain.Programmer;
import com.project3.service.NameListService;
import com.project3.service.TeamException;
import com.project3.service.TeamService;
import org.junit.Test;

import java.util.Scanner;

public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    /**
     * 主界面显示及控制方法
     */
    public void enterMainMenu(){
        Scanner sc = new Scanner(System.in);
        boolean loopFlag = true;
        char menu = 0;
        while(loopFlag){
            if (menu != '1'){
                listAllEmployees();
            }

            System.out.print("1-显示团队成员列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");
            menu = TSUtility.readMenuSelection();
            switch (menu){
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.print("确认是否退出（Y/N）:");
                    char isExist = TSUtility.readConfirmSelection();
                    if (isExist == 'Y'){
                        loopFlag = false;
                    }
                    break;
            }
        };


    }

    /**
     * 以表格形式列出公司所有成员，显示所有的员工信息
     */
    private void listAllEmployees(){
        System.out.println("-------------------------------------开发团队调度软件--------------------------------------\n");

        Employee[] employees = listSvc.getAllEmployees();
        if (employees == null || employees.length == 0){
            System.out.println("公司中没有任何员工信息！");
        }else {
            System.out.println("ID      姓名    年龄      工资         职位     状态      奖金       股票      领用设备");
            for (int i = 0; i < employees.length; i++) {
                System.out.println(employees[i].toString());
            }
            System.out.println("----------------------------------------------------------------------------------------");
        }
    }

    /**
     * 显示团队成员列表操作，查看开发团队情况
     */
    private void getTeam(){
        Programmer[] team = teamSvc.getTeam();
        System.out.println("---------------团队成员列表--------------");
        if(team == null || team.length == 0){
            System.out.println("开发团队目前没有成员！");
        }else{
            System.out.println("TID/ID\t姓名\t\t年龄\t 工资\t\t职位\t\t奖金\t\t股票");
            for (int i = 0; i < team.length; i++){
                System.out.println(team[i].getDetailsForTeam());
            }
        }
        System.out.println("---------------------------------------");
    }

    /**
     * 添加团队成员操作
     */
    private void addMember(){
        System.out.println("---------------添加团队成员--------------");
        System.out.println("请输入要添加的员工ID：");
        int id = TSUtility.readInt();
        Employee emp = null;
        try {
            emp = listSvc.getEmployee(id);
            teamSvc.addMember(emp);
            System.out.println("添加成功");
        } catch (TeamException e) {
            System.out.println("添加失败，原因：" + e.getMessage());
        }
        // 按回车继续
        TSUtility.readReturn();
    }

    /**
     * 删除团队成员操作
     */
    private void deleteMember(){
        System.out.println("---------------添加团队成员--------------");
        System.out.println("请输入要删除的员工TID：");
        int memberID = TSUtility.readInt();
        System.out.println("确认是否删除(Y/N):");
        char isDelete = TSUtility.readConfirmSelection();
        if (isDelete == 'N'){
            return;
        }
        try {
            teamSvc.removeMember(memberID);
            System.out.println("删除成功");
        } catch (TeamException e) {
            System.out.println("删除失败，原因：" + e.getMessage());
        }
        // 按回车继续
        TSUtility.readReturn();
    }

    public static void main(String[] args){
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }


}
