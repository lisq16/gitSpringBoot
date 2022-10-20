package com.example.testSpring;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 2 * @Author: Lisq
 * 3 * @Date: 2022/10/5 16:13
 * 4
 */
public class AObject {

    @Autowired
    private BObject b;

    private String str;

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        str = "ok";
//    }

    public String aMethod(){
        System.out.println("===============A被调用====================");
        return "===============A被调用===================="+str;
    }
}
