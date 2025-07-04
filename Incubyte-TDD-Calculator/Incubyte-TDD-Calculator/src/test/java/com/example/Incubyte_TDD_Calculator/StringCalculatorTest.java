package com.example.Incubyte_TDD_Calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    @Test
    public void should_return_0_for_empty_string() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }

}
