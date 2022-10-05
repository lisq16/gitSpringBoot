package com.example.gitspringboot;

import com.example.testSpring.AObject;
import com.example.testSpring.BObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class GitSpringBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(GitSpringBootApplication.class, args);

        BObject b = (BObject) applicationContext.getBean("BObject");
        b.testA();
    }

}
