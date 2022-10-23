package com.example.gitspringboot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * 2 * @Author: Lisq
 * 3 * @Date: 2022/10/5 16:30
 * 4
 */
@ComponentScan("com")
@EnableAspectJAutoProxy
@Component
@EnableAsync
public class Config {
}
