package com.design.strategy;

/**
 * 使用上下文维护算法策略
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy){
        //this.strategy 是上面定义的参数
        this.strategy = strategy;
    }

    public void algorithmInterface(){
        strategy.algorithmInterface();
    }
}
