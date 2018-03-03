package com.rightkarma.learnjava.springdb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("============== DELETE ======================");
        EmployeeDaoDelete employeeDaoDelete = (EmployeeDaoDelete ) ctx.getBean("employeeDaoDelete");
        employeeDaoDelete.deleteEmployee(new Employee(1, "A", "B","C")); // delete is employee_id based.. rest of values don't matter
        employeeDaoDelete.deleteEmployeeNamedParameter(new Employee(2, "A", "B","C")); // delete is employee_id based.. rest of values don't matter
        employeeDaoDelete.deleteEmployees(); // delete is employee_id based.. rest of values don't matter


        System.out.println("============== ADD EMPLOYEES ======================");
        EmployeeDaoAdd employeeDaoAdd = (EmployeeDaoAdd) ctx.getBean("employeeDaoAdd");
        employeeDaoAdd.addEmployee(new Employee(1, "Arun", "Pathania", "arun.pathania@xxx.com"));
        employeeDaoAdd.addEmployeeSimpleJdbc(new Employee(2, "Ram", "Sharma", "ram.s@whatever.com"));
        employeeDaoAdd.addEmployeeSimpleJdbcWithKey(new Employee(4, "Sri", "Iyer", "s.iyer@xxx.com"));
        employeeDaoAdd.addEmployeePS(new Employee(3, "Vinay", "Singh", "vinay.s@whatever.com"));


        EmployeeDaoGet employeeDaoGet = (EmployeeDaoGet) ctx.getBean("employeeDaoGet");
        System.out.println("============== ROW MAPPER ======================");
        employeeDaoGet.getEmployeesRowMapper().stream().forEach(System.out::println);
        System.out.println("============== RESULT SET EXTRACTOR ======================");
        employeeDaoGet.getEmployeesRSExtractor().stream().forEach(System.out::println);


        System.out.println("============== UPDATE EMPLOYEES ======================");
        System.out.println(employeeDaoGet.getEmployee(1));
        System.out.println(employeeDaoGet.getEmployee(2));

        EmployeeDaoUpdate employeeDaoUpdate = (EmployeeDaoUpdate) ctx.getBean("employeeDaoUpdate");

        System.out.println("============== POST SINGLE EMP UPDATE ======================");
        employeeDaoUpdate.updateEmployee(new Employee(1, "Arun", "Singhania", "arun.s@xxx.com"));
        System.out.println(employeeDaoGet.getEmployee(1));

        List<Object[]> pairs = new ArrayList<>();
        Object[] tmp = { "Shankar", 1 };
        Object[] tmp2= {"Shah", 2};
        pairs.add(tmp);
        pairs.add(tmp2);
        employeeDaoUpdate.updateEmployees(pairs);
        System.out.println("============== POST BATCH UPDATE ======================");
        System.out.println("post update..."+employeeDaoGet.getEmployee(1));
        System.out.println("post update..."+employeeDaoGet.getEmployee(2));


        System.out.println("============== POST FAILED EMP UPDATE ======================");
        System.out.println(employeeDaoGet.getEmployee(1));
        try {
            employeeDaoUpdate.updateEmployeeTransactional(new Employee(1, "Arun", "JunkData", "arun.s@xxx.com"));
        } catch ( Exception e) {
            System.out.println("Continuing after catching forced exception");
        }
        System.out.println(employeeDaoGet.getEmployee(1));
    }
}
