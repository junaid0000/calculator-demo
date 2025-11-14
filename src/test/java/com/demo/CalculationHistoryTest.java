package com.demo;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

public class CalculationHistoryTest {

	@Test
	public void testAddCalculationToHistory() {
		CalculationHistory history = new CalculationHistory();
		history.addRecord("2 + 3", "5");

		assertEquals(1, history.getHistorySize());
	}

	@Test
	public void testGetCalculationHistory() {
		CalculationHistory history = new CalculationHistory();
		history.addRecord("2 + 3", "5");
		history.addRecord("10 - 4", "6");

		List<CalculationRecord> records = history.getHistory();
		assertEquals(2, records.size());
		assertEquals("2 + 3 = 5", records.get(0).toString());
	}

	@Test
	public void testClearHistory() {
		CalculationHistory history = new CalculationHistory();
		history.addRecord("2 + 3", "5");
		history.clearHistory();

		assertEquals(0, history.getHistorySize());
	}
}