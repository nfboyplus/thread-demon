package com.thread.study.method;

/**
 * created on 2019/6/30 11:41
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class CreateThread extends Thread {
    /**
     * 继承 Thread 类，重写 run()，不推荐使用，因为继承类之后不能继续继承了；
     */
    public void run() {
        for (int i = 0; i <= 10; i++){
            System.out.println("子线程：i:" + i);
        }
    }
}
