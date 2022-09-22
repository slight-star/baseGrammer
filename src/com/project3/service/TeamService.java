package com.project3.service;

import com.project3.domain.Architect;
import com.project3.domain.Designer;
import com.project3.domain.Employee;
import com.project3.domain.Programmer;

/**
 * 关于开发团队成员的管理：添加、删除等。
 */
public class TeamService {
    private static int counter =1;
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;

    /**
     * 获取团队中的所有成员
     * @return
     */
    public Programmer[] getTeam() {
        Programmer[] team_now = new Programmer[total];
        for(int i = 0; i<team_now.length; i++){
            team_now[i] = this.team[i];
        }
        return team_now;
    }

    /**
     * 将指定员工添加到团队成员中
     * @param e
     * @throws TeamException
     */
    public void addMember(Employee e) throws TeamException {
//      成员已满，无法添加
        if(total >= MAX_MEMBER){
            throw new TeamException("成员已满，无法添加");
        }
//      该成员不是开发人员，无法添加
        if(!(e instanceof Programmer)){
            throw new TeamException("该成员不是开发人员，无法添加!");
        }
//      该员工已在本开发团队中
        if (isExist(e)){
            throw new TeamException("该员工已在本开发团队中");
        }

//      该员工已是某团队成员
//      该员工正在休假，无法添加
        Programmer p = (Programmer) e;
//        if("BUSY".equalsIgnoreCase(p.getStatus().getNAME())){
//            throw new TeamException("该员工已是某团队成员");
//        }else if("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())){
//            throw new TeamException("该员工正在休假，无法添加");
//        }
        if (Status.BUSY == p.getStatus()){
            throw new TeamException("该员工已是某团队成员");
        }else if(Status.VOCATION == p.getStatus()){
            throw new TeamException("该员工正在休假，无法添加");
        }
        // 或者是
        switch (p.getStatus()){ //小括号里可以是byte,short,char,int,String,枚举类对象
            case BUSY:
                throw new TeamException("该员工已是某团队成员");
            case VOCATION:
                throw new TeamException("该员工正在休假，无法添加");
        }



//      团队中至多只能有一名架构师
//      团队中至多只能有两名设计师
//      团队中至多只能有三名程序员
        int Architect_num = 0;
        int Designer_num = 0;
        int Programmer_num = 0;
        for (int i = 0; i< total; i++){
            if (team[i] instanceof Architect){
                Architect_num++;
            }else if (team[i] instanceof Designer){
                Designer_num++;
            }else if (team[i] instanceof Programmer){
                Programmer_num++;
            }
        }
        if (e instanceof Architect){
            if(Architect_num >= 1){
                throw new TeamException("团队中至多只能有一名架构师");
            }
        }else if (e instanceof Designer) {
            if (Designer_num >= 2) {
                throw new TeamException("团队中至多只能有两名设计师");
            }
        }else if (e instanceof Programmer){
            if (Programmer_num >= 3){
                throw new TeamException("团队中至多只能有三名程序员");
            }
        }
        /* 如果下面这样写是错误的
        if (e instanceof Architect && Architect_num >= 1){
            throw new TeamException("团队中至多只能有一名架构师");
        }else if (e instanceof Designer && Designer_num >= 2){
            throw new TeamException("团队中至多只能有两名设计师");
        }else if (e instanceof Programmer && Programmer_num >= 3){
            throw new TeamException("团队中至多只能有三名程序员");
        }
        */

        team[total++] = p;
        p.setMemberId(counter++);
        p.setStatus(Status.BUSY);
    }

    /**
     * 判断指定的员工是否在现有的开发团队中
     * @param e
     * @return
     */
    private boolean isExist(Employee e) {
        for(int i = 0; i<total; i++){
            if (e.getId() == team[i].getId()){
                return true;
            }
            //也可以用MemberId比较，
        }
        return false;
    }

    /**
     * 删除团队成员
     * @param memberId
     * @throws TeamException
     */
    public void removeMember(int memberId) throws TeamException {
        if (total == 0){
            throw new TeamException("团队中没有成员可供删除!");
        }
        int i = 0;
        boolean flag = false;
        for (; i<total; i++){
            if(team[i].getMemberId() == memberId){
                team[i].setStatus(Status.FREE);
                // 后面的元素覆盖前面的元素，实现删除，最后一个置为null
                for (int j = i + 1; j<total; j++){
                    team[j - 1] = team[j];
                }
                team[--total] = null;
                flag = true;
                break;
            }
        }
        if(!flag){
            throw new TeamException("团队中没有该成员");
        }
    }
}
