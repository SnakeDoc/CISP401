package com.snakedoc.cisp401.jan242013;

import java.util.Scanner;

public class TestScanner {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int intValue = scanner.nextInt();
		System.out.println("You entered the integer " + intValue);
	
		System.out.println("Enter a double value: ");
		double doubleValue = scanner.nextDouble();
		System.out.println("You entered the double value " +
			doubleValue);
		
		System.out.print("Enter a String without a space: ");
		String string = scanner.next();
		System.out.println("You entered the string " + string);
	}
}