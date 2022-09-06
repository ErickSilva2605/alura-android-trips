package br.com.alura.aluratrips.util;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateUtil {
    public static final String KEY_LANGUAGE_PT = "pt";
    public static final String KEY_COUNTRY_BR = "br";
    public static final String KEY_DD_MM = "dd/MM";
    public static final String KEY_FROM = " de ";
    public static final String KEY_LESS = " - ";

    @NonNull
    public static String formatToPeriodText(int days) {
        Calendar initDate = Calendar.getInstance();
        Calendar finalDate = Calendar.getInstance();
        finalDate.add(Calendar.DATE, days);
        SimpleDateFormat dateFormat = new SimpleDateFormat(KEY_DD_MM, new Locale(KEY_LANGUAGE_PT, KEY_COUNTRY_BR));
        String initDateFormatted = dateFormat.format(initDate.getTime());
        String finalDateFormatted = dateFormat.format(finalDate.getTime());
        return initDateFormatted + KEY_LESS + finalDateFormatted + KEY_FROM + finalDate.get(Calendar.YEAR);
    }
}
