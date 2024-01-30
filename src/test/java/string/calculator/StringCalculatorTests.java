package string.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    @DisplayName("test add multiple numbers")
    void testAddMultipleNumbers() {
        assertEquals(12, StringCalculator.add("4,6,2"));
        assertEquals(10, StringCalculator.add("6,2,1,1"));
        assertEquals(19, StringCalculator.add("5,4,3,2,5"));
    }

    @Test
    @DisplayName("test add numbers with new line")
    void testAddNumbersWithNewLine() {
        assertEquals(10, StringCalculator.add("1\n7,2"));
        assertEquals(20, StringCalculator.add("1\n7,2\n5,5"));
    }

    @Test
    @DisplayName("test add numbers with custom delimiter")
    void testAddNumbersWithCustomDelimiter() {
        assertEquals(3, StringCalculator.add("//;\n1;2"));
        assertEquals(6, StringCalculator.add("//|\n1|2|3"));
        assertEquals(10, StringCalculator.add("//*\n1*2*3*4"));
    }

    @Test
    @DisplayName("test throw exception with negative number")
    void testThrowExceptionWithNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StringCalculator.add("1,-2");
        });
        assertEquals("negatives are not allowed: [-2]", exception.getMessage());
    }

    @Test
    @DisplayName("test throw exception with multiple negative numbers")
    void testThrowExceptionWithMultipleNegativeNumbers() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StringCalculator.add("-1,2,-3");
        });
        assertEquals("negatives are not allowed: [-1, -3]", exception.getMessage());
    }

    @Test
    @DisplayName("test adding number greater or equal to 1000 should be ignored")
    void testAddingNumberGreaterOrEqualTo1000ShouldBeIgnored() {
        assertEquals(2, StringCalculator.add("2,1001"));
        assertEquals(8, StringCalculator.add("5,1001,1000,3"));
    }

    @Test
    @DisplayName("test add with long delimiter")
    void testAddWithLongDelimiter() {
        assertEquals(6, StringCalculator.add("//[****]\n1****2****3"));
    }

    @Test
    @DisplayName("test add with multiple delimiters of different lengths")
    void testAddWithMultipleDelimitersOfDifferentLengths() {
        assertEquals(10, StringCalculator.add("//[***][#][%]\n1***2#3%4"));
    }
}