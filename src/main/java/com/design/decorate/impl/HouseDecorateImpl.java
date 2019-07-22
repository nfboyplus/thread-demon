package com.design.decorate.impl;

import com.design.decorate.House;

/**
 * 房屋基本功能默认实现
 */
public class HouseDecorateImpl implements House {

    @Override
    public void run() {
        System.out.println("---- 房屋已经交付,为毛坯 ----");
    }
}
