package com.thread.study.method;

/**
 * created on 2019/6/30 12:07
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class CreateRunnable implements Runnable{

    /**
     * 实现 Runnable 接口，重写 run 方法，推荐使用接口的方式；
     */

    @Override
    public void run() {
        for (int i = 0; i<=10; i++){
            System.out.println("子线程：i:" + i);
        }
    }

}
