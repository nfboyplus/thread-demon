package com.thread.lock;

import com.thread.communicate.exise.thread.InputThread;
import com.thread.communicate.exise.thread.OutputThread;
import com.thread.entity.User;

/**
 * created on 2019/7/1 16:08
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class ThreadLockConditionTest {

    /**
     * Condition 接口也提供了类似Object的监视器方法，与Lock配合可以实现等待/通知模式；
     */

    /**
     * Lock 与 synchronized 区别：
     * 1. Lock 可以判断是否获得锁，synchronized 无法知道是否获得锁；
     * 2. Lock 不能自动释放锁，必须在 finally 中手动释放锁，synchronized 可以自动释放锁；
     * 3. 两个线程 A和B：1.使用 synchronized 时，如果A获得锁，B等待，如果A阻塞，B会一直等待下去；
     *                   2.使用 Lock 时，不会一直等待下去，如果尝试获取不到锁，线程不会一直等待就结束了。
     */
    public static void main(String[] args){
        User res = new User();
        InputThread inputThread = new InputThread(res);
        OutputThread outputThread = new OutputThread(res);
        inputThread.start();
        outputThread.start();
    }


}
