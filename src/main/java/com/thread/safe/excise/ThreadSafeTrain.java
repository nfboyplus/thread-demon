package com.thread.safe.excise;

/**
 * created on 2019/6/30 14:36
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class ThreadSafeTrain implements Runnable{

    private int trainCount = 100;
    private Object object = new Object();

    /**
     * 线程安全：当多个线程共享一个“全局变量”或者“静态变量”的时候，做“写”的操作时，可能会发生数据冲突问题；
     * 解决线程安全方法：1.使用 synchronized；2.使用 Lock 锁；
     * 使用同步的时候，必须是同一把锁；
     */

    @Override
    public void run() {
        while (trainCount > 0) {
            try {
                Thread.sleep(50);
            } catch (Exception e) {

            }
            //同步方法
            sale();
            //同步代码块实例
            saleSynchronized();
        }

    }

    /**
     * 0.同步方法避免线程安全问题
     * 1.非静态同步函数使用 this 锁
     * 2.静态同步函数使用当前class字节码文件
     */
    private synchronized void sale() {
        if (trainCount > 0) {
            System.out.println(Thread.currentThread().getName() + ",出售第" + (100 - trainCount + 1) + "张票");
            trainCount--;
        }

    }

    /**
     * 同步代码块方式
     */
    private void saleSynchronized() {
        synchronized(object){
            if (trainCount > 0) {
                System.out.println(Thread.currentThread().getName() + ",出售第" + (100 - trainCount + 1) + "张票");
                trainCount--;
            }
        }
    }

    //结论：1. synchronized 修饰方法使用锁是当前this锁；
    //      2. synchronized 修饰静态方法使用锁是当前类的字节码文件。
}
