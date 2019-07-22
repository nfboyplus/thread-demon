package com.thread.safe;

import com.thread.safe.excise.ThreadSafeTrain;

/**
 * created on 2019/6/30 14:42
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class ThreadSafeTrainTest {

    public static void main(String[] args){
        ThreadSafeTrain threadSafeTrain = new ThreadSafeTrain();
        Thread t1 = new Thread(threadSafeTrain,"窗口一");
        Thread t2 = new Thread(threadSafeTrain, "窗口二");
        t1.start();
        t2.start();

        //结论：一二两个窗口卖出了相同的火车票；
        //结论：避免上述问题，在sale()方法加锁 synchronized，synchronized 保证线程的原子性，但是降低程序运行效率；
    }
}
