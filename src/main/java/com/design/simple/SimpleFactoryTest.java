package com.design.simple;

/**
 * created on 2019/7/15 19:24
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class SimpleFactoryTest {

    /**
     * 简单工厂：用来生产同一等级结构中的任意产品（不支持拓展增加产品）
     */
    public static void main(String[] args){
        Car aodi  = CarFactory.createCar("奥迪");
        Car jili  = CarFactory.createCar("吉利");
        aodi.run();
        jili.run();
    }
}
