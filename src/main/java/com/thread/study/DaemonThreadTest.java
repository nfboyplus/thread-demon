package com.thread.study;

import com.thread.study.method.DaemonThread;

/**
 * created on 2019/6/30 13:42
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class DaemonThreadTest {

    public static void main(String[] args) {

        DaemonThread daemonThread = new DaemonThread();
        Thread thread = new Thread(daemonThread);
        //设置守护线程
        thread.setDaemon(true);
        thread.start();
        for (int i = 0; i <= 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("---- 我是主线程 ----");
        }
        System.out.println("---- 主线程执行完毕 ----");
    }

    //结论：主线程执行完毕，子线程继续执行，设置守护线程，目的让子线程和主线程一起停止 thread.setDaemon(true);
}
