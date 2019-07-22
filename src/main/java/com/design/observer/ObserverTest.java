package com.design.observer;

/**
 * 观察者模式：应用跨系统的消息交换场景，如消息队列、事件总线的处理机制
 */
public class ObserverTest {

    public static void main(String[] args){
        // 目标对象
        RealObserver realObserver = new RealObserver();
        //创建多个观察者
        ObserverA observerA = new ObserverA();
        // 注册到观察队列中
        realObserver.registerObserver(observerA);
        // 改变State状态
        realObserver.setState(300);
        System.out.println(observerA.getMyState());
        // 改变State状态
        realObserver.setState(400);
        System.out.println(observerA.getMyState());

    }

    /**
     * 结论：使创建订单和消息通知进行分离，低耦合；
     */
}
