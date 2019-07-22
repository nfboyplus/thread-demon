package com.thread.study.excise;

/**
 * created on 2019/6/30 14:11
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class ThreadOne implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("---- ThreadOne ----" + "i:" + i);
        }
    }
}
