package com.example.gitspringboot;

import com.example.DiffBean.ComponentBean;
import com.example.DiffBean.ConfigrationBean;
import com.example.DiffBean.TestBean01;
import com.example.testSync.DObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication

public class GitSpringBootApplicationDiffBean {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(GitSpringBootApplicationDiffBean.class, args);

        /**
         * 当@Bean在@Configration下时，每次调用方法spring会拦截，可以生成代理对象，并且每次都是同一个。
         */
        ConfigrationBean a = (ConfigrationBean) applicationContext.getBean("configrationBean");
        a.getConfigrationBean().doSomthing();
        System.out.println(a.getConfigrationBean());
        System.out.println(a.getConfigrationBean());
        System.out.println("================================================================================================\n\n");
        /**
         * 每次调用方法spring不会拦截，不会生成代理对象，每次都会得到一个普通对象， 所以每次获取都是新的对象
         */
        ComponentBean c = (ComponentBean) applicationContext.getBean("componentBean");
        c.getComponentBean().doSomthing();
        System.out.println(c.getComponentBean());
        System.out.println(c.getComponentBean());
        System.out.println("================================================================================================\n\n");

        /**
         * 如果不调用方法生成bean，而是从上下文中获取，则没有问题,也会被代理，因为这个对象是在项目启动时期spring处理过的
         */
        System.out.println(applicationContext.getBean("getComponentBean"));
        System.out.println(applicationContext.getBean("getComponentBean"));
        ((TestBean01)applicationContext.getBean("getComponentBean")).doSomthing();
    }

}
