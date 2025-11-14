package com.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame {
	private Calculator calculator;
	private CalculationHistory history;
	private JTextField display;
	private JTextArea historyArea;

	public CalculatorGUI() {
		calculator = new Calculator();
		history = new CalculationHistory();
		setupGUI();
	}

	private void setupGUI() {
		setTitle("Mini Calculator Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 500);
		setLayout(new BorderLayout());

		// Display
		display = new JTextField("0");
		display.setEditable(false);
		display.setFont(new Font("Arial", Font.BOLD, 20));
		add(display, BorderLayout.NORTH);

		// Number buttons
		JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));

		String[] buttons = { "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "C", "0", "=", "/" };

		for (String text : buttons) {
			JButton button = new JButton(text);
			button.addActionListener(new ButtonClickListener());
			buttonPanel.add(button);
		}

		add(buttonPanel, BorderLayout.CENTER);

		// History area
		historyArea = new JTextArea(8, 20);
		historyArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(historyArea);
		add(scrollPane, BorderLayout.SOUTH);
	}

	private class ButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();

			// For demo - just show basic operations
			if (command.equals("+")) {
				int result = calculator.add(5, 3);
				display.setText("5 + 3 = " + result);
				history.addRecord("5 + 3", String.valueOf(result));
				updateHistory();
			} else if (command.equals("-")) {
				int result = calculator.subtract(10, 4);
				display.setText("10 - 4 = " + result);
				history.addRecord("10 - 4", String.valueOf(result));
				updateHistory();
			} else if (command.equals("C")) {
				display.setText("0");
				history.clearHistory();
				updateHistory();
			}
		}
	}

	private void updateHistory() {
		StringBuilder historyText = new StringBuilder("Calculation History:\n");
		for (CalculationRecord record : history.getHistory()) {
			historyText.append(record.toString()).append("\n");
		}
		historyArea.setText(historyText.toString());
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new CalculatorGUI().setVisible(true);
			}
		});
	}
}