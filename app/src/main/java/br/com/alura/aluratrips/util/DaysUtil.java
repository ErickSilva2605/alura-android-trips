package br.com.alura.aluratrips.util;

import androidx.annotation.NonNull;

public class DaysUtil {

    public static final String KEY_DAYS = " dias";
    public static final String KEY_DAY = " dia";

    @NonNull
    public static String formatToText(int days) {
        return days > 1 ? days + KEY_DAYS : days + KEY_DAY;
    }
}
