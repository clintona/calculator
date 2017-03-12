package com.tla.calculator;

/**
 * A Transfer Object to store input parameters for the Calculator.
 * 
 * @author Clinton
 *
 */
public class CalculatorInput {
	int x, y;
	String function;
	
	CalculatorInput(int x, String function, int y) {
		this.x = x;
		this.y = y;
		this.function = function;
	}

}
