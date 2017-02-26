package com.tla.calculator;

/**
 * Command line interface for the Calculator class.
 * There could be other ways to "drive" the Calculator, such as file input.
 * 
 * @author Clinton
 *
 */
public class CalculatorDriver {

	/**
	 * Command line entry point for the Calculator application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		CalculatorInput input = parseCommandLine(args);
		
		System.out.println(execute(input));
	}
	
	
	private static String execute(CalculatorInput args) {
		ICalculator calc = new Calculator();
		String output = "";
		switch (args.function) {
			case "+":
				// using "" += to force String output
				output += calc.add(args.x, args.y);
				break;
			case "-":
				output += calc.subtract(args.x, args.y);
				break;
			case "/":
				output += calc.divide(args.x, args.y);
				break;
			case "x":
				output += calc.multiply(args.x, args.y);
				break;
			default:
				throw new IllegalArgumentException("Unknown function '" + args.function + "'");
		}
		return output;
	}

	
	private static CalculatorInput parseCommandLine(String[] args) {
		if (args.length != 3) {
			throw new IllegalArgumentException("3 arguments are required." + System.lineSeparator() + getUsageMessage());
		}
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[2]);
		return new CalculatorInput(x, args[1], y);
	}


	private static String getUsageMessage() {
		StringBuilder buf = new StringBuilder("Usage: CalculatorDriver {arg1} {operator} {arg2}");
		buf.append(System.lineSeparator()).append("Where operator is one of: {+ - x /}");
		return buf.toString();
	}

}
