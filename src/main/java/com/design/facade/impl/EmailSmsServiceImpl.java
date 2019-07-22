package com.design.facade.impl;

import com.design.facade.EmailSmsService;

/**
 * 邮件接口的实现
 */
public class EmailSmsServiceImpl implements EmailSmsService {

    @Override
    public void sendSms() {
        System.out.println("---- 发送邮件消息 ----");
    }
}
