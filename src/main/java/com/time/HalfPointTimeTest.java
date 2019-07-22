package com.time;

import com.utils.DateUtil;

import java.sql.Time;
import java.util.Date;

/**
 * created on 2019/7/17 18:53
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class HalfPointTimeTest {

    public static void main(String[] args){
        Time startTime  = Time.valueOf("09:02:04");
        Time endTime = Time.valueOf("18:00:00");
        Date date = DateUtil.getHalfPointTime(startTime,endTime);
        System.out.println(date);
    }

    /**
     * // 获取年
     *  int year = calendar.get(Calendar.YEAR);
     * // 获取月，这里需要需要月份的范围为0~11，因此获取月份的时候需要+1才是当前月份值
     *  int month = calendar.get(Calendar.MONTH) + 1;
     * // 获取日
     *  int day = calendar.get(Calendar.DAY_OF_MONTH);
     * // 获取时
     *  int hour = calendar.get(Calendar.HOUR);
     * // int hour = calendar.get(Calendar.HOUR_OF_DAY); // 24小时表示
     * // 获取分
     *  int minute = calendar.get(Calendar.MINUTE);
     * // 获取秒
     *  int second = calendar.get(Calendar.SECOND);
     *
     */

    /**
     * calendar.add(Calendar.HOUR_OF_DAY, 1);//小时上加1
     *
     * calendar.set(Calendar.MINUTE, 0);//分钟设为0
     * calendar.set(Calendar.SECOND, 0);//秒钟设为0
     */

    /**
     * //获得当前时间的前几天，几分钟，几秒 直接使用 calendar.add（）填写需要增加或者减少的属性 和值
     * calendar.add(Calendar.DATE,-1);
     * calendar.add(Calendar.MONDAY,-1);
     * calendar.add(Calendar.YEAR,-1);
     * calendar.add(Calendar.HOUR,-1);
     * calendar.add(Calendar.MINUTE,-1);
     * calendar.add(Calendar.SECOND,-1);
     * calendar.add(Calendar.MILLISECOND,-1);
     */
}
