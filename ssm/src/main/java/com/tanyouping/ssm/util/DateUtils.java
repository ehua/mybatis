package com.tanyouping.ssm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {


    public static Date start(Date date){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date end(Date date){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    public static String formatDateString(final Date date) {
        // 格式化日期
        SimpleDateFormat simpleDateFormat = null;
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // 返回格式化后的字符串
        return date == null ? "" : simpleDateFormat.format(date);
    }

    public static String formatDateString(final Date date, final String format) {

        // 格式化日期
        SimpleDateFormat simpleDateFormat = null;
        // 如果未设定格式，则赋给默认值。
        if (StringUtils.isEmpty(format)) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        } else {
            simpleDateFormat = new SimpleDateFormat(format);
        }
        // 返回格式化后的字符串
        return date == null ? "" : simpleDateFormat.format(date);
    }

    public static Date formatDate(final String dateString) {
        if (StringUtils.isEmpty(dateString) || StringUtils.isEmpty(dateString)) {
            return null;
        }
        Date objDate = null;
        // 格式化日期
        SimpleDateFormat objSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            objDate = objSimpleDateFormat.parse(dateString);
        }catch (ParseException e){
            e.printStackTrace();
        }
        // 返回生成的日期对象
        return objDate;
    }


    public static Date formatDate(final String dateString, String format) {
        if (StringUtils.isEmpty(dateString) || StringUtils.isEmpty(dateString)) {
            return null;
        }
        Date objDate = null;
        // 如果未设定格式，则赋给默认值。
        if (StringUtils.isEmpty(format)) {
            // 格式化日期
            SimpleDateFormat objSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {// 解析时间，如果抛出异常的话就设为空
                objDate = objSimpleDateFormat.parse(dateString);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }else{
            SimpleDateFormat objSimpleDateFormat = new SimpleDateFormat(format);
            try {// 解析时间，如果抛出异常的话就设为空
                objDate = objSimpleDateFormat.parse(dateString);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        // 返回生成的日期对象
        return objDate;
    }

}
