package com.thread.communicate.exise.thread;

import com.thread.entity.User;

/**
 * created on 2019/7/1 15:15
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class OutputThread extends Thread{

    private User user;

    public OutputThread(User user){
        this.user = user;
    }

    /**
     * 使用synchronized避免线程安全问题
     */
    public void run() {
        while (true) {
            synchronized (user) {
                if (!user.flag) {
                    try {
                        user.wait();
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(user.getUserName() + "," + user.getUserSex());
                user.flag = false;
                user.notify();
            }
        }
    }

}
