package com.example.gitspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableAspectJAutoProxy
@ImportResource(locations = {"classpath:springConfig.xml"})
public class GitSpringBootApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(GitSpringBootApplication.class, args);

//        BObject b = (BObject) applicationContext.getBean("BObject");
//        b.testA();
//        AObject c = (AObject) applicationContext.getBean("AObject");
//        c.aMethod();
    }

}
