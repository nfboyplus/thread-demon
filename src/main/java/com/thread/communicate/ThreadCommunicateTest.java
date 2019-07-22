package com.thread.communicate;

import com.thread.communicate.exise.thread.InputThread;
import com.thread.communicate.exise.thread.OutputThread;
import com.thread.entity.User;

/**
 * created on 2019/7/1 15:08
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class ThreadCommunicateTest {

    /**
     * sleep() 方法是Thread类里面的，在调用 sleep()时，线程不会释放对象锁，时间到了自动醒来,无需唤醒；
     * wait() 方法是Object类里面的，调用wait()时，线程释放对象锁，必须调用notify或者notifyAll方法才能唤醒；
     * @param args
     */
    public static void main(String[] args){
        User res = new User();
        InputThread inputThread = new InputThread(res);
        OutputThread outputThread = new OutputThread(res);
        inputThread.start();
        outputThread.start();
    }
}
