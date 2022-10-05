package com.example.testSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 2 * @Author: Lisq
 * 3 * @Date: 2022/10/5 16:13
 * 4
 */
@Component
public class BObject {

    @Autowired
    private AObject a;
}
