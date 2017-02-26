package com.tla.calculator;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Customizes System.out so we can test the results of the Calculator.
 * 
 * @author Clinton
 *
 */
public class CalculatorDriverTest {

	private ByteArrayOutputStream myOut;
	
	@Before
	public void setUp() throws Exception {
		myOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(myOut));
	}

	@After
	public void tearDown() throws Exception {
		myOut.close();
		System.setOut(System.out);
	}

	
	// Command line invocation tests
	// -----------------------------
	
	@Test(expected=IllegalArgumentException.class)
	public void testUsageNoArgs() {
		CalculatorDriver.main(new String[0]);
	}
	
	@Test(expected=NullPointerException.class)
	public void testUsageNullArgs() {
		CalculatorDriver.main(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testUsageTooFewArgs() {
		CalculatorDriver.main(new String[]{"1", "+"});
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testUsageTooManyArgs() {
		CalculatorDriver.main(new String[]{"1", "+", "1", "999999"});
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testUsageNonNumericArgs() {
		CalculatorDriver.main(new String[]{"I'm not a number!", "+", "1"});
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testUsageBadOperator() {
		CalculatorDriver.main(new String[]{"1", "Invalid Operator!", "1"});
	}
	
	// Calculator tests
	// ----------------
	
	@Test
	public void testAdd() {
		CalculatorDriver.main(new String[]{"1", "+", "1"});
		assertEquals("2", myOut.toString().trim());
	}
	
	@Test
	public void testSubtract() {
		CalculatorDriver.main(new String[]{"1", "-", "1"});
		assertEquals("0", myOut.toString().trim());
	}
	
	@Test
	public void testMultiply() {
		CalculatorDriver.main(new String[]{"4", "x", "2"});
		assertEquals("8", myOut.toString().trim());
	}
	
	@Test
	public void testDivide() {
		CalculatorDriver.main(new String[]{"4", "/", "2"});
		assertEquals("2", myOut.toString().trim());
	}
	
	@Test
	public void testDivideFloatResult() {
		CalculatorDriver.main(new String[]{"1", "/", "3"});
		assertEquals("0.3333333", myOut.toString().trim());
	}
	
	@Test(expected=ArithmeticException.class)
	public void testDivideByZero() {
		CalculatorDriver.main(new String[]{"1", "/", "0"});
	}

}
