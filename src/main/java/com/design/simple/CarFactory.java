package com.design.simple;

import com.design.simple.impl.AoDi;
import com.design.simple.impl.JiLi;
import org.apache.commons.lang3.StringUtils;

/**
 * created on 2019/7/15 19:22
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class CarFactory {

    /**
     * 简单工厂设计模式(4S店): 工厂创建对象
     *
     * 优点：
     * 1.简单工厂模式能够根据外界给定的信息，决定究竟应该创建哪个具体类的对象；
     * 2.明确区分了各自的职责和权力，有利于整个软件体系结构的优化；
     *
     * 缺点：
     * 1.很明显工厂类集中了所有实例的创建逻辑，容易违反GRASPR的高内聚的责任分配原则；
     */
    public static Car createCar(String name) {

        if (StringUtils.isEmpty(name)) {
            return null;
        }
        if(name.equals("奥迪")){
            //工厂创建对象
            return new AoDi();
        }
        if(name.equals("吉利")){
            //工厂创建对象
            return new JiLi();
        }
        return null;
    }

}
