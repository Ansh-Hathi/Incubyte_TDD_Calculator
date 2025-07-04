package com.example.Incubyte_TDD_Calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = "[,\n]";

        if (numbers.startsWith("//")) {
            int delimiterEnd = numbers.indexOf('\n');
            delimiter = numbers.substring(2, delimiterEnd);
            numbers = numbers.substring(delimiterEnd + 1);

            // Escape special regex characters
            delimiter = delimiter.replaceAll("([\\[\\]\\\\*+?.()|^$])", "\\\\$1");
        }

        String[] parts = numbers.split(delimiter);

        // Check for negative numbers
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

        int sum = 0;
        for (String part : parts) {
            sum += Integer.parseInt(part);
        }
        return sum;
    }






}
