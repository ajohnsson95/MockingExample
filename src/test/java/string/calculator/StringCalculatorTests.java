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
    public void testAddSingleNumber() {
        assertEquals(5, StringCalculator.add("5"));
    }
}