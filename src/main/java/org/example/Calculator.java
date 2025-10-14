package org.example;

import java.util.regex.Pattern;

public class Calculator {

    private Calculator(){

    }

    public static int add(String value) {
        int sum = 0;
        if (value.isEmpty()) return sum;

        String delimiter = "[,\n]";

        if (value.startsWith("//")) {

            int delimiterEndIndex = value.indexOf("\n");
            String customDelimiter = value.substring(2, delimiterEndIndex);
            customDelimiter = Pattern.quote(customDelimiter);

            delimiter = delimiter + "|" + customDelimiter;

            value = value.substring(delimiterEndIndex + 1);
        }

        String[] nums = value.split(delimiter);
        for (String num : nums) {
            num = num.trim();
            if (!num.isEmpty()) {
                sum += Integer.parseInt(num);
            }
        }

        return sum;
    }


}
