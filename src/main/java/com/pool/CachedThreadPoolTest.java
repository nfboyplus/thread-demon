package com.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * created on 2019/7/2 9:13
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class CachedThreadPoolTest {

    /**
     * 可以缓存的线程池
     */
    public static void main(String[] args) {
        //可以缓存的线程池
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //
            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("当temp=" + temp + "时，" + "当前线程" + Thread.currentThread().getName());
                }
            });
        }

        /**
         * 结论：1. 发现10个线程都是使用的“线程一”；
         *       2. 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
         */

    }
}
