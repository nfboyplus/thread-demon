package com.design.proxy.dynamic;


import com.design.proxy.dynamic.impl.IUserDaoImpl;
import com.design.proxy.dynamic.impl.InvocationHandlerImpl;

import java.lang.reflect.Proxy;

/**
 * JDK 动态代理
 */
public class JDKDynamicProxyTest {

    public static void main(String[] args) {
        IUserDao iUserDao = new IUserDaoImpl();
        InvocationHandlerImpl invocationHandlerImpl = new InvocationHandlerImpl(iUserDao);
        //获取类加载器
        ClassLoader classLoader = iUserDao.getClass().getClassLoader();
        //获取当前实现的接口，只能对实现了接口的类生成代理
        Class<?>[] interfaces = iUserDao.getClass().getInterfaces();
        //调用动态代理实例
        IUserDao userDao = (IUserDao) Proxy.newProxyInstance(classLoader, interfaces, invocationHandlerImpl);
        userDao.save();
    }
}
