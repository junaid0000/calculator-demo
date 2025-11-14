package com.demo;

public class CalculationRecord {
	private String expression;
	private String result;

	public CalculationRecord(String expression, String result) {
		this.expression = expression;
		this.result = result;
	}

	public String getExpression() {
		return expression;
	}

	public String getResult() {
		return result;
	}

	@Override
	public String toString() {
		return expression + " = " + result;
	}
}