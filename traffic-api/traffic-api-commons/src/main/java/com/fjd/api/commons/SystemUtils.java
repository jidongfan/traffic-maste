package com.fjd.api.commons;


public class SystemUtils {
    public static boolean isNull(Object object){
        return null == object;
    }

    /**
     * 判断字符串是否是空字符串
     * @param str
     * @return true: 表示是空的
     */
    public static boolean isNullOrEmpty(String str){
        return null == str || str.trim().equals("");
    }

}
