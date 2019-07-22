package com.design.adapter.impl;

import com.design.adapter.JP110VInterface;

/**
 * 日本110V电源接口的实现
 */
public class JP110VInterfaceImpl implements JP110VInterface {

    @Override
    public void connect() {
        System.out.println("---- 日本110V电源接通,开始工作 ----");
    }
}
