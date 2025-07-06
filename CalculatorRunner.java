/*
 * Author: Artem Horbunov
 * Date: July 5, 2015
 * Description: A simple calculator program that performs basic arithmetic operations and handles invalid input.
 */

import java.util.Scanner;

public class CalculatorRunner {

	public static void main(String[] args) {
		// Initialize Scanner and Calculator objects
		String exit = "";
		Calculator calc = new Calculator();
		Scanner input = new Scanner(System.in);
		// Display welcome message
		System.out.println("Welcome to Simple Calculator!");
		System.out.println("=============================");

		do { // Program's main loop
			try {
				// Prompt for user input
				System.out.print("\nEnter the first number: ");
				double num1 = input.nextDouble();
				System.out.print("Enter an operator: ");
				String operator = input.next();
				System.out.print("Enter the second number: ");
				double num2 = input.nextDouble();
				try { // If division by 0
					double result = calc.calculate(num1, operator, num2);
					// Format doubles as strings if they don't have any decimals
					String formattedNum1 = (num1 == (int) num1) ? String.valueOf((int) num1)
							: String.format("%.1f", num1);
					String formattedNum2 = (num2 == (int) num2) ? String.valueOf((int) num2)
							: String.format("%.1f", num2);
					String formattedResult = (result == (int) result) ? String.valueOf((int) result)
							: String.format("%.1f", result);
					System.out.printf("%s %s %s = %s%n", formattedNum1, operator, formattedNum2, formattedResult);
				} catch (ArithmeticException | IllegalArgumentException e) {
					// Handle division by zero
					System.out.println("Error: " + e.getMessage());
				}
				input.nextLine(); // Clear input buffer so user can choose to exit later
				System.out.print("\nDo you want to continue?:\nPress X to exit, ENTER to continue: ");
				exit = input.nextLine();
			} catch (Exception e) {
				// Check for valid input (numerals)
				System.out.println("Only Arabic numerals allowed!");
				input.nextLine(); // Clear invalid input from buffer
			}
		} while (!exit.equalsIgnoreCase("x"));
		input.close(); // Close Scanner to release system resources
	}
}