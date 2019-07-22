package com.design.builder;

/**
 * 建造者接口
 */
public interface PersonBuilder {

    void builderHead();

    void builderBody();

    void builderFoot();

    /**
     * 具体的建造者
     */
    Person BuilderPerson();

}
