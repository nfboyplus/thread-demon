package com.design.adapter;

/**
 * 日本110V电饭锅
 */
public class ElectricCooker {

    private JP110VInterface jp110VInterface;

    /**
     * 将其他传过来的电源接口转成对应的 this 接口
     */
    ElectricCooker(JP110VInterface jp110VInterface){
        this.jp110VInterface = jp110VInterface;
    }

    public void cook(){
        jp110VInterface.connect();
        System.out.println("---- 日本电饭锅，开始做法啦 ----");
    }
}
