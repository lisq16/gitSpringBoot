package com.example.testSpring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 2 * @Author: Lisq
 * 3 * @Date: 2022/10/5 16:13
 * 4
 */
@Component
public class AObject implements InitializingBean {

    @Autowired
    private BObject b;

    private String str;
    private String str1;

    @Override
    public void afterPropertiesSet() throws Exception {
        str = "ok";
    }

    public String aMethod(){
        return "===============A被调用===================="+str;
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }
}
