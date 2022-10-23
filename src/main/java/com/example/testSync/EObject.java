package com.example.testSync;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * 2 * @Author: Lisq
 * 3 * @Date: 2022/10/23 11:19
 * 4
 */
@Component
public class EObject {

    @Async
    public Future<String> testE(){
        System.out.println("异步方法开始执行");
        try {
            Thread.sleep(1000*3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("异步方法执行结束");
        return AsyncResult.forValue("E==ok");
    }
}
