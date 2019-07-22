package com.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * created on 2019/7/3 20:15
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class SingleThreadExecutorTest {

    /**
     * 单线程化线程池
     */
    public static void main(String[] args) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i <= 10; i++) {
            final int temp = 1;
            newSingleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("当temp=" + temp + "时，" + "当前线程" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(500);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
        }
        //执行shutdown()方法后，线程池状态变为SHUTDOWN状态，
        //此时，不能再往线程池中添加新任务，否则会抛出RejectedExecutionException异常;
        // 此时，线程池不会立刻退出，直到添加到线程池中的任务都已经处理完成，才会退出，即在终止前允许执行以前提交的任务;
//        newSingleThreadExecutor.shutdown();
        System.out.println("on the main thread...");

        try {
            if (!newSingleThreadExecutor.awaitTermination(2*1000, TimeUnit.MILLISECONDS)) {
                //执行shutdownNow()方法后，线程池状态会立刻变成STOP状态，
                //并试图停止所有正在执行的线程，不再处理还在池队列中等待的任务，会返回那些未执行的任务。
                //ShutdownNow()并不代表线程池就一定立即就能退出，它可能必须要等待所有正在执行的任务都执行完成了才能退出。
                newSingleThreadExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            // awaitTermination方法被中断的时候也中止线程池中全部的线程的执行。
            System.out.println("awaitTermination interrupted: " + e);
            newSingleThreadExecutor.shutdownNow();
        }
        System.out.println("on the main thread...");

    }

    /**
     * 结论：1.优点，串行执行所有任务；
     *       2.如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它；
     */
}
