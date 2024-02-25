package com.example.gitspringboot;

import com.example.testSpring.AObject;
import com.example.testSpring.BObject;
//import com.example.testSpring.Test02;
import com.example.testSync.DObject;
import com.example.thread.CObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication

public class GitSpringBootApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(GitSpringBootApplication.class, args);

        ClassLoader loader = DObject.class.getClassLoader();
        URL resource = loader.getResource("");
        System.out.println(resource.getPath());
        System.out.println(new File(resource.getPath()));
//        Test02 test02 = applicationContext.getBean("test02", Test02.class);
//        test02.ok();
//        test02.ok1();
//        AObject c = (AObject) applicationContext.getBean("AObject");
//        c.aMethod();
//
//        System.out.println("start=====ok");
    }

}
