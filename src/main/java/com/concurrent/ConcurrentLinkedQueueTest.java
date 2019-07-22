package com.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * created on 2019/7/5 14:02
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class ConcurrentLinkedQueueTest {

    /**
     * ConcurrentLinkedQueue：
     * 0.一个基于链接节点的无界线程安全队列，它采用“先进先出”的规则对节点进行排序；
     * 1.当我们添加一个元素的时候，它会添加到队列的尾部，当我们获取一个元素时，它会返回队列头部的元素；
     * 2.非阻塞队列，可以无限的存，且线程是安全的；
     * 3.不要使用 size()>0 判断是否有元素，使用isEmpty(),前者很耗时；
     * 4.由head和tail节点组成，节点与节点之间通过next连接，从而来组成一个链表结构的队列；
     * 5.先进先出原则；
     */

    public static void main(String[] args){
        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        concurrentLinkedQueue.offer("余胜军");
        concurrentLinkedQueue.offer("码云");
        concurrentLinkedQueue.offer("蚂蚁课堂");
        concurrentLinkedQueue.offer("张杰");
        concurrentLinkedQueue.offer("艾姐");
        //从头获取元素,只能取一个
        System.out.println(concurrentLinkedQueue.poll());

        //从头获取元素,不刪除该元素
//        System.out.println(concurrentLinkedQueue.peek());
        //获取总长度
        System.out.println(concurrentLinkedQueue.size());

    }
}
