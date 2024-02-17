package com.example.string;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    public void init() {
        stringCalculator = new StringCalculator();
    }

    @AfterEach
    public void destroy() {
        stringCalculator = null;
    }

    @Test
    public void testEmptyString() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void testAddOneNumber() {
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    public void testAddMultipleNumbers() {
        assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    public void testNewLine() {
        assertEquals(10, stringCalculator.add("1\n2,3"));
    }

    @Test
    public void testNegativeNumber() {
        try {
            stringCalculator.add("-1,2");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Negative number not allowed");
        }
        try {
            stringCalculator.add("1,-2,3,-5");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Negative number not allowed");
        }
    }

    @Test
    public void testOtherDelimiter() {
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }

}