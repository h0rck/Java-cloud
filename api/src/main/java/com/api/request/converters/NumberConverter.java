package com.api.request.converters;

import com.api.exeception.UnsupportedMathOperation;

public class NumberConverter {


    public static Double convertToDouble(String strNumber) throws IllegalAccessException {
        if(strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperation("Please set a numeric value!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }


    public static boolean isNumeric(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) return  false;
        String number = strNumber.replace(",", ".");

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");

    }
}
