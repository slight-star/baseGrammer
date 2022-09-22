package com.project3.junit;

import com.project3.domain.Employee;
import com.project3.service.NameListService;
import com.project3.service.TeamException;
import org.junit.Test;

/**
 * 对NameListService进行测试
 */
public class NameListServiceTest {

    @Test
    public void testGetAllEmployees(){
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();
        for (int i = 0; i<employees.length; i++){
            System.out.println(employees[i]);
        }
    }

    @Test
    public void testGetEmployee(){
        NameListService service = new NameListService();
        int id = 101;

        try {
            Employee employee = service.getEmployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
