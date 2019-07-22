package com.design.facade.impl;

import com.design.facade.AliSmsService;

/**
 * 阿里短信接口实现
 */
public class AliSmsServiceImpl implements AliSmsService {

    @Override
    public void sendSms() {
        System.out.println("---- 发送阿里消息 ----");
    }

}
