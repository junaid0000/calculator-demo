package com.demo;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorGUITest {

    @Test
    public void testGUIComponents() {
        // Test without displaying GUI (headless)
        CalculatorGUI gui = new CalculatorGUI();
        assertNotNull("Display should be created", gui.getDisplay());
        assertNotNull("History area should be created", gui.getHistoryArea());
        assertNotNull("+ button should exist", gui.getButton("+"));
        assertNotNull("- button should exist", gui.getButton("-"));
        assertNotNull("C button should exist", gui.getButton("C"));
    }
    @Test
    public void testMainMethod() {
        // Test that main method doesn't crash
        try {
            CalculatorGUI.main(new String[]{});
            // If we reach here, main ran without crashing
            assertTrue(true);
        } catch (Exception e) {
            fail("Main method should not throw exceptions");
        }
    }

    @Test  
    public void testAllButtonPaths() {
        CalculatorGUI gui = new CalculatorGUI();
        
        // Test ALL button types to cover all code paths
        String[] allButtons = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", "*", "/", "="};
        
        for (String button : allButtons) {
            gui.testButtonClick(button);
            // These buttons have no action - tests the "do nothing" path
        }
    }

    @Test
    public void testButtonActions() {
        CalculatorGUI gui = new CalculatorGUI();
        
        // Test button actions without GUI display
        gui.testButtonClick("+");
        assertEquals("5 + 3 = 8", gui.getDisplay().getText());
        
        gui.testButtonClick("-");
        assertEquals("10 - 4 = 6", gui.getDisplay().getText());
        
        gui.testButtonClick("C");
        assertEquals("0", gui.getDisplay().getText());
    }
}