package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Calculator {

    private Calculator() {}

    public static int add(String input) {
        if (input.isEmpty()) return 0;

        String delimiterRegex = extractDelimiters(input);
        String numbersPart = stripDelimiterLine(input);
        String[] numbers = numbersPart.split(delimiterRegex);

        if(delimiterRegex.contains("*")) return calculateproduct(numbers);
        return calculateSum(numbers);
    }

    private static String extractDelimiters(String input) {
        String defaultDelimiters = "[,\n]";
        if (!input.startsWith("//")) return defaultDelimiters;

        int newlineIndex = input.indexOf("\n");
        String delimiterPart = input.substring(2, newlineIndex);

        List<String> delimiters = new ArrayList<>();

        while (delimiterPart.contains("[")) {
            int start = delimiterPart.indexOf("[") + 1;
            int end = delimiterPart.indexOf("]");
            String delim = delimiterPart.substring(start, end);
            delimiters.add(Pattern.quote(delim));
            delimiterPart = delimiterPart.substring(end + 1);
        }

        if (delimiters.isEmpty()) {
            delimiters.add(Pattern.quote(delimiterPart));
        }

        return defaultDelimiters + "|" + String.join("|", delimiters);
    }

    private static String stripDelimiterLine(String input) {
        if (!input.startsWith("//")) return input;
        int newlineIndex = input.indexOf("\n");
        return input.substring(newlineIndex + 1);
    }

    private static int calculateproduct(String[] numbers){
        int product =1;
        List<Integer> negatives = new ArrayList<>();

        for (String num : numbers) {
            System.out.println(num);
            if (num.isEmpty()) continue;

            int n = Integer.parseInt(num.trim());
            if (n < 0) negatives.add(n);
            if (n < 1000){
                product *= n;

            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + negatives);
        }

        return product;
    }
    private static int calculateSum(String[] numbers) {
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String num : numbers) {
            if (num.isEmpty()) continue;

            int n = Integer.parseInt(num.trim());
            if (n < 0) negatives.add(n);
            if (n < 1000){
                sum += n;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + negatives);
        }

        return sum;
    }
}
