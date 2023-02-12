package com.dj.domain.util;

public class ArrayUtil {

    public static boolean isNullOrEmpty(int[] array) {
        return !isNotNullOrEmpty(array);
    }

    public static boolean isNullOrEmpty(long[] array) {
        return !isNotNullOrEmpty(array);
    }

    public static<T> boolean isNullOrEmpty(T[] array) {
        return !isNotNullOrEmpty(array);
    }

    /**
     *	检测一个数组不是null 或者 空的
     * @param array
     * @return
     */
    public static boolean isNotNullOrEmpty(int []array){
        return array != null && array.length > 0;
    }

    /**
     *	检测一个数组不是null 或者 空的
     * @return
     */
    public static boolean isNotNullOrEmpty(long[]array){
        return array != null && array.length > 0;
    }

    /**
     *	检测一个数组不是null 或者 空的
     * @param array
     * @param <T>
     * @return
     */
    public static <T> boolean isNotNullOrEmpty(T[] array) {
        return array != null && array.length > 0 ;
    }
}
