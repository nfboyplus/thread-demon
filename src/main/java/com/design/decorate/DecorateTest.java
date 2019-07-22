package com.design.decorate;

import com.design.decorate.impl.HouseDecorate;
import com.design.decorate.impl.HouseDecorateImpl;

/**
 * 装饰者模式: 未理解
 */
public class DecorateTest {

    public static void main(String[] args){
        HouseDecorateImpl houseDecorateImpl = new HouseDecorateImpl();
        System.out.println("---- 新增贴上墙纸 ----");
        HouseDecorate houseDecorate = new HouseDecorate(houseDecorateImpl);
        houseDecorate.run();
    }

    /**
     * 结论：
     * 1. 将创建的 HouseDecorateImpl对象给到 HouseDecorate(houseDecorateImpl)；
     * 2. houseDecorate.run() 调用的时候，就会走 HouseDecorateImpl 里的方法(houseDecorateImpl 实现了 House 接口)；
     */
}
