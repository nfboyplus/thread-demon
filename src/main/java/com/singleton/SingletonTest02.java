package com.singleton;

/**
 * created on 2019/7/5 17:15
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class SingletonTest02 {

    /**
     * 单例模式：懒汉式
     */

    //类初始化时，不会初始化该对象，真正需要使用的时候才会创建该对象
    private static SingletonTest02 singletonTest02;

    private SingletonTest02(){

    }

    public synchronized static SingletonTest02 getInstance(){
        if (singletonTest02 == null){
            singletonTest02 = new SingletonTest02();
        }
        return singletonTest02;
    }

    public static void main(String[] args){
        SingletonTest02 a = SingletonTest02.getInstance();
        SingletonTest02 b = SingletonTest02.getInstance();
        System.out.println(a == b);
    }

    /**
     * 结果：true
     */

}
