package com.demo;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorGUITest {

    @Test
    public void testCalculatorGUICreation() {
        CalculatorGUI gui = new CalculatorGUI();
        assertNotNull("CalculatorGUI should be created", gui);
    }
    
    @Test
    public void testCalculatorAndHistoryIntegration() {
        Calculator calculator = new Calculator();
        CalculationHistory history = new CalculationHistory();
        
        int result = calculator.add(2, 3);
        history.addRecord("2 + 3", String.valueOf(result));
        
        assertEquals(5, result);
        assertEquals(1, history.getHistorySize());
    }
}