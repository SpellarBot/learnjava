package com.rightkarma.learnjava.hibernate.main;

import com.rightkarma.learnjava.hibernate.model.Employee;
import com.rightkarma.learnjava.hibernate.model.EmployeeHistory;
import com.rightkarma.learnjava.hibernate.model.EmployeeMnpi;
import com.rightkarma.learnjava.hibernate.model.EmployeeProject;
import com.rightkarma.learnjava.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Application {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Session session = HibernateUtil.getSessionFactory().openSession();

    public static void main(String[] args) throws ParseException {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("Starting com.purihim.hibernate.main.Application");

        Application application = new Application();
        System.out.println("calling delete");
        application.deleteEmployee();
        System.out.println("calling insert");
        application.insertEmployee();
        System.out.println("calling update");
        application.updateEmployee();
        System.out.println("Stopping com.purihim.hibernate.main.Application");
        application.shutdown();
        System.out.println("SHUTDOWN DONE");
    }

    public void insertEmployee() throws ParseException {
        session.beginTransaction();
        Date startDate = sdf.parse("2018-01-01");
        Date endDate = sdf.parse("2018-12-31");
        Employee emp = new Employee(1,"Hibernate user1",
                "xyz@abc", new Date(), 1, sdf.parse("1988-12-21"));
        emp.getEmployeeHistory().add(new EmployeeHistory(1,new Date(),"added employee"));
        emp.addProject(new EmployeeProject(1, startDate, endDate));

        System.out.println("INSERT EMP:" + emp);
        session.save(emp);
        session.getTransaction().commit();
    }
    private void shutdown() {
        session.close();
    }

    private void updateEmployee() {
        session.beginTransaction();
        Employee emp = (Employee) session.get(Employee.class, 1);
        System.out.println("UPDATE EMP:" + emp.getEmployeeId());
        emp.setEmailId("hibernate.user1@rightkarma.com");
        emp.getEmployeeHistory().add(new EmployeeHistory(1, new Date(), "Updated Email id"));
        session.getTransaction().commit();
    }

    public Application() {

    }

    private void deleteEmployee() {
        session.beginTransaction();
        Employee emp = (Employee) session.get(Employee.class, 1);
        if ( null==emp){
            System.out.println("EMP NOT FOUND. CONTINUE");
        } else {
            System.out.println("EMP FOUND. DELETE");
            session.delete(emp);
        }
        session.getTransaction().commit();
    }


}
