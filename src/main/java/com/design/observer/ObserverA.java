package com.design.observer;

import lombok.Data;

/**
 * created on 2019/7/19 14:18
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
@Data
public class ObserverA implements Observer{

    /**
     * 需要和目标对象的state值保持一致.
     */
    private int myState;


    @Override
    public void update(Subject subject) {
        myState = ((RealObserver)subject).getState();
    }
}
