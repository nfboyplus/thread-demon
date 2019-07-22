package com.design.simple.impl;

import com.design.simple.Car;

/**
 * created on 2019/7/15 19:20
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class AoDi implements Car {

    @Override
    public void run() {
        System.out.println("---- 我是奥迪汽车 ----");
    }
}
