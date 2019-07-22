package com.thread.communicate.exise.thread;

import com.thread.entity.User;

/**
 * created on 2019/7/1 15:15
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class InputThread extends Thread {

    private User user;

    public InputThread(User user){
        this.user = user;
    }

    /**
     * 使用synchronized避免线程安全问题
     */
    public void run(){
        int count = 0;
        while (true) {
            synchronized (user) {
                if (user.flag) {
                    try {
                        // 当前线程被等待，注意一定要和对象锁(监视器一起使用),釋放锁的资源
                        user.wait();
                    } catch (Exception e) {

                    }
                }
                if (count == 0) {
                    user.setUserName("小红");
                    user.setUserSex("女");
                } else {
                    user.setUserName("小军");
                    user.setUserSex("男");
                }
                count = (count + 1) % 2;
                user.flag = true;
                //唤醒当前被等待的线程
                user.notify();
            }

        }
    }

}
