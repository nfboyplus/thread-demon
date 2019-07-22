package com.design.proxy.quiet;

import com.design.proxy.quiet.impl.IUserDaoImpl;

/**
 * created on 2019/7/16 20:36
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class ProxyFactoryTest {

    /**
     * 静态代理：在程序运行前就已经存在代理类的字节码文件，代理类和委托类的关系在运行前就确定了
     */

    public static void main(String[] args){
        IUserDao iUserDao = new IUserDaoImpl();
        UserDaoProxy userDaoProxy = new UserDaoProxy(iUserDao);
        userDaoProxy.save();
    }

    /**
     * 结论：
     * 1. AOP底层动态代理实现；
     */
}
