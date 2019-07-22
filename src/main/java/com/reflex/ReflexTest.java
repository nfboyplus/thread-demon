package com.reflex;

import com.reflex.entity.UserEntity;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * created on 2019/7/15 14:08
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class ReflexTest {

    /**
     * 反射机制应用场景：
     * 1.JDBC连接;
     * 2.SpringIOC底层使用反射机制 + DOM4J;
     * 3.框架Hibernate,Mybatis;
     */

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //1.初始化操作，无参构造函数
        /**UserEntity userEntity = new UserEntity();
        userEntity.setUserName("A:大闹天宫");
        System.out.println(userEntity.getUserName());**/
        //2.使用Java反射机制创建对象，类的完整路径
        Class<?> forName = Class.forName("com.reflex.entity.UserEntity");
        //3.使用反射机制创建对象
        /**UserEntity userEntity = (UserEntity) forName.newInstance();
        userEntity.setUserName("B:大闹天宫");
        System.out.println(userEntity.getUserName());
        //4.使用反射机制获取类的方法信息
        Method[] methods = forName.getMethods();
        for (Method method : methods){
            System.out.println(method.getName());
        }
        //5.获取类属性
        Field[] fields = forName.getDeclaredFields();
        for (Field field : fields){
            System.out.println(field.getName());
        }**/
        //6.构造器
        Constructor<?> constructor = forName.getDeclaredConstructor();
        //设置在使用构造器的时候不执行权限检查
        constructor.setAccessible(true);
        UserEntity userEntity1 = (UserEntity) constructor.newInstance();
        userEntity1.setUserName("C:大闹天宫");
        System.out.println(userEntity1.getUserName());
    }

    /**
     * 1.getDeclaredMethods []	获取该类的所有方法
     * 2.getReturnType()	获取该类的返回值
     * 3.getParameterTypes()	获取传入参数
     * 4.getDeclaredFields()	获取该类的所有字段
     * 5.setAccessible	允许访问私有成员
     */

}
