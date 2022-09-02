package br.com.alura.aluratrips.util;

import androidx.annotation.NonNull;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyUtil {

    public static final String KEY_LANGUAGE_PT = "pt";
    public static final String KEY_COUNTRY_BR = "br";
    public static final String KEY_CURRENCY_SYMBOL_BR = "R$";

    @NonNull
    public static String formatToPtBR(BigDecimal value) {
        NumberFormat formatCurrency = DecimalFormat.getCurrencyInstance(
                new Locale(KEY_LANGUAGE_PT, KEY_COUNTRY_BR));
        return formatCurrency
                .format(value)
                .replace(KEY_CURRENCY_SYMBOL_BR, KEY_CURRENCY_SYMBOL_BR + " ");
    }
}
