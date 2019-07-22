package com.design.abstracts;

import com.design.abstracts.impl.JiLiFactory;

/**
 * 抽象工厂：汽车产业制造
 */
public class AbstractFactoryTest {

    /**
     * 抽象工厂：用来生产不同产品族的全部产品（不支持拓展增加产品；支持增加产品族）
     */
    public static void main(String[] args) {

        CarFactory carFactory = new JiLiFactory();
        Engine engine = carFactory.createEngine();
        engine.run();
        engine.start();

    }

    /**
     * 结论：
     * 1. 抽象工厂用来创建具体工厂，汽车厂可以生产吉利，宝马，奔驰...汽车，例如：CarFactory（抽象工厂） 产生 JiLiFactory；
     * 2. 吉利汽车厂生产引擎A，引擎B...属于产品组（支持拓展），而引擎接口，座椅接口...相当于产品树（不支持拓展）；
     */

}
