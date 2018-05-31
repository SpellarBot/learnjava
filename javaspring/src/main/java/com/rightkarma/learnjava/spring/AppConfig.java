package com.rightkarma.learnjava.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"com.purihim"})
@PropertySource("app.properties") // TODO implement env - https://blog.jayway.com/2014/02/16/spring-propertysource/
public class AppConfig {

    /*Code works without this also PropertySourcesPlaceholderConfigurer*/
    /*@Bean
    public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }*/
}
