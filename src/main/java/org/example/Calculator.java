package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Calculator {

    private Calculator(){}

    public static int add(String value) {
        if (value.isEmpty()) return 0;
        String delimiter = getDelimiter(value);
        String numbers = getNumStartIndex(value);
        String[] nums = numbers.split(delimiter);
        return sumNums(nums);
    }

    private static String getDelimiter(String value) {
        String defaultDelimiter = "[,\n]";
        if (!value.startsWith("//")) return defaultDelimiter;

        int end = value.indexOf("\n");
        String delimiterPart = value.substring(2, end);

        String custom;
        if (delimiterPart.startsWith("[") && delimiterPart.endsWith("]")) {
            custom = delimiterPart.substring(1, delimiterPart.length() - 1);
        } else {
            custom = delimiterPart;
        }
        custom = Pattern.quote(custom);
        return defaultDelimiter + "|" + custom;
    }

    private static String getNumStartIndex(String value) {
        if (!value.startsWith("//")) return value;
        int end = value.indexOf("\n");
        return value.substring(end + 1);
    }

    private static int sumNums(String[] nums) {
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String num : nums) {
            if (!num.isEmpty()) {
                int n = Integer.parseInt(num);
                if (n < 0) negatives.add(n);
                if (n < 1000) sum += n;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + negatives);
        }

        return sum;
    }
}
