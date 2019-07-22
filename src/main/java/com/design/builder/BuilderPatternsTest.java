package com.design.builder;

import com.design.builder.impl.ManBuilder;

/**
 * 建造者模式：在游戏中创建一个形象时，需要对每个部位进行创建
 */
public class BuilderPatternsTest {

    public static void main(String[] args){
        //要实现复杂对象的哪些部分的创建
        PersonDirector personDirector = new PersonDirector();
        //
        Person person = personDirector.constructPerson(new ManBuilder());
        System.out.println(person.getHead());
        System.out.println(person.getBody());
        System.out.println(person.getFoot());
    }

    /**
     * 结论：
     */
}
