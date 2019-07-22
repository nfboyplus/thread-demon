package com.design.decorate.impl;

import com.design.decorate.House;

/**
 * 房屋装饰类
 */
public class HouseDecorate implements House {

    private House house;

    public HouseDecorate(House house){
        this.house = house;
    }

    @Override
    public void run() {
        house.run();
    }
}
