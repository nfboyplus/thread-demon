package com.design.abstracts.impl;

import com.design.abstracts.Chair;

/**
 * created on 2019/7/16 15:33
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class ChairB implements Chair {

    @Override
    public void addHot() {
        System.out.println("B：座椅不能自动加热!");
    }

}
