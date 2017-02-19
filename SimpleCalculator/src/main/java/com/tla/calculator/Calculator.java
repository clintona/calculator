/**
 * 
 */
package com.tla.calculator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/**
 * A simple "infix" calculator implementation, using Integers as input.
 * Developed using TDD principles.
 * 
 * @author Clinton
 *
 */
public class Calculator implements ICalculator {
	
	/** Default division precision is IEEE 754R Decimal32 format, 7 digits, and a rounding mode of HALF_EVEN. */
	private MathContext mathContext = MathContext.DECIMAL32;

	@Override
	public int add(int x, int y) {
		return x + y;
	}

	@Override
	public int subtract(int x, int y) {
		return x - y;
	}

	@Override
	public BigDecimal divide(int numerator, int denominator) {
		BigDecimal x = new BigDecimal(numerator);
		BigDecimal y = new BigDecimal(denominator);
		// use a MathContext to get rounding and scaling behaviour
		return x.divide(y, this.mathContext);
	}

	
	@Override
	public int multiply(int x, int y) {
		BigInteger i = BigInteger.valueOf(x);
		BigInteger j = BigInteger.valueOf(y);
		// intValueExact throws an Exception if the result > MAX_INT
		return i.multiply(j).intValueExact();
	}


	/**
	 * Override the default precision used for division.
	 * @param decimalPlaces the no.of decimal places used for division precision
	 */
	@Override
	public void setPrecision(int decimalPlaces) {
		this.mathContext = new MathContext(decimalPlaces);
	}
	

}
