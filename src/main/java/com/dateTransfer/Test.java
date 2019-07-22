package com.dateTransfer;

/**
 * created on 2019/7/12 13:16
 *
 * @author nfboy_liusong@163.com
 * @version 1.0.0
 */
public class Test {

    public static void main(String[] args){
        String lunarDate = "20090505";
        int lunarYear = Integer.parseInt(lunarDate.substring(0, 4));
        int lunarMonth = Integer.parseInt(lunarDate.substring(4, 6));
        int lunarDay = Integer.parseInt(lunarDate.substring(6, 8));
        try {
            //农历转公历：转的是大的月份
            int[] newDate =  DateTransferTest.lunarToSolar(lunarYear, lunarMonth,lunarDay,true);
            //公历转农历
//            String newDate = CalendarUtil.solarToLunar(date);
            System.out.println("农历转换成公历：" + newDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
