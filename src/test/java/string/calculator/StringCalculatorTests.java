package string.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTests {
    @Test
    @DisplayName("test Add Empty String")
    void testAddEmptyString() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    @DisplayName("test add single number")
    void testAddSingleNumber() {
        assertEquals(5, StringCalculator.add("5"));
    }

    @Test
    @DisplayName("test add two numbers")
    void testAddTwoNumbers() {
        assertEquals(8, StringCalculator.add("3,5"));
    }
}