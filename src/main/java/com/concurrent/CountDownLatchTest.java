package com.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * created on 2019/7/4 9:14
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class CountDownLatchTest {

    /**
     * CountDownLatch：位于并发包 “java.util.concurrent”下，可实现计数器的功能
     * 1.CountDownLatch(int count) 描述：实例化一个倒计数器，count指定计数个数
     * 2.countDown() 表示：计数减一
     * 3.await() 表示：等待，当计数减到0时，所有线程并行执行
     */

    /**
     * 1.latch.countDown();方法作用是通知CountDownLatch有一个线程已经准备完毕，倒计数器可以减一了;
     * 2.latch.await();方法要求主线程等待所有"2"个检查任务全部准备好才一起并行执行;
     */

    /**
     * 例子：有个任务A，等其他四个任务都执行完才能执行
     */

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        //线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ",子线程开始执行...");
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + ",子线程结束执行...");
            }
        }).start();
        //线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ",子线程开始执行...");
                //计算器值每次减去“1”
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + ",子线程结束执行...");
            }
        }).start();
        try {
            //减去为“0”，恢复任务继续执行
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("两个子线程执行完毕....");
        System.out.println("主线程继续执行.....");
        for (int i = 0; i <= 10; i++){
            System.out.println("主线程 i:" + i);
        }
    }


}
