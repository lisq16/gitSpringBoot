package com.example.gitspringboot;

import com.example.lookupPack.LookupBean01;
import com.example.lookupPack.LookupBean03;
import com.example.testSync.DObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication

public class GitSpringBootApplicationLookup {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(GitSpringBootApplicationLookup.class, args);


        LookupBean03 bean = applicationContext.getBean(LookupBean03.class);
        LookupBean01 c = (LookupBean01) applicationContext.getBean("lookupBean01");
        LookupBean01 d = (LookupBean01) applicationContext.getBean("lookupBean01");
        System.out.println(c.getLookupBean02());
        System.out.println(d.getLookupBean02());
    }

}
