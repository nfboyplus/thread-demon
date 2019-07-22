package com.utils;

/**
 * 日期格式化字符串
 */
public interface DateFormat {

    /**
     * 时间格式：HHmmss
     */
    String MMdd = "MM-dd";
    String TIME_PATTERN = "HHmmss";

    /**
     * 时间格式：yyyy/MM/ddHH:mm:ss
     */
    String TIMES_PATTERN = "yyyy/MM/ddHH:mm:ss";

    /**
     * 日期格式：yyyyMMdd
     */
    String DATE_PATTERN = "yyyyMMdd";
    /**
     * 日期格式：yyMMdd
     */
    String SHORT_DATE_PATTERN = "yyMMdd";

    /**
     * 日期时间格式：yyyyMMddHHmmss
     */
    String FULL_PATTERN = "yyyyMMddHHmmss";

    /**
     * 日期时间格式：yyyyMMddHHmmssSS
     */
    String FULL_PATTERNS = "yyyyMMddHHmmssSS";

    /**
     * 日期时间格式：yyMMddHHmmss
     */
    String PART_PATTERN = "yyMMddHHmmss";

    /**
     * 日期时间格式：yyyy.MM.dd HH:mm:ss
     */
    String SETTLE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 时间式：HHmm
     */
    String HOUR_OF_MINUTE = "HH:mm";

    /**
     * 时间式：YYYY_MM
     */
    String YYYY_MM = "YYYY_MM";

    /**
     * 日期时间格式：yyyyMMdd HH:mm:ss
     */
    String DATE_FULL_PATTERN = "yyyyMMdd HH:mm:ss";

    /**
     * 日期时间格式：yyyyMMddHHmm
     */
    String YEAR_OF_MINUTE = "yyyyMMddHHmm";
    /**
     * 日期时间格式：yyyy-MM-dd HH:mm
     */
    String YMDHM = "yyyy-MM-dd HH:mm";

    /**
     * 日期时间格式：yyyy-MM-dd
     */
    String Y_M_D = "yyyy-MM-dd";

    /**
     * 秒
     */
    int SECOND = 1000;
    /**
     * 分
     */
    int MINUTE = 60 * SECOND;
    /**
     * 时
     */
    int HOUR = 60 * MINUTE;
    /**
     * 天
     */
    int DAY = 24 * HOUR;
}