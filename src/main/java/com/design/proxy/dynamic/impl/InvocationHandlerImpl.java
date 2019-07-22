package com.design.proxy.dynamic.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * created on 2019/7/18 13:55
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class InvocationHandlerImpl implements InvocationHandler {

    /**
     * 这其实业务实现类对象，用来调用具体的业务方法
     */
    private Object target;

    /**
     * 通过构造函数传入目标对象
     */
    public InvocationHandlerImpl(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("调用开始处理");
        result = method.invoke(target, args);
        System.out.println("调用结束处理");
        return result;
    }
}
