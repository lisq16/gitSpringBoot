package com.example.testSpring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 2 * @Author: Lisq
 * 3 * @Date: 2022/10/5 17:07
 * 4
 */
@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(* com.example.testSpring.AObject.*(..))")
    private void pointcut() {}

    @Before("pointcut()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("===================A类的切面开始===============");
    }
}
