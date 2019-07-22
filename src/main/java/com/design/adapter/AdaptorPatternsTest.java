package com.design.adapter;

import com.design.adapter.impl.CN220VInterfaceImpl;

public class AdaptorPatternsTest {

    /**
     * 适配器模式测试
     * 例子：日本电压110V，中国电压220V，如果在中国使用日本的电饭锅，需要一个电源转换器
     */
    public static void main(String[] args){
        CN220VInterface cn220VInterface = new CN220VInterfaceImpl();
        //220V电源接口转换成110V电源接口
        PowerAdaptor powerAdaptor = new PowerAdaptor(cn220VInterface);
        ElectricCooker electricCooker = new ElectricCooker(powerAdaptor);
        //使用了适配器,在220V的环境可以工作
        electricCooker.cook();
    }

    /**
     * 结论：日本110V电饭锅，通过电源适配器（PowerAdaptor）转换后，使用中国220V电源煮饭；
     * 1. 110V电饭锅煮饭时，先连接100V电源（jp110VInterface.connect()）；
     * 2. 电源适配器实现了110V电源接口，且转接220V电源，因此...实现；
     */
}
