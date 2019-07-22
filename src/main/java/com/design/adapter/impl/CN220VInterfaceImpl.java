package com.design.adapter.impl;

import com.design.adapter.CN220VInterface;

/**
 * 中国220V电源接口实现
 */
public class CN220VInterfaceImpl implements CN220VInterface {

    @Override
    public void connect() {
        System.out.println("---- 中国220V电源接通,开始工作 ----");
    }
}
