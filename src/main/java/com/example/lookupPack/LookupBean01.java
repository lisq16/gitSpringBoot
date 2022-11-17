package com.example.lookupPack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * 2 * @Author: Lisq
 * 3 * @Date: 2022/11/17 14:58
 * 4
 */
@Component
public class LookupBean01 {

    @Autowired
    LookupBean02 lookupBean02;

    /**
     * 加上此@Lookup注解每次获取都是新的，不加则每次都相同
     * @return
     */
    @Lookup
    public LookupBean02 getLookupBean02(){
        return this.lookupBean02;
    }
}
