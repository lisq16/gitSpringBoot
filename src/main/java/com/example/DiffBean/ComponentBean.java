package com.example.DiffBean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 2 * @Author: Lisq
 * 3 * @Date: 2022/11/17 13:18
 * 4
 */
@Component
public class ComponentBean {
    @Bean
    public TestBean01 getComponentBean(){
        System.out.println("========================ComponentBean初始化================");
        return new TestBean01();
    }
}
