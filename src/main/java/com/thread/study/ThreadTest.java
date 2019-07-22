package com.thread.study;

/**
 * created on 2019/6/30 12:21
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class ThreadTest {

    /**
     * 匿名内部类实现多线程
     */
    public static void main(String[] args){
        //匿名内部类实现多线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<=10; i++){
                    System.out.println("子线程：i:" + i);
                }
            }
        });
        //执行线程
        thread.start();
        for (int i = 0; i<= 10; i++){
            System.out.println("主线程：i:" + i);
        }
        System.out.println("-----主线程运行结束-----");
    }

}
