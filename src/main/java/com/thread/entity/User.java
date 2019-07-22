package com.thread.entity;

import lombok.Data;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * created on 2019/7/1 15:09
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
@Data
public class User {

    private String userName;
    private String userSex;
    // 为true 情况下 允许读，不能写
    // 为false 情况下 允许写，不能读。
    public boolean flag = false;

    /**
     * Lock 锁
     */
    public Lock lock = new ReentrantLock();

    /**
     * Condition 接口也提供了类似Object的监视器方法，与Lock配合可以实现等待/通知模式；
     */
    public Condition condition = lock.newCondition();

}
