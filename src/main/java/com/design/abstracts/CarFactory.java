package com.design.abstracts;

/**
 * 抽象工厂
 */
public interface CarFactory {

    // 创建发动机
    Engine createEngine();

    // 创建座椅
    Chair createChair();

}
