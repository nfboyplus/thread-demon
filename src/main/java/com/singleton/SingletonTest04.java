package com.singleton;

/**
 * created on 2019/7/15 9:14
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class SingletonTest04 {

    /**
     * 双重检验锁：
     * 1.是一种使用同步块加锁的方法。程序员称其为双重检查锁，因为会有两次检查 instance == null，一次是在同步块外，一次是在同步块内。
     * 2.为什么在同步块内还要再检验一次？因为可能会有多个线程一起进入同步块外的 if，如果在同步块内不进行二次检验的话就会生成多个实例了。
     */

    private SingletonTest04 singletonTest04;
    private static boolean flag = false;

    private SingletonTest04(){
        if (!flag){
            flag = true;
        }else {
            throw new RuntimeException("单例模式被侵犯！");
        }
    }

    public SingletonTest04 getInstance(){
        if (singletonTest04 == null){
            synchronized (this){
                if (singletonTest04 == null){
                    singletonTest04 = new SingletonTest04();
                }
            }
        }
        return singletonTest04;
    }
    public static void main(String[] args) {
    }

}
