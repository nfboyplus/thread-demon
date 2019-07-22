package com.design.factory;

import com.design.factory.impl.AoDiFactory;
import com.design.factory.impl.JiLiFactory;

/**
 * created on 2019/7/15 20:02
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class FactoryTest {

    /**
     * 工厂模式：用来生产同一等级结构中的固定产品（支持拓展增加产品）
     */
    public static void main(String[] args) {
        Car aodi = new AoDiFactory().createCar();
        Car jili = new JiLiFactory().createCar();
        aodi.run();
        jili.run();
    }

    /**
     * 结论：
     * 1. 抽象的工厂，既 CarFactory，吉利工厂，奥迪工厂...实现该工厂方法；
     * 2.抽象的产品，既 Car，吉利车，奥迪车...实现该产品的创建；
     */

}
