package com.concurrent;

import java.util.concurrent.CyclicBarrier;

/**
 * created on 2019/7/4 17:43
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class CyclicBarrierTest {

    /**
     * CyclicBarrierTest：一个线程组的线程需要等待所有线程完成任务后再继续执行下一次任务；
     * 1.可以使一定数量的线程反复地在栅栏位置处汇集；
     * 2.当线程到达栅栏位置时将调用await方法，这个方法将阻塞直到所有线程都到达栅栏位置；
     * 3.如果所有线程都到达栅栏位置，那么栅栏将打开，此时所有的线程都将被释放，而栅栏将被重置以便下次使用；
     *
     */

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for (int i = 0; i < 5; i++) {
            Writer writer = new Writer(cyclicBarrier);
            writer.start();
        }
    }

}

class Writer extends Thread {

    private CyclicBarrier cyclicBarrier;

    public Writer(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run() {
//        synchronized (cyclicBarrier){
        System.out.println("---- 线程" + Thread.currentThread().getName() + ",正在写入数据 ----");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("---- 线程" + Thread.currentThread().getName() + ",写入数据成功 ----");
//        }
        //
        try {
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("---- 所有线程执行完毕 ----");
    }

    /**
     * 结论：等待所有线程执行结束，才会执行所有线程均已完成
     * 例子：1.就像生活中我们会约朋友们到某个餐厅一起吃饭，有些朋友可能会早到，有些朋友可能会晚到；
     *      2.但是这个餐厅规定必须等到所有人到齐之后才会让我们进去。这里的朋友们就是各个线程，餐厅就是 CyclicBarrier；
     */
}
