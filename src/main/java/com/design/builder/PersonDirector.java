package com.design.builder;

/**
 * 调用具体建造者来创建复杂对象的各个部分
 * 这个接口规定要实现复杂对象的哪些部分的创建，并不涉及具体的对象部件的创建
 */
public class PersonDirector {

    public Person constructPerson(PersonBuilder personBuilder) {
        personBuilder.builderHead();
        personBuilder.builderBody();
        personBuilder.builderFoot();
        //构建，组装
        return personBuilder.BuilderPerson();
    }

}
