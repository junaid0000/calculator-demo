package com.demo;

import java.util.ArrayList;
import java.util.List;

public class CalculationHistory {
	private List<CalculationRecord> history = new ArrayList<>();

	public void addRecord(String expression, String result) {
		history.add(new CalculationRecord(expression, result));
	}

	public List<CalculationRecord> getHistory() {
		return new ArrayList<>(history); // Return copy
	}

	public void clearHistory() {
		history.clear();
	}

	public int getHistorySize() {
		return history.size();
	}
}