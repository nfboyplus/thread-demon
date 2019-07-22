package com.design.facade;

public class FacadePatternsTest {

    /**
     * 外观模式测试：用户注册完之后，需要调用阿里短信接口、邮件接口、微信推送接口
     */

    public static void main(String[] args){
        new Computer().sendMsg();
    }

    /**
     * 结果：调用门面类Computer,即可实现发送消息
     */

}
