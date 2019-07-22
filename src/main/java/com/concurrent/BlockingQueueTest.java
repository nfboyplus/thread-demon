package com.concurrent;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * created on 2019/7/5 14:24
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class BlockingQueueTest {

    /**
     * BlockingQueue：
     * 0.阻塞队列,是一个接口，继承Queue接口，Queue接口继承 Collection，队列先进先出;
     * 1.最常用的是用于实现生产者与消费者模式;
     * 2.新的元素将会被插入到队列的尾部;
     * 3.使用一个AtomicInteger类型的变量表示当前队列中含有的元素个数，所以可以确保两个线程之间操作底层队列是线程安全的;
     * 4.实现类有 ArrayBlockingQueue、DelayQueue、 LinkedBlockingDeque、LinkedBlockingQueue、PriorityBlockingQueue、SynchronousQueue等;
     * 5.LinkedBlockingQueue：一个单向链表+两把锁+两个条件，入队列和出队列都高并发时候使用；
     * 5.ArrayBlockingQueue：一个对象数组+一把锁+两个条件，入队列或者出队列，二者有一是高并发时候使用，大小有限；
     */

    public static void main(String[] args){
        //10表示可入队列的数量
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(10);
        ProducerThread producerThread = new ProducerThread(blockingQueue);
        ConsumerThread consumerThread = new ConsumerThread(blockingQueue);
        Thread a = new Thread(producerThread);
        Thread b = new Thread(consumerThread);
        a.start();
        b.start();
        //10秒后停止生产者线程
        try{
            Thread.sleep(10000);
            producerThread.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

/**
 * 生产者
 */
class ProducerThread implements Runnable {

    private BlockingQueue<String> blockingQueue;
    private AtomicInteger count = new AtomicInteger();
    private volatile boolean flag = true;

    public ProducerThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        System.out.println("---- " + Thread.currentThread().getName() + ",生产者开始启动 ----");
        try{
            while (flag){
                String data = count.incrementAndGet() + "";
                boolean offer = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
                if (offer){
                    System.out.println("---- A生产者存入队列成功，data:" + data + " ----");
                }else {
                    System.out.println("---- A生产者存入队列失败，data:" + data + " ----");
                }
                Thread.sleep(1000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("---- " + Thread.currentThread().getName() + ",生产者线程停止 ----");
        }

    }

    public void stop(){
        this.flag = false;
    }
}

/**
 * 消费者
 */
class ConsumerThread implements Runnable{

    private volatile boolean flag = true;

    private BlockingQueue<String> blockingQueue;

    public ConsumerThread(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        System.out.println("---- " + Thread.currentThread().getName() + ",消费者开始启动 ----");
        try{
            while (flag){
                String data = blockingQueue.poll(2, TimeUnit.SECONDS);
                if (StringUtils.isBlank(data)){
                    flag = false;
                    System.out.println("---- B消费者超过2秒时间未获取到消息 ----");
                    return;
                }
                System.out.println("---- B消费者取到队列成功，data:" + data + " ----");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("---- " + Thread.currentThread().getName() + ",消费者线程停止 ----");
        }
    }
}
