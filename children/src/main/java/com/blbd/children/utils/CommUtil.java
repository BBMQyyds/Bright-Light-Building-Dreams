package com.blbd.children.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author sq ♥ovo♥
 * @date 2023/11/8 - 21:19
 */
public class CommUtil {
    public static String getNowDateLongStr(String dateFormat) {
        // 获取当前日期和时间
        LocalDateTime now = LocalDateTime.now();

        // 创建一个日期格式化对象，使用传入的日期格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);

        // 格式化当前日期为字符串
        String formattedDate = now.format(formatter);

        return formattedDate;
    }
}
