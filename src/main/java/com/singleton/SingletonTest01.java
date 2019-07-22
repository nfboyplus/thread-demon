package com.singleton;

/**
 * created on 2019/7/5 17:09
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class SingletonTest01 {

    /**
     * 单例模式：饿汉式
     */

    // 类初始化时,会立即加载该对象，线程天生安全,调用效率高
    public static SingletonTest01 singletonTest01 = new SingletonTest01();

    private SingletonTest01(){
        System.out.println("---- SingletonDemo01初始化 ----");
    }

    public static SingletonTest01 getInstance(){
        System.out.println("getInstance");
        return singletonTest01;
    }

    public static void main(String[] args){
        SingletonTest01 a = SingletonTest01.getInstance();
        SingletonTest01 b = SingletonTest01.getInstance();
        System.out.println(a == b);
    }

    /**
     * 结果：true
     */

}
