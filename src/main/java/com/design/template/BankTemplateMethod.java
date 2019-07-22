package com.design.template;

/**
 * 银行办理业务为例：模板中把办理业务用作核心部分，让子类来实现
 */
public abstract class BankTemplateMethod {

    //排队取号
    public void takeNumber(){
        System.out.println("---- 排队取号 ----");
    }

    //每个子类不同的业务实现，由各自子类实现
    abstract void transact();

    //评价
    public void evaluate(){
        System.out.println("---- 反馈评价 ----");
    }

    public void process(){
        takeNumber();
        transact();
        evaluate();
    }
}
