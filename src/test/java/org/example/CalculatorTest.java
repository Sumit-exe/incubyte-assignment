package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {


    @Test
    public void shouldReturnZeroOnEmptyString(){
        Assertions.assertEquals(0 ,  Calculator.add(""));
    }
}
