package com.example.testSync;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 2 * @Author: Lisq
 * 3 * @Date: 2022/10/23 11:19
 * 4
 */
@Component
public class DObject {

    @Autowired
    private EObject eObject;

    public void testD(){
        eObject.testE();
        System.out.println("D====ok");
    }

    public void testD02() throws InterruptedException {
        testAsync();
        System.out.println("D02====ok");
    }

    /**
     * 此方法不会异步执行，因为代理对象
     * @throws InterruptedException
     */
    @Async
    void testAsync() throws InterruptedException {
        Thread.sleep(1000*3);
        System.out.println("DAsybc====ok");
    }
}
