package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void addShouldReturnZeroOnEmptyString(){
        assertEquals(0 ,  Calculator.add(""));
    }

    @Test
    void addShouldReturnNumberFromArgument(){
        assertEquals(1 ,  Calculator.add("1"));
    }

}
