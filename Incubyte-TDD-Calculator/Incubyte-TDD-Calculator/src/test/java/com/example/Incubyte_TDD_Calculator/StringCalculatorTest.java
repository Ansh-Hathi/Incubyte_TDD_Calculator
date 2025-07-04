package com.example.Incubyte_TDD_Calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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



}
