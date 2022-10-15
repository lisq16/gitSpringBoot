package com.example.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * 2 * @Author: Lisq
 * 3 * @Date: 2022/10/15 19:49
 * 4
 */
@Component
public class CObject {

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    public void test01() throws InterruptedException {
        System.out.println("开始执行test01");
        taskExecutor.execute(() -> {
            extracted();
        });
        Future<?> submit = taskExecutor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程02执行完了呢~");
            }
        });
        System.out.println("test01结束");
    }

    private void extracted() {
        try {
            Thread.sleep(1000*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程01执行完了呢~");
    }
}
