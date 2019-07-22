package com.stringsub;

import com.utils.DateFormat;
import com.utils.DateUtil;

import java.util.Date;

/**
 * created on 2019/7/17 14:52
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class StringSubTest {

    public static void main(String[] args){

        String date = "0112255556,07-09,07-12,2011-07-13";
        String[] str = date.split(",");

        for (int i = 0; i < str.length; i++){
            String newDate = str[i].toString();
            Date aaa = DateUtil.getDate(newDate, DateFormat.MMdd);
            String bbb = DateUtil.formatDate(aaa,DateFormat.MMdd);
            System.out.println(bbb);
            if (!bbb.equals(newDate)){
                System.out.println("时间格式有误,请重新输入!");
            }
        }
    }


}
