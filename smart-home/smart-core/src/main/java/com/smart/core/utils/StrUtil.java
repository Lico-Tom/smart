package com.smart.core.utils;

import java.util.Arrays;

/**
 * @author Lico-Tom
 * 2024/6/18 23:41
 * @version V1.0
 */
public class StrUtil {

    public static String arrToStr(Object[] arr) {
        return Arrays.toString(arr)
                .replace("[", "")
                .replace("]", "")
                .replaceAll(" ", "")
                .replaceAll(",", "_");
    }
}
