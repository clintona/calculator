/**
 * 
 */
package com.tla.calculator;

import java.math.BigDecimal;

/**
 * Simple Integer Calculator interface.
 * 
 * @author Clinton
 *
 */
public interface ICalculator {
	
	int add(int x, int y);
	
	int subtract(int x, int y);
	
	BigDecimal divide(int numerator, int denominator);
	
	int multiply(int x, int y);
	
	void setPrecision(int decimalPlaces);

}
