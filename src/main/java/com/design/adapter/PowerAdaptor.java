package com.design.adapter;

/**
 * 电源适配器
 */
public class PowerAdaptor implements JP110VInterface{

    private CN220VInterface cn220VInterface;

    PowerAdaptor(CN220VInterface cn220VInterface){
        this.cn220VInterface = cn220VInterface;
    }

    @Override
    public void connect() {
        cn220VInterface.connect();
    }
}
