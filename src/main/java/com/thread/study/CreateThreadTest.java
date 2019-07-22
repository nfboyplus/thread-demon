package com.thread.study;

import com.thread.study.method.CreateThread;

/**
 * created on 2019/6/30 11:32
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class CreateThreadTest {

    /**
     * 在一个进程中，一定有主线程；
     * 线程: 用户线程，守护线程，主线程，子线程，GC线程
     */
    /**
     * 多线程目的是提高程序的运行效率
     * @param args
     */
    public static void main(String[] args){

        /**
         * 实现多线程的方式：1.继承 Thread 类,重写 run 方法；
         *                   2.实现 Runnable 接口，重写 run 方法；
         *                   3. 使用匿名内部类
         */
        System.out.println("-----主线程开始运行-----");
        // 1.创建一个线程
        CreateThread thread = new CreateThread();
        System.out.println("-----多线程创建启动-----");
        // 2.开始执行线程 注意 开启线程不是调用run方法，而是start方法
        thread.start();
        for (int i = 0; i<=10; i++){
            System.out.println("主线程：i:" + i);
        }
        System.out.println("-----主线程运行结束-----");

        //结论：主线程和子线程交替执行

    }
}
