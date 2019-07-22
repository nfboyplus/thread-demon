package com.design.factory.impl;

import com.design.factory.Car;
import com.design.factory.CarFactory;
import com.design.factory.impl.AoDi;

/**
 * created on 2019/7/15 19:59
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class AoDiFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new AoDi();
    }
}
