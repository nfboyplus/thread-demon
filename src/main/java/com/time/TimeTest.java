package com.time;

import com.utils.DateFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * created on 2019/7/2 10:52
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class TimeTest {

    /**
     * JDK1.8 计算时间差
     * @param args
     */
    public static void main(String[] args){
        String date = "20190701000000";
        LocalDateTime entryDate = LocalDateTime.parse(date, DateTimeFormatter.ofPattern(DateFormat.FULL_PATTERN));
        //只能计算同月的天数、同年的月数，不能计算隔月的天数以及隔年的月数
        int days = Period.between(entryDate.toLocalDate(), LocalDateTime.now().toLocalDate()).getDays();
        LocalDate entryDate1 = LocalDate.parse(date, DateTimeFormatter.ofPattern(DateFormat.FULL_PATTERN));
        //end.toEpochDay() - start.toEpochDay() 计算隔月，隔年相差的天数
        Long daysNum = LocalDate.now().toEpochDay() - entryDate1.toEpochDay();
        if (daysNum <= 3){
            System.out.println("隔月相聚的天数：" + daysNum);
        }
        System.out.println(daysNum);

    }
}
