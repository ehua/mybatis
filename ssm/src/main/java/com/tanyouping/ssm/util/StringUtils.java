package com.tanyouping.ssm.util;

public class StringUtils {

    public static boolean isNotEmpty(String str) {
        return str != null && str.length() != 0;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
}
