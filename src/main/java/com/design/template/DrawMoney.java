package com.design.template;

/**
 * 具体的模板方法的子类：核心业务由子类实现
 */
public class DrawMoney extends BankTemplateMethod {

    @Override
    void transact() {
        System.out.println("---- 我要取款 ----");
    }
}
