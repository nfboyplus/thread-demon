package com.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * created on 2019/7/3 13:05
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class FixedThreadPoolTest {

    /**
     * 控制并发数的线程池
     */
    public static void main(String[] args) {
        //控制并发数的线程池
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i <= 10; i++) {
            final int temp = i;
            newFixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("当temp=" + temp + "时，" + "当前线程" + Thread.currentThread().getName());
                }
            });
        }
    }

    /**
     * 结论：1.指定了可活动的线程数量是“3”；
     *       2.如果提交了三个以上的线程，那么会保存在线程的队列中，直到有可用的线程；
     *       3.如果一个线程由于执行关闭期间的失败而终止，则执行器尚未被调用，则创建一个新线程；
     *       4.线程会一直存在，直到池关闭。
     */
}
