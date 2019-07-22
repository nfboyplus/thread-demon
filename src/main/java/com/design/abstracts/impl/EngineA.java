package com.design.abstracts.impl;

import com.design.abstracts.Engine;

/**
 * created on 2019/7/16 15:21
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class EngineA implements Engine {

    @Override
    public void run() {
        System.out.println("A：发动机转的快!");
    }

    @Override
    public void start() {
        System.out.println("A：发动机启动快,自动档!");
    }
}
