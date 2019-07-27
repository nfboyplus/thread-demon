package com.time;

import com.utils.DateFormat;
import com.utils.DateUtil;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

/**
 * 将一个日期的时和分替换
 */
public class CalendarTest {

    public static void main(String[] args){
        //Mon Jul 01 10:40:34 CST 2019
        String time = "20190701104034";
        Date newTime = DateUtil.getDate(time, DateFormat.FULL_PATTERN);
        //
        Date date = new Date();
        String newDate = DateUtil.formatDate(date, DateFormat.FULL_PATTERN);
        Time a = new Time(9,0,0);
        //
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newTime);
        int newHour = calendar.get(Calendar.HOUR_OF_DAY);
        int newMin = calendar.get(Calendar.MINUTE);
        //
        calendar.set(Calendar.MINUTE,a.getSeconds());
        calendar.set(Calendar.HOUR,a.getHours());
        System.out.println(calendar.getTime());
        System.out.println(newTime);
        System.out.println(a);
    }


}
