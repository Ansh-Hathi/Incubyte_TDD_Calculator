package com.example.Incubyte_TDD_Calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    @Test
    public void should_return_0_for_empty_string() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void should_return_number_for_single_number() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.add("1"));
        assertEquals(5, calculator.add("5"));
    }
    @Test
    public void should_return_sum_for_two_numbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("1,2"));
        assertEquals(10, calculator.add("4,6"));
    }

    @Test
    public void should_handle_multiple_numbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(15, calculator.add("1,2,3,4,5"));
        assertEquals(21, calculator.add("1,2,3,4,5,6"));
    }

    @Test
    public void should_handle_newline_delimiter() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1\n2,3"));
        assertEquals(10, calculator.add("1\n2\n3\n4"));
    }

    @Test
    public void should_handle_custom_delimiter() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("//;\n1;2"));
        assertEquals(10, calculator.add("//|\n1|2|3|4"));
    }

    @Test
    public void should_throw_exception_for_negative_numbers() {
        StringCalculator calculator = new StringCalculator();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-2,3");
        });
        assertEquals("Negative numbers not allowed: -2", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-2,-3");
        });
        assertEquals("Negative numbers not allowed: -2, -3", exception.getMessage());
    }

    @Test
    public void should_ignore_numbers_greater_than_1000() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(2, calculator.add("1001,2"));
        assertEquals(1000, calculator.add("1000"));
    }
    @Test
    public void should_handle_delimiters_of_any_length() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("//[***]\n1***2***3"));
        assertEquals(10, calculator.add("//[abc]\n1abc2abc3abc4"));
    }









}
