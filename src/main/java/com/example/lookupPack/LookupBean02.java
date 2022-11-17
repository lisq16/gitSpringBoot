package com.example.lookupPack;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 2 * @Author: Lisq
 * 3 * @Date: 2022/11/17 14:58
 * 4
 */
@Component
@Scope("prototype")
public class LookupBean02 {

    @Value("123")
    private String a;
}
