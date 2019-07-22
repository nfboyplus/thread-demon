package com.design.observer;

/**
 * 观察者的接口，用来存放观察者共有方法
 */
public interface Observer {


    void update(Subject subject);
}
