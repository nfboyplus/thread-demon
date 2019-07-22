package com.time;


import com.utils.DateUtil;

import java.sql.Time;
import java.util.Date;

/**
 * created on 2019/7/16 10:43
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class CompareTimeTest {

    public static void main(String[] args){
        //上下班是否隔天标示
        boolean nextFlag = false;
         Time a = new Time(9,0,0);
         Time b = new Time(9,0,0);
        //上班时间
        Date onDutyDate = DateUtil.getDateByTime(a);
        //下班时间
        Date offDutyDate = DateUtil.getDateByTime(b);
         int num = onDutyDate.compareTo(offDutyDate);
        // 3 下班时间 >=上班时间  下班时间取当天,否则取下一天
        if (onDutyDate.compareTo(offDutyDate) < 0) {
            offDutyDate = DateUtil.beforeDate(offDutyDate, 1);
            nextFlag = true;
        }
         System.out.println(num);
    }
}
