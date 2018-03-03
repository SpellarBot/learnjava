package com.rightkarma.learnjava.spring.main;

import com.rightkarma.learnjava.spring.AppConfig;
import com.rightkarma.learnjava.spring.service.CustomerService;
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
