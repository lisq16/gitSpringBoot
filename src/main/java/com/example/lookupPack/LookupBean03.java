package com.example.lookupPack;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 2 * @Author: Lisq
 * 3 * @Date: 2022/11/17 15:43
 * 4
 */
@Component
public abstract class LookupBean03 {

    @Value("123")
    private String p;
    @Lookup
    public abstract void a();
}
