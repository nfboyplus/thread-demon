package com.design.facade.impl;

import com.design.facade.WeiXinSmsService;

/**
 * created on 2019/7/18 10:19
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class WeiXinSmsServiceImpl implements WeiXinSmsService {

    @Override
    public void sendSms() {
        System.out.println("---- 发送微信消息 ----");
    }
}
