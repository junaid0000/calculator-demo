package com.demo;

import static org.junit.Assert.*;   // for assertEquals()
import org.junit.Test;              // for @Test annotation

public class CalculatorTest {

    @Test
    public void testAddTwoNumbers() {
        Calculator calc = new Calculator(); // create object
        int result = calc.add(2, 3);        // call method
        assertEquals(5, result);            // check expected result
    }
}
