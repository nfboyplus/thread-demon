package com.thread.lock.thread;

import com.thread.entity.User;

/**
 * 写线程
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
            try {
                // 上锁
                user.lock.lock();
                if(user.flag){
                    //类似 wait()
                    user.condition.await();
                }
                if (count == 0) {
                    user.setUserName("小红");
                    user.setUserSex("女");
                } else {
                    user.setUserName("小军");
                    user.setUserSex("男");
                }
                count = (count + 1) % 2;// 0 1 0 1 0 1
                user.flag=true;
                //类似 notify()
                user.condition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 释放当前锁
                user.lock.unlock();
            }
        }
    }

}
