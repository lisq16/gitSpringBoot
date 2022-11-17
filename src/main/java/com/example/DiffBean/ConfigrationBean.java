package com.example.DiffBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 2 * @Author: Lisq
 * 3 * @Date: 2022/11/17 13:18
 * 4
 */
@Configuration
public class ConfigrationBean {

    @Bean
    public TestBean01 getConfigrationBean(){
        System.out.println("========================ConfigurationBean初始化================");
        return new TestBean01();
    }
}
