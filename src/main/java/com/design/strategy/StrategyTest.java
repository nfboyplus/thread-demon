package com.design.strategy;

/**
 * 策略模式：模拟不同会员购物车打折力度不同分为三种策略，初级会员，中级会员，高级会员
 */
public class StrategyTest {

    public static void main(String[] args){
        Context context;
        context = new Context(new StrategyA());
        context.algorithmInterface();
        context = new Context(new StrategyB());
        context.algorithmInterface();
        context = new Context(new StrategyC());
        context.algorithmInterface();
    }
}
