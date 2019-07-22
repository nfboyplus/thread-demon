package com.thread.study;

import com.thread.study.method.JoinThread;

/**
 * created on 2019/6/30 14:01
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class JoinThreadTest {

    public static void main(String[] args) throws InterruptedException {
        JoinThread joinThread = new JoinThread();
        Thread thread = new Thread(joinThread);
        thread.start();
        // 当在主线程当中执行到thread.join()方法时，就认为主线程应该把执行权让给 thread
        thread.join();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {

            }
            System.out.println("我是主线程" + "i:" + i);
        }

        //结论：所有子线程执行完毕，才开始执行主线程

    }
}
