package com.thread.study;

import com.thread.study.method.CreateRunnable;

/**
 * created on 2019/6/30 12:10
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class CreateRunnableTest {

    public static void main(String[] args){

        /**
         * 实现 Runnable 接口，重写 run 方法；
         */
        System.out.println("-----主线程开始运行-----");
        // 1.创建一个线程
        CreateRunnable runnable = new CreateRunnable();
        Thread  thread = new Thread(runnable);
        // 2.启动线程
        thread.start();
        for (int i = 0; i<=10; i++){
            System.out.println("主线程：i:" + i);
        }
        System.out.println("-----主线程运行结束-----");
    }

}
