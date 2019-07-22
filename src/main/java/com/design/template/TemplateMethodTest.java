package com.design.template;

/**
 * 模板方式：先取号，排对，办理业务（核心部分我们子类完成），给客服人员评分，完毕
 */
public class TemplateMethodTest {

    public static void main(String[] args){
        BankTemplateMethod bankTemplateMethod = new DrawMoney();
        bankTemplateMethod.process();
    }
}
