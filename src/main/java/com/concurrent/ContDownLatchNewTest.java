package com.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * created on 2019/7/4 17:19
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class ContDownLatchNewTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CountDownLatch countDownLatch = new CountDownLatch(3);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    function1();
                } catch (Exception e) {
                    //异常处理
                    e.printStackTrace();
                }
                finally {
                    countDownLatch.countDown();
                }
//                 function1();
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                function2();
                countDownLatch.countDown();
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                function3();
                countDownLatch.countDown();
            }
        });

        try {
//            countDownLatch.await();
            countDownLatch.await(20, TimeUnit.SECONDS);
            System.out.println("---- 三个执行线程结束 ----");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("---- 执行线程异常 ----");
        }
        finally {
            executorService.shutdown();
            System.out.println("---- 执行线程关闭 ----");
        }


    }

    private static void function1(){
        int i = 10/0;
        System.out.println("---- 方法一执行完毕 ----");
    }

    private static void function2(){
        System.out.println("---- 方法二执行完毕 ----");
    }

    private static void function3(){
        System.out.println("---- 方法三执行完毕 ----");
    }

    /**
     * 结论：1.上述代码注释之前，方法二，方法三完美运行结束，方法一抛出异常，但是整个线程并没有结束运行，既没有走 executorService.shutdown() 方法；
     *       2.因为 function1() 方法明显不合理（“10/0”）,因此需要异常处理；
     *       3.并且 设置 countDownLatch.await(20, TimeUnit.SECONDS); 时间到了，走 executorService.shutdown() 方法，结束整个线程运行；
     */

}
