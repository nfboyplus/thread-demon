package com.design.proxy.dynamic;

import com.design.proxy.dynamic.impl.CglibProxyImpl;
import com.design.proxy.dynamic.impl.IUserDaoImpl;

/**
 * CGLIB 动态代理
 */
public class CGLIBDynamicProxyTest {

    public static void main(String[] args){
        CglibProxyImpl cglibProxy = new CglibProxyImpl();
        // 是针对类实现代理
        IUserDao userDao = (IUserDao) cglibProxy.getInstance(new IUserDaoImpl());
        userDao.save();
    }


    /**
     * 结论：
     * 1. JDK 动态代理是利用反射机制生成一个实现代理接口的匿名类，在调用具体方法前调用InvokeHandler来处理；
     * 2. CGLIB 动态代理是利用asm开源包，对代理对象类的class文件加载进来，通过修改其字节码生成子类来处理；
     */

    /**
     * 区别：
     * 1. JDK 动态代理只能对实现了接口的类生成代理，而不能针对类；
     * 2. CGLIB 是针对类实现代理，主要是对指定的类生成一个子类，覆盖其中的方法；
     */
}
