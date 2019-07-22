package com.thread.study;

import com.thread.study.excise.ThreadOne;
import com.thread.study.excise.ThreadThree;
import com.thread.study.excise.ThreadTwo;

/**
 * created on 2019/6/30 14:15
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class ExciseTest {

    public static void main(String[] args){
        //threadOne
        ThreadOne threadOne = new ThreadOne();
        Thread t1 = new Thread(threadOne);
        //threadTwo
        ThreadTwo threadTwo = new ThreadTwo();
        Thread t2 = new Thread(threadTwo);
        //threadThree
        ThreadThree threadThree = new ThreadThree();
        Thread t3 = new Thread(threadThree);
        t1.start();
        try {
            t1.join();
            t2.start();
        }catch (Exception e){
            e.printStackTrace();
        }
        //
        try {
            t2.join();
            t3.start();
        }catch (Exception e){
            e.printStackTrace();
        }

        //结论：三个线程，t1执行完，t2执行；t2执行完，t3执行；
    }
}
