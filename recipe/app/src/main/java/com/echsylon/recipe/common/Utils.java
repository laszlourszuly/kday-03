package com.echsylon.recipe.common;

import java.io.Closeable;
import java.io.IOException;

public class Utils {

    public static void closeSilently(Closeable closeable) {
        try {
            closeable.close();
        } catch (NullPointerException | IOException e) {
            // Consume the exception silently.
        }
    }

    public static float getNative(Float value, float fallback) {
        return value != null ? value : fallback;
    }

    public static int getNative(Integer value, int fallback) {
        return value != null ? value : fallback;
    }

    public static long getNative(Long value, long fallback) {
        return value != null ? value : fallback;
    }

    public static <T> T getNonNull(T object, T fallback) {
        return object != null ? object : fallback;
    }

    public static boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    public static boolean notEmpty(String string) {
        return !isEmpty(string);
    }

    public static boolean notEmpty(Object[] array) {
        return !isEmpty(array);
    }


}
