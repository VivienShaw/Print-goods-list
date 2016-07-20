package com.vivien.utils;

import java.text.DecimalFormat;

/**
 * Created by vivie on 2016/7/20.
 */
public class Utils {
    public static String numberFormat(double num) {
        DecimalFormat df = new DecimalFormat( "0.00");
        return df.format(num);
    }
}
