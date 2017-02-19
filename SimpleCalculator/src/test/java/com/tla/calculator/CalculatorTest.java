package com.tla.calculator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	// Class under test
	private ICalculator calc;
	
	
	@Before
	public void setUp() throws Exception {
		this.calc = new Calculator();
	}
	

	@After
	public void tearDown() throws Exception {
		this.calc = null;
	}

	@Test
	public void testAdd() {
		assertEquals(2, calc.add(1, 1));
		
		assertEquals(0, calc.add(0, 0));
		
		assertEquals(-2, calc.add(-1, -1));
		
	}

	@Test
	public void testSubtract() {
		assertEquals(0, calc.subtract(1, 1));
		
		assertEquals(0, calc.subtract(0, 0));
		
		assertEquals(-1, calc.subtract(0, 1));
		
	}

	@Test
	public void testDivide() {
		assertEquals(BigDecimal.ZERO, calc.divide(0, 1));
		
		assertEquals(new BigDecimal(2), calc.divide(4, 2));
		
		assertEquals(0.3333333, calc.divide(1, 3).floatValue(), 0.0000001);
	}
	
	@Test(expected=ArithmeticException.class)
	public void testDivideByZero() {
		calc.divide(1, 0);
	}

	@Test
	public void testMultiply() {
		assertEquals(0, calc.multiply(0, 1));
		
		assertEquals(0, calc.multiply(0, 0));
		
		assertEquals(4, calc.multiply(4, 1));
		
		assertEquals(4, calc.multiply(2, 2));
	}

	@Test(expected=ArithmeticException.class)
	public void testMultiplyTooBig() {
		calc.multiply(Integer.MAX_VALUE, 2);
	}
	
	
	@Test
	public void testPrecision() {
		calc.setPrecision(3);
		assertEquals(0.333, calc.divide(1, 3).floatValue(), 0.001);
	}

}
