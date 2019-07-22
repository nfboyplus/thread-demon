package com.design.builder.impl;

import com.design.builder.Person;
import com.design.builder.PersonBuilder;

/**
 * 实现建造者接口：针对不同的商业逻辑，具体化复杂对象的各部分的创建。在建造过程完成后，提供产品的实例
 */
public class ManBuilder implements PersonBuilder {

    private Person person;

    public ManBuilder(){
        //创建一个Person实例,用于调用set方法
        person = new Person();
    }

    @Override
    public void builderHead() {
        person.setHead("---- 建造者头部部分 ----");
    }

    @Override
    public void builderBody() {
        person.setBody("---- 建造者身体部分 ----");
    }

    @Override
    public void builderFoot() {
        person.setFoot("---- 建造者四肢部分 -----");
    }

    @Override
    public Person BuilderPerson() {
        return person;
    }
}
