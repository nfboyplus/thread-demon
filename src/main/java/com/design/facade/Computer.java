package com.design.facade;

import com.design.facade.impl.AliSmsServiceImpl;
import com.design.facade.impl.EmailSmsServiceImpl;
import com.design.facade.impl.WeiXinSmsServiceImpl;

/**
 * 外观模式：门面类
 */
public class Computer {

    private EmailSmsService emailSmsService;
    private WeiXinSmsService weiXinSmsService;
    private AliSmsService aliSmsService;

    public Computer(){
        emailSmsService = new EmailSmsServiceImpl();
        weiXinSmsService = new WeiXinSmsServiceImpl();
        aliSmsService = new AliSmsServiceImpl();
    }

    public void sendMsg() {
        emailSmsService.sendSms();
        weiXinSmsService.sendSms();
        aliSmsService.sendSms();
    }
}
