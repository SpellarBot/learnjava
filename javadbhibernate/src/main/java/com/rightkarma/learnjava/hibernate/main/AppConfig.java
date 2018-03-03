package com.rightkarma.learnjava.hibernate.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"com.purihim"})
@PropertySource("app.properties")
public class AppConfig {

}
