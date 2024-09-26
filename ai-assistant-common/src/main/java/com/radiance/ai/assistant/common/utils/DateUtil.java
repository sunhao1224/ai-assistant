package com.radiance.ai.assistant.common.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author zhangpf
 * @date 2023/1/3 11:50
 * @since 1.0.0
 */
public class DateUtil {

    public static final String YEAR_MONTH_DAY_PATTERN = "yyyyMMdd";

    public static final String YEAR_MONTH_DAY_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前年月日字符串
     *
     * @return 返回年月日字符串
     * @author zhangpf
     * @date 2023/1/3 11:53
     * @since 1.0.0
     */
    public static String getYearMonthDay() {
        return LocalDateTime.now(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern(YEAR_MONTH_DAY_PATTERN));
    }

    /**
     * 获取当前年-月-日和时间字符串
     *
     * @return 返回时间字符串
     * @author juncong.sh
     * @date 2024/1/31 21:04
     * @since 2.0.0
     */
    public static String getYearMonthDayTime() {
        return LocalDateTime.now(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern(YEAR_MONTH_DAY_TIME_PATTERN));
    }

    /**
     * 获取现在时间
     *
     * @return 返回当前时间 {@link LocalDateTime}
     * @author juncong.sh
     * @date 2024/2/2 14:12
     * @since 2.0.0
     */
    public static LocalDateTime getNow() {
        return LocalDateTime.now(ZoneId.systemDefault());
    }

    /**
     * 获取昨天年月日字符串
     *
     * @return 返回时间字符串
     * @author zpf01595328@alibaba-inc.com
     * @date 2024/9/14 14:21
     * @since 2.0.0
     */
    public static String getYesterdayYearMonthDay() {
        // 获取当前日期
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date beforeM = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(YEAR_MONTH_DAY_PATTERN);
        return sdf.format(beforeM);
    }

    /**
     * 获取前几天年月日字符串
     *
     * @param before 前几天
     * @return 年月日字符串
     * @author juncong.sh@alibaba-inc.com
     * @date 2024/9/20 17:41
     * @since 2.0.0
     */
    public static String getBeforeYearMonthDay(int before) {
        // 获取当前日期
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -before);
        Date beforeM = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(YEAR_MONTH_DAY_PATTERN);
        return sdf.format(beforeM);
    }

}
