/**
 * Calculator class performs basic arithmetic operations: +, -, *, / It stores
 * the result of the last calculation internally.
 * 
 * Throws IllegalArgumentException for: - Division by zero - Invalid operators
 */
public class Calculator {
	// Stores the result of the last calculation
	private double result = 0;

	// Performs a calculation based on the provided operator.
	public double calculate(double num1, String operator, double num2) {
		switch (operator) {
		case "+":
			setResult(num1 + num2);
			return getResult();
		case "-":
			setResult(num1 - num2);
			return getResult();
		case "*":
			setResult(num1 * num2);
			return getResult();
		case "/":
			if (num2 == 0) {
				throw new IllegalArgumentException("Can't divide by zero");
			} else {
				setResult(num1 / num2);
			}
			return getResult();

		default:
			throw new IllegalArgumentException("Use a valid operator: +, -, *, /");
		}
	}

	// Gets the result of the last calculation.
	public double getResult() {
		return result;
	}

	// Sets the result of a calculation.
	public void setResult(double result) {
		this.result = result;
	}
}
