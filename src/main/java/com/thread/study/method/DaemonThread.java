package com.thread.study.method;

/**
 * created on 2019/6/30 13:37
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class DaemonThread implements Runnable{

    /**
     * 守护线程：当进程不存在或者主线程停止，守护线程也会停止；
     * 用户线程：用户自定义创建的线程，主线程停止，用户线程不受影响；
     */

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("---- 我是子线程 ----");
        }
    }

}
