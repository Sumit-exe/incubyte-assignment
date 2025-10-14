package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @Test
    void addShouldReturnZeroOnEmptyString(){
        assertEquals(0 ,  Calculator.add(""));
    }

    @Test
    void addShouldReturnNumberFromArgument(){
        assertEquals(1 ,  Calculator.add("1"));
    }

    @Test
    void addShouldReturnSumOfTwoNumbers(){
        assertEquals(3 ,  Calculator.add("1,2"));
    }

    @Test
    void addShouldReturnSumOfAllNumbers(){
        assertEquals(6 ,  Calculator.add("1,2,3"));
    }


    @Test
    void addShouldReturnSumOfAllNumbersAndHandleNewLine(){
        assertEquals(6 ,  Calculator.add("1\n2,3"));
    }

    @Test
    void addShouldReturnSumOfAllNumbersWithCustomDelimiter(){
        assertEquals(6 ,  Calculator.add("//;\n1;2;3"));
    }

    @Test
    void addShouldThrowExceptionForSingleNegative() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Calculator.add("1,-2,3")
        );
        assertEquals("negatives not allowed: [-2]", exception.getMessage());
    }

    @Test
    void addShouldThrowExceptionForMultipleNegatives() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Calculator.add("-1,2,-5")
        );
        assertEquals("negatives not allowed: [-1, -5]", exception.getMessage());
    }

    @Test
    void addShouldReturnSumOfNumberAndSkipNumbersLargerThenThousand() {
        assertEquals(2 ,  Calculator.add("2,1000"));
    }

    @Test
    void addWithMultiCharDelimiter() {
        assertEquals(6, Calculator.add("//[***]\n1***2***3"));
    }
}
