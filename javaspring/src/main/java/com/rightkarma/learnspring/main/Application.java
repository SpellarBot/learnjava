package com.rightkarma.learnspring.main;

import com.rightkarma.learnspring.AppConfig;
import com.rightkarma.learnspring.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        /*ApplicationContext ctx=
                new ClassPathXmlApplicationContext("applicationContext.xml");*/

        ApplicationContext ctx=
                new AnnotationConfigApplicationContext(AppConfig.class);
        CustomerService customerService = ctx.getBean("customerService", CustomerService.class);
        System.out.println(customerService.findAll().get(0));
    }
}
