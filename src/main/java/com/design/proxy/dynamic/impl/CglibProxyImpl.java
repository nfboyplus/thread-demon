package com.design.proxy.dynamic.impl;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * created on 2019/7/19 9:54
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class CglibProxyImpl implements MethodInterceptor {

    private Object targetObject;

    /**
     * 这里的目标类型为Object，则可以接受任意一种参数作为被代理类，实现了动态代理
     */
    public Object getInstance(Object object) {
        // 设置需要创建子类的类
        this.targetObject = object;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("---- 开启事务 ----");
        Object result = methodProxy.invoke(targetObject, objects);
        System.out.println("---- 关闭事务 ----");
        // 返回代理对象
        return result;
    }
}
