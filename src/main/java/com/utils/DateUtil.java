package com.utils;


import com.exception.SystemServiceException;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期处理工具类
 */
public class DateUtil {

    private static final int MINUTE_VALUE = 5;

    public static Date getDate(String s) {
        return getDate(s, null);
    }

    public static Date getJustDate(String s) {
        return getDate(s, DateFormat.Y_M_D);
    }


    public static Date getDate(long date) {
        return getDate(date, null);
    }

    public static Date getJustDate(long date) {
        return getDate(date, DateFormat.Y_M_D);
    }

    public static Date getDate(long date, String format) {
        if (StringUtils.isEmpty(format)) {
            format = DateFormat.SETTLE_PATTERN;
        }

        return getDate(formatDate(new Date(date), format), format);
    }

    public static Date getDate(String s, String format) {
        Date date;
        try {
            if (StringUtils.isEmpty(format)) {
                format = DateFormat.SETTLE_PATTERN;
            }

            date = new SimpleDateFormat(format).parse(s);
        } catch (Exception e) {
            date = new Date(0L);
        }

        return date;
    }

    public static String formatDate(long date, String format) {
        return formatDate(new Date(date), format);
    }

    public static String formatDate(long date) {
        return formatDate(new Date(date), null);
    }

    public static String formatJustDate(long date) {
        return formatDate(new Date(date), DateFormat.Y_M_D);
    }
    public static String formatJustDate() {
        return formatDate(new Date(), DateFormat.Y_M_D);
    }
    public static String formatJustDate(String format) {
        return formatDate(new Date(), format);
    }

    public static String formatJustDate(Date date) {
          return new SimpleDateFormat(DateFormat.Y_M_D).format(date);
    }

    public static String formatDate(Date date, String format) {
        if (StringUtils.isEmpty(format)) {
            format = DateFormat.SETTLE_PATTERN;
        }
        if (null == date){
            return "";
        }
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 获取days(+表示后，-表示前)天的时间
     * @param days +后，-前
     * @return
     */
    public static Date beforeDate(int days){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, days);
        return cal.getTime();
    }
    public static Date beforeDate(Date date ,int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, days);
        return cal.getTime();
    }

    public static Date beforeMonth(Date date ,int months){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months);
        return cal.getTime();
    }

    public static String getTimeDesc(Date createTime) {
        Date now = new Date();
        long diff = now.getTime() - createTime.getTime();
        if (diff <= MINUTE_VALUE * DateFormat.MINUTE) {
            return "刚刚";
        }
        // 一小时以内
        if (diff <= DateFormat.HOUR) {
            return diff / DateFormat.MINUTE + "分钟前";
        }
        // 一天以内
        if (diff <= DateFormat.DAY) {
            return diff / DateFormat.HOUR + "小时前";
        }
        // 昨天
        if (diff <= 2 * DateFormat.DAY) {
            return "昨天" + DateUtil.formatDate(createTime, DateFormat.HOUR_OF_MINUTE);
        }
        // 前天
        if (diff <= 3 * DateFormat.DAY) {
            return "前天" + DateUtil.formatDate(createTime, DateFormat.HOUR_OF_MINUTE);
        }
        // 格式化yyyy-MM-dd HH:mm
        return DateUtil.formatDate(createTime, DateFormat.YMDHM);
    }

    public static Date getDayOfEndTime(String date){
        return getDayOfEndTime(getDate(date,DateFormat.Y_M_D));
        /*Calendar todayEnd = Calendar.getInstance();
        todayEnd.setTime(getDate(date,DateFormat.Y_M_D));
        todayEnd.set(Calendar.HOUR,23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);*/
        //return todayEnd.getTime();
    }
    public static String getDayOfEndTimeStr(String date){
        Date endDateTime = getDayOfEndTime(date);
        return formatDate(endDateTime,DateFormat.SETTLE_PATTERN);

    }

    public static Date getDayOfStarTime(Date date){
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.setTime(date);
        todayEnd.set(Calendar.HOUR_OF_DAY,0);
        todayEnd.set(Calendar.MINUTE, 0);
        todayEnd.set(Calendar.SECOND, 0);
        todayEnd.set(Calendar.MILLISECOND, 0);
        return todayEnd.getTime();
    }
    public static Date getDayOfEndTime(Date date){
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.setTime(date);
        todayEnd.set(Calendar.HOUR_OF_DAY,23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    public static Date getDateByTime(Time time) {
        Calendar date = Calendar.getInstance();
        date.setTime(time);
        return date.getTime();
    }

    //计算中点时刻
    public static Time getHalfPointTime(Date startDate, Date endDate) {
        Long cha = (endDate.getTime() - startDate.getTime()) / 2 + startDate.getTime();
        Date datePoint = new Date(cha);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datePoint);
        //不足一分钟,补足一分钟
        if (calendar.get(Calendar.SECOND) != 0) {
            calendar.add(Calendar.MINUTE, 1);
            calendar.set(Calendar.SECOND, 0);
        }
        Time time = new Time(calendar.getTime().getTime());
        return time;
    }


    public static final int daysBetween(Date early, Date late) {
        Calendar calst = Calendar.getInstance();
        Calendar caled = Calendar.getInstance();
        calst.setTime(early);
        caled.setTime(late);
        //设置时间为0时
        calst.set(Calendar.HOUR_OF_DAY, 0);
        calst.set(Calendar.MINUTE, 0);
        calst.set(Calendar.SECOND, 0);
        calst.set(Calendar.MILLISECOND, 0);
        caled.set(Calendar.HOUR_OF_DAY, 0);
        caled.set(Calendar.MINUTE, 0);
        caled.set(Calendar.SECOND, 0);
        caled.set(Calendar.MILLISECOND, 0);
        long caledTime = caled.getTime().getTime()/1000;
        long calstTime = calst.getTime().getTime()/1000;
        BigDecimal decimalDay = new BigDecimal(caledTime-calstTime).divide(new BigDecimal(3600),BigDecimal.ROUND_HALF_UP).divide(new BigDecimal(24),BigDecimal.ROUND_HALF_UP).setScale(8);
        //得到两个日期相差的天数
        int days = (int) Math.ceil(decimalDay.doubleValue());
        return days;
    }

    public static Date  getCycleDate(){
        Calendar nowCalendar = Calendar.getInstance();
        int day = nowCalendar.get(Calendar.DAY_OF_MONTH);
        if(day == 5||day == 4|| day == 3){
            Calendar calendar25 = Calendar.getInstance();
            calendar25.add(Calendar.MONTH,-1);
            calendar25.set(Calendar.DAY_OF_MONTH,25);

            calendar25.set(Calendar.HOUR_OF_DAY, 0);
            calendar25.set(Calendar.MINUTE, 0);
            calendar25.set(Calendar.SECOND, 0);
            calendar25.set(Calendar.MILLISECOND, 0);
            //最后更新时间，在上月25日之后
            return calendar25.getTime();
        }else if(day == 15||day == 14 || day == 13){
            Calendar calendar5 = Calendar.getInstance();
            //本月5日 00：00：00
            calendar5.set(Calendar.DAY_OF_MONTH,5);
            calendar5.set(Calendar.HOUR_OF_DAY, 0);
            calendar5.set(Calendar.MINUTE, 0);
            calendar5.set(Calendar.SECOND, 0);
            calendar5.set(Calendar.MILLISECOND, 0);
            //最后更新时间，在本月5日之后
            return calendar5.getTime();
        }else{
            Calendar calendar15 = Calendar.getInstance();
            //本月15日 00：00：00
            calendar15.set(Calendar.DAY_OF_MONTH,15);
            calendar15.set(Calendar.HOUR_OF_DAY, 0);
            calendar15.set(Calendar.MINUTE, 0);
            calendar15.set(Calendar.SECOND, 0);
            calendar15.set(Calendar.MILLISECOND, 0);
            //最后更新时间，在本月5日之后
            return calendar15.getTime();
        }
    }


    public static  boolean cycleDay(Date lastDay) {
        Calendar nowCalendar = Calendar.getInstance();
        int day = nowCalendar.get(Calendar.DAY_OF_MONTH);
        //int month = nowCalendar.get(Calendar.MONTH);
        //5号, 25日00：00：00-5日00：00：00
        if(day == 5||day == 4 || day == 3){
            Calendar calendar25 = Calendar.getInstance();
            //上个月 25号
            calendar25.add(Calendar.MONTH,-1);
            calendar25.set(Calendar.DAY_OF_MONTH,25);

            calendar25.set(Calendar.HOUR_OF_DAY, 0);
            calendar25.set(Calendar.MINUTE, 0);
            calendar25.set(Calendar.SECOND, 0);
            calendar25.set(Calendar.MILLISECOND, 0);

            //最后更新时间，在上月25日之后
            if(lastDay.compareTo(calendar25.getTime())>=0){
                return true;
            }
        }else if(day == 15||day == 14 || day == 13){
            Calendar calendar5 = Calendar.getInstance();
            //本月5日 00：00：00
            calendar5.set(Calendar.DAY_OF_MONTH,5);
            calendar5.set(Calendar.HOUR_OF_DAY, 0);
            calendar5.set(Calendar.MINUTE, 0);
            calendar5.set(Calendar.SECOND, 0);
            calendar5.set(Calendar.MILLISECOND, 0);
            //最后更新时间，在本月5日之后
            if(lastDay.compareTo(calendar5.getTime())>=0){
                return true;
            }
        }else{
            Calendar calendar15 = Calendar.getInstance();
            //本月15日 00：00：00
            calendar15.set(Calendar.DAY_OF_MONTH,15);
            calendar15.set(Calendar.HOUR_OF_DAY, 0);
            calendar15.set(Calendar.MINUTE, 0);
            calendar15.set(Calendar.SECOND, 0);
            calendar15.set(Calendar.MILLISECOND, 0);
            //最后更新时间，在本月5日之后
            if(lastDay.compareTo(calendar15.getTime())>=0){
                return true;
            }
        }
       return false;
    }

    public static String getWeekDayByDateStr(String dateStr) {
        try {
            return getWeekDayByDate(new SimpleDateFormat("yyyy-MM-dd").parse(dateStr));
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取年龄
     * @param birthDay
     * @return
     */
    public static int getAgeByBirth(Date birthDay) {
        int age = 0;
        if (birthDay == null) {
            return age;
        }
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) { //出生日期晚于当前时间，无法计算
            throw new SystemServiceException(ResultCode.DEFINED_ERROR, "出生日期不可大于当前日期");
        }
        int yearNow = cal.get(Calendar.YEAR);  //当前年份
        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        age = yearNow - yearBirth;   //计算整岁数
        return age;
    }

    public static String getWeekDayByDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(Calendar.DAY_OF_WEEK);
        switch (i){
            case 1:
                return "星期日";
            case 2:
                return "星期一";
            case 3:
                return "星期二";
            case 4:
                return "星期三";
            case 5:
                return "星期四";
            case 6:
                return "星期五";
            case 7:
                return "星期六";
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        /*Calendar cal = Calendar.getInstance();
        cal.add(Calendar.WEEK_OF_YEAR, -1);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        String s = DateUtil.formatDate(cal.getTime(), "yyyy-MM-dd");
        System.out.println(s);
        cal.add(Calendar.DATE, 6);
        String s2 = DateUtil.formatDate(cal.getTime(), "yyyy-MM-dd");
        System.out.println(s2);*/
        /*String str = getDayOfEndTimeStr("2018-05-23");
        System.out.println(str);*/
        System.out.println(beforeDate(new Date(), 1));


    }
}
