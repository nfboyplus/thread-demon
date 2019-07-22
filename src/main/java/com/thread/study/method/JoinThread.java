package com.thread.study.method;

/**
 * created on 2019/6/30 13:59
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class JoinThread implements Runnable {
    /**
     * join():
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {

            }
            System.out.println("我是子线程：" + Thread.currentThread().getName() + "i:" + i);
        }
    }
}
