package com.design.abstracts.impl;

import com.design.abstracts.CarFactory;
import com.design.abstracts.Chair;
import com.design.abstracts.Engine;

/**
 * 具体工厂实现抽象工厂
 */
public class JiLiFactory implements CarFactory {

    @Override
    public Engine createEngine() {
        return new EngineA();
    }

    @Override
    public Chair createChair() {
        return new ChairA();
    }
}
