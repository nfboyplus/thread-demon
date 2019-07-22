package com.singleton;

/**
 * created on 2019/7/5 17:43
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class SingletonTest03 {

    /**
     * 单例模式：静态内部类
     */

    private SingletonTest03() {
        System.out.println("---- 初始化 ----");
    }

    public static class SingletonClassInstance {
        private static final SingletonTest03 singletonDemo03 = new SingletonTest03();
    }

    /**
     * 方法没有同步
     *
     * @return
     */
    public static SingletonTest03 getInstance() {
        System.out.println("getInstance");
        return SingletonClassInstance.singletonDemo03;
    }

    public static void main(String[] args){
        System.out.println("main");
        SingletonTest03 A = SingletonTest03.getInstance();
        SingletonTest03 B = SingletonTest03.getInstance();
        System.out.println( A == B);
    }

    /**
     * 结果：true
     */


}
