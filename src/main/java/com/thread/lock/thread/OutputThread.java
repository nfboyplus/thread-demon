package com.thread.lock.thread;

import com.thread.entity.User;

/**
 * 读线程
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
     * 使用Lock避免线程安全问题
     */
    public void run() {
        while (true) {
            try {
                user.lock.lock();
                if(!user.flag){
                    user.condition.await();
                }
                Thread.sleep(1000);
                System.out.println(user.getUserName() + "," + user.getUserSex());
                user.flag = false;
                user.condition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                user.lock.unlock();
            }
        }
    }

}
