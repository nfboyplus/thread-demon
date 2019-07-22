package com.pool;

import java.util.concurrent.*;

/**
 * created on 2019/7/3 13:18
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class ScheduledThreadPoolTest {

    /**
     * 可以定时线程池
     */
    public static void main(String[] args) {
        //可以定时线程池
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3);
        for (int i = 0; i <= 10; i++) {
            final int temp = i;
            newScheduledThreadPool.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("当temp=" + temp + "时，" + "当前线程" + Thread.currentThread().getName());
                }
            },10,TimeUnit.SECONDS);
        }
    }

    /**
     * 结论：1.创建了一个线程池大小为2的线程；
     *       2.此线程会等待10S才执行，这个10秒是由于我们设置的 newScheduledThreadPool.schedule(new MyRunnable(), 10, TimeUnit.SECONDS);
     */
}
