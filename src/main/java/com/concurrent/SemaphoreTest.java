package com.concurrent;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * created on 2019/7/4 19:12
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class SemaphoreTest {

    /**
     * Semaphore:
     * 1.是一种基于计数的信号量。它可以设定一个阈值，基于此，多个线程竞争获取许可信号，做自己的申请后归还，超过阈值后，线程申请许可信号将会被阻塞;
     * 2.availablePermits函数用来获取当前可用的资源数量
     * 3.wc.acquire(); //申请资源
     * 4.wc.release();// 释放资源
     */

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 10; i++) {
            ThreadDemo threadDemo = new ThreadDemo("第" + i + "个等待的人", semaphore);
            threadDemo.start();
        }

    }
}


class ThreadDemo extends Thread {
    private String name;
    private Semaphore wc;

    public ThreadDemo(String name, Semaphore wc) {
        this.name = name;
        this.wc = wc;
    }

    @Override
    public void run() {
        // 剩下的资源
        int availablePermits = wc.availablePermits();
        if (availablePermits > 0) {
            System.out.println(name + "---- 天呐，终于排到我了 ----");
        } else {
            System.out.println(name + "---- 哎，怎么没有位置了 ----");
        }
        try {
            // 申请资源
            wc.acquire();
        } catch (InterruptedException e) {

        }
        System.out.println(name + "终于有位置了" + ",剩下的位置:" + wc.availablePermits());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(name + "---- 我已经办完事啦 -----");
        // 释放资源
        wc.release();
    }

    /**
     * 结论：
     * 1.一种比较通俗的方式来跟大家解释一下，就是在该类初始化的时候，给定一个数字A；
     * 2.每个线程调用acquire()方法后，首先判断A是否大于0，如果大于0，就将A减去1，然后执行对应的线程；
     * 3.如果不大于0，那么就会阻塞，直到其他线程调用了release()方法，将A加上1，该线程可能有执行的机会。
     */

    /**
     * 1.根据AQS共享锁的规则，返回值小于0则代表无法获取到锁需要入同步队列等待。若大于等于0，线程不会被阻塞；
     */

}
