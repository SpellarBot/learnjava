package com.rightkarma.learnjava.hibernate.main;

import com.rightkarma.learnjava.hibernate.model.Employee;
import com.rightkarma.learnjava.hibernate.model.EmployeeHistory;
import com.rightkarma.learnjava.hibernate.model.EmployeeProject;
import com.rightkarma.learnjava.hibernate.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
        System.out.println("calling selct");
        application.selectEmployee();
        application.selectEmployeeNamedQuery();
        application.selectEmployeeUsingCriteria();
        application.selectEmployeeUsingCriteriaWhere();
        application.selectEmployeeUsingCriteriaWhereProjections();
        application.selectEmployeeUsingCriteriaWhereProjectionsJoin();
        System.out.println("Stopping com.purihim.hibernate.main.Application");
        application.shutdown();
        System.out.println("SHUTDOWN DONE");
    }



    public void insertEmployee() throws ParseException {
        session.beginTransaction();

        // emp 1
        Date startDate = sdf.parse("2018-01-01");
        Date endDate = sdf.parse("2018-12-31");
        Employee emp = new Employee(1,"Hibernate user1",
                "xyz@abc", new Date(), 1, sdf.parse("1988-12-21"));
        emp.getEmployeeHistory().add(new EmployeeHistory(1,new Date(),"added employee"));
        emp.addProject(new EmployeeProject(1, startDate, endDate));

        // emp 2
        startDate = sdf.parse("2017-05-12");
        endDate = sdf.parse("2018-02-11");
        Employee emp2 = new Employee(2,"Hibernate user 2",
                "hibernateUser_2@rightkarma.com", new Date(), 2, sdf.parse("1986-03-13"));
        emp2.getEmployeeHistory().add(new EmployeeHistory(1,new Date(),"added employee 2"));
        emp2.addProject(new EmployeeProject(2, startDate, endDate));



        System.out.println("INSERT EMP:" + emp);
        session.save(emp);
        System.out.println("INSERT EMP:" + emp2);
        session.save(emp2);
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

    /*select data using HQL - hibernate query language*/
    private void selectEmployee() {
        session.beginTransaction();
        Query query =session.createQuery("from Employee");
        List<Employee> list = query.list();
        System.out.println("-----------SELECT USING HQL-----------------------------");
        for( Employee e : list){
            System.out.println(e.getName()+" | "+e.getEmailId()+" | "+e.toString());
        }
        System.out.println("----------------------------------------");
        session.getTransaction().commit();
    }

    /*select data using HQL - named query - hibernate query language*/
    private void selectEmployeeNamedQuery() {
        session.beginTransaction();
        Query query =session.getNamedQuery("getEmployees");
        List<Employee> list = query.list();
        System.out.println("----------NAMED QUERY RESULTS------------------------------");
        for( Employee e : list){
            System.out.println(e.getName()+" | "+e.getEmailId()+" | "+e.toString());
        }
        System.out.println("----------------------------------------");
        session.getTransaction().commit();
    }

    private void selectEmployeeUsingCriteria() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Employee.class);
        List<Employee> list = criteria.list();
        System.out.println("-----------CRITERIA RESULTS-----------------------------");
        for( Employee e : list){
            System.out.println(e.getName()+" | "+e.getEmailId()+" | "+e.toString());
        }
        System.out.println("----------------------------------------");
        session.getTransaction().commit();
    }

    private void selectEmployeeUsingCriteriaWhere() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Employee.class);

/*        criteria.add(Restrictions.eq("employeeId",2));*/

        criteria.add(Restrictions.or(
                Restrictions.eq("name","Hibernate user1"),
                Restrictions.eq("employeeId",2))
        );


        List<Employee> list = criteria.list();
        System.out.println("-----------CRITERIA RESULTS WHERE-----------------------------");
        for( Employee e : list){
            System.out.println(e.getName()+" | "+e.getEmailId()+" | "+e.toString());
        }
        System.out.println("----------------------------------------");
        session.getTransaction().commit();
    }

    private void selectEmployeeUsingCriteriaWhereProjections() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Employee.class);

        System.out.println("-----------CRITERIA RESULTS WHERE PROJECTIONS-----------------------------");
        criteria.add(Restrictions.or(
                Restrictions.eq("name","Hibernate user1"),
                Restrictions.eq("employeeId",2))
        ).setProjection(Projections.projectionList()
                .add(Projections.property("employeeId"))
                .add(Projections.property("name")));

        // here we are doing join and hence can't select any class as result set, so we have to catch results using Object[] vs say Employee Class
        List<Object[]> results= criteria.list();
        System.out.println("-----------CRITERIA RESULTS WHERE-----------------------------");
        for( Object[] result : results){
            System.out.println("-------RESULT SET STARTING---------------------------------");
            for ( Object obj : result){
                System.out.println(obj.toString());
            }
            System.out.println("-------RESULT SET OVER---------------------------------");
        }
        System.out.println("----------------------------------------");
        session.getTransaction().commit();
    }
    private void selectEmployeeUsingCriteriaWhereProjectionsJoin() {
        System.out.println("INSIDE selectEmployeeUsingCriteriaWhereProjectionsJoin");
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Employee.class);

        System.out.println("-----------CRITERIA RESULTS WHERE PROJECTIONS-----------------------------");
        criteria.createAlias("employeeMnpi","emnp");
        criteria.add(Restrictions.or(
                Restrictions.eq("name","Hibernate user1"),
                Restrictions.eq("employeeId",2))
        ).setProjection(Projections.property("emnp.dob"));


        List<Object> results= criteria.list();
        System.out.println("-----------CRITERIA RESULTS WHERE-----------------------------");
        for (Object o : results){
            System.out.println(o.toString());
        }
        System.out.println("----------------------------------------");
        session.getTransaction().commit();
    }

}
