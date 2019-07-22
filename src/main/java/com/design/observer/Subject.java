package com.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察对象的父类
 */
public class Subject {

    private List<Observer> list = new ArrayList<>();

    /**
     * 注册观察者方法
     */
    public void registerObserver(Observer observer){
        list.add(observer);
    }

    /**
     * 删除观察者方法
     */
    public void removeObserver(Observer observer) {
        list.remove(observer);
        this.notifyAllObserver();
    }

    /**
     * 通知所有观察者更新
     */
    public void notifyAllObserver() {
        for (Observer observer : list){
            observer.update(this);
        }
    }


}
