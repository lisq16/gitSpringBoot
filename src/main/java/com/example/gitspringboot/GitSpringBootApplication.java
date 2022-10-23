package com.example.gitspringboot;

import com.example.testSpring.BObject;
import com.example.testSync.DObject;
import com.example.thread.CObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication

public class GitSpringBootApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(GitSpringBootApplication.class, args);


        DObject c = (DObject) applicationContext.getBean("DObject");
        c.testD02();
        System.out.println("start=====ok");
    }

}
