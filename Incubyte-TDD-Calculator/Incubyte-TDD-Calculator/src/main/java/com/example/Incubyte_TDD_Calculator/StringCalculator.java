package com.example.Incubyte_TDD_Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringCalculator {

    private boolean isValidNumber(int number) {
        return number >= 0 && number <= 1000;
    }

    private void validateNoNegatives(List<String> parts) {
        List<String> negatives = new ArrayList<>();
        for (String part : parts) {
            int num = Integer.parseInt(part);
            if (num < 0) {
                negatives.add(part);
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " +
                    String.join(", ", negatives));
        }
    }
    
    //void delimiter_handling(String numbers)
    boolean checkNumber(int number){
        return number<=500;
    }
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        List<String> parts = getParts(numbers);
        validateNoNegatives(parts);
        Stream<Integer> integerStream = parts.stream().map(Integer::parseInt);
        List<Integer> validNumbers= integerStream.filter(this::checkNumber).toList();
        int sum = 0;
        for (int num : validNumbers) {

            sum += num;
        }
        return sum;
    }

    private static List<String> getParts(String numbers) {
        String delimiter = "[,\n]";

        if (numbers.startsWith("//")) {
            int delimiterEnd = numbers.indexOf('\n');
            String delimiterPart = numbers.substring(2, delimiterEnd);
            numbers = numbers.substring(delimiterEnd + 1);

            // Handle multiple delimiters in bracket notation (any length)
            if (delimiterPart.startsWith("[") && delimiterPart.endsWith("]")) {
                // Extract all delimiters wrapped in brackets
                Pattern pattern = Pattern.compile("\\[([^\\]]+)\\]");
                Matcher matcher = pattern.matcher(delimiterPart);

                List<String> delimiters = new ArrayList<>();
                while (matcher.find()) {
                    String del = matcher.group(1);
                    // Escape special regex characters for any length delimiter
                    del = del.replaceAll("([\\[\\]\\\\*+?.()|^$])", "\\\\$1");
                    delimiters.add(del);
                }

                if (!delimiters.isEmpty()) {
                    delimiter = String.join("|", delimiters);
                }
            } else {
                delimiter = delimiterPart.replaceAll("([\\[\\]\\\\*+?.()|^$])", "\\\\$1");
            }
        }

        String[] parts = numbers.split(delimiter);
        return Arrays.asList(parts);
    }


}
