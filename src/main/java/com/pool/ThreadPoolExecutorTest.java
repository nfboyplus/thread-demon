package com.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * created on 2019/7/3 20:36
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class ThreadPoolExecutorTest {

    /**
     * ThreadPoolExecutor 参数：
     * 1.corePoolSize 核心线程池大小
     * 2.maximumPoolSize 最大线程池大小
     * 3.keepAliveTime  线程最大空闲时间
     * 4.unit 时间单位
     * 5.workQueue 线程等待队列
     * 6.threadFactory 线程创建工厂
     * 7.handler 拒绝策略
     */

    public static void main(String[] args){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,
                                                                       10,
                                                                       100,
                                                                        TimeUnit.MICROSECONDS,
                                                                        new ArrayBlockingQueue<Runnable>(5));
        for (int i = 0; i <= 10; i++){
            MyTask myTask = new MyTask(i);
            threadPoolExecutor.execute(myTask);
            System.out.println("线程池中线程数目：" + threadPoolExecutor.getPoolSize()
                               + "，队列中等待执行的任务数目：" + threadPoolExecutor.getQueue().size()
                               + "，已执行玩别的任务数目：" + threadPoolExecutor.getCompletedTaskCount());
        }
        threadPoolExecutor.shutdown();
    }

    static class MyTask implements Runnable {
        private int taskNum;

        public MyTask(int num) {
            this.taskNum = num;
        }
        @Override
        public void run() {
            System.out.println("正在执行task " + taskNum);
            try {
                Thread.currentThread().sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task " + taskNum + "执行完毕");
        }
    }

    /**
     * 结论：可用于Web服务瞬时削峰，但需注意长时间持续高峰情况造成的队列阻塞
     */

    /**
     * 总结：
     * 1.FixedThreadPool 和 SingleThreadPool : 允许的请求“队列长度”为 Integer.MAX_VALUE ，可能会堆积大量的请求，从而导致 OOM
     * 2.CachedThreadPool 和 ScheduledThreadPool : 允许的创“建线程数量”为 Integer.MAX_VALUE ，可能会创建大量的线程，从而导致 OOM
     */

    /**
     * 线程池工作原理：Executors.newCachedThreadPool()
     * 一、
     * 1.提交一个线程到线程池中，判断线程池的核心线程是否都在执行任务；
     * 2.如果不是（""核心线程空闲或者还有核心线程没有创建），则创建一个新的工作线程来执行任务；
     * 3.如果核心线程都在执行任务，则进入下一个流程；
     * 二、
     * 1.线程池判断工作队列是否已满；
     * 2.如果工作队列没有满，则将新提交的任务存储在这个工作队列里，如果工作队列满了，进入下一个流程；
     * 三、
     * 1.判断线程池里的线程是否都处于工作状态，如果没有，则创建一个新的工作线程来执行任务；
     * 2.如果都处于工作状态，则交给饱和策略来处理这个任务。
     */

}
