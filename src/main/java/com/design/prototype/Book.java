package com.design.prototype;

import lombok.Data;

import java.util.ArrayList;

/**
 *
 */
@Data
public class Book implements Cloneable{

    /**
     * 标题
     */
    private String title;

    /**
     * 图片名列表
     */
    private ArrayList<String> image = new ArrayList<String>();

    public Book(){
        super();
    }

    /**
     * 重写拷贝方法
     */
    protected Book clone(){
        try{
            Book book = (Book) super.clone();
            book.image = (ArrayList<String>) this.image.clone();
            return book;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void addImage(String img) {
        this.image.add(img);
    }

    public void showBook(){
        System.out.println("---- 开始 ----");
        System.out.println("---- title:" + title + " ----");
        for (String img : image){
            System.out.println("---- image name:" + img + " ----");
        }
        System.out.println("---- 结束 ----");
    }

}
