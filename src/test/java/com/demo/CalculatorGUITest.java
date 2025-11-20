package com.demo;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorGUITest {

	@Test
	public void testButtonClickActions() {
		CalculatorGUI gui = new CalculatorGUI();

		// Test + button
		gui.testButtonClick("+");
		assertEquals("5 + 3 = 8", gui.getDisplay().getText());

		// Test - button  
		gui.testButtonClick("-");
		assertEquals("10 - 4 = 6", gui.getDisplay().getText());

		// Test C button
		gui.testButtonClick("C");
		assertEquals("0", gui.getDisplay().getText());
	}

	@Test
	public void testGUIComponents() {
		CalculatorGUI gui = new CalculatorGUI();
		assertNotNull(gui.getDisplay());
		assertNotNull(gui.getHistoryArea());
		assertNotNull(gui.getButton("+"));
		assertNotNull(gui.getButton("-"));
		assertNotNull(gui.getButton("C"));
	}
	@Test
	public void testUnknownButton() {
	    CalculatorGUI gui = new CalculatorGUI();
	    
	    // Test clicking a button that has no action (like "1")
	    // This tests the "else" branch in ButtonClickListener
	    gui.testButtonClick("1");
	    // Should do nothing since only +, -, C are handled
	    assertEquals("0", gui.getDisplay().getText());
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
}