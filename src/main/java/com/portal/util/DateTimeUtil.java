package com.portal.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * @Author: tina.huanght
 * @Date: 08/02/25 17:59
 */
public class DateTimeUtil {
//     joda-time

    private static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";

     public static Date strToDate(String dateTimeStr, String formatStr){
         DateTimeFormatter formatter = DateTimeFormat.forPattern(formatStr);
         DateTime dateTime = formatter.parseDateTime(dateTimeStr);
         return dateTime.toDate();
     }

     public static String DateToStr(Date date, String formatStr){
         if(date == null){
             return "";
         }
         DateTime dateTime = new DateTime(date);
         return dateTime.toString(formatStr);
     }

    public static Date strToDate(String dateTimeStr){
        DateTimeFormatter formatter = DateTimeFormat.forPattern(STANDARD_FORMAT);
        DateTime dateTime = formatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    public static String DateToStr(Date date){
        if(date == null){
            return "";
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(STANDARD_FORMAT);
    }


    public static void main(String[] args) {
        System.out.println(DateTimeUtil.DateToStr(new Date(),"yyyy-MM-dd HH:mm:ss"));
        System.out.println(DateTimeUtil.strToDate("2018-08-02 17:59:00","yyyy-MM-dd HH:mm:ss"));
    }
}
