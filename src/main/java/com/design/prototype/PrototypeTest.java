package com.design.prototype;

/**
 * 原型模式
 */
public class PrototypeTest {

    public static void main(String[] args) {
        Book book1 = new Book();
        book1.setTitle("西游记");
        book1.addImage("图片(西游记)");
        book1.showBook();
        //以原型方式拷貝一份
        Book book2 = book1.clone();
        book2.showBook();
        book2.setTitle("红楼梦");
        book2.addImage("图片(红楼梦)");
        book2.showBook();
        //再次还原打印书本
        book1.showBook();
    }

    /**
     * 结果：
     * ---- 开始 ----
     * ---- title:西游记 ----
     * ---- image name:图片(西游记) ----
     * ---- 结束 ----
     * ---- 开始 ----
     * ---- title:西游记 ----
     * ---- image name:图片(西游记) ----
     * ---- 结束 ----
     * ---- 开始 ----
     * ---- title:红楼梦 ----
     * ---- image name:图片(西游记) ----
     * ---- image name:图片(红楼梦) ----
     * ---- 结束 ----
     * ---- 开始 ----
     * ---- title:西游记 ----
     * ---- image name:图片(西游记) ----
     * ---- 结束 ----
     */

}
