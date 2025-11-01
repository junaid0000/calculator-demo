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
    @Test
    public void testSubtractTwoNumbers() {
        Calculator calc = new Calculator();
        int result = calc.subtract(10, 4);
        assertEquals(6, result);
    }

    @Test
    public void testMultiplyTwoNumbers() {
        Calculator calc = new Calculator();
        int result = calc.multiply(3, 4);
        assertEquals(12, result);
    }

    @Test
    public void testDivideTwoNumbers() {
        Calculator calc = new Calculator();
        double result = calc.divide(10, 2);
        assertEquals(5.0, result, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        Calculator calc = new Calculator();
        calc.divide(10, 0);
    }
    
}
