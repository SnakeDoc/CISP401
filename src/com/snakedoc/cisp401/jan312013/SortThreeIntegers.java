package com.snakedoc.cisp401.jan312013;

import java.util.Scanner;

public class SortThreeIntegers {
	public static void main(String[] args) {
		/* declarations */
		int num1;
		int num2;
		int num3;
		int temp1;
		int temp2;
		boolean num1bool = false;
		boolean num2bool = false;
		boolean num3bool = false;
		Scanner input = new Scanner(System.in);
		
		/* Get User input */
		System.out.print("Enter a number (num1): ");
		num1 = input.nextInt();
		System.out.print("Enter a number (num2): ");
		num2 = input.nextInt();
		System.out.print("Enter a number (num3): ");
		num3 = input.nextInt();
		
		System.out.println("");
		
		/* Sort integers by smallest to largest,
		 * then display to stdout (console)
		 */
		System.out.print("Smallest: ");
		if (num1 < num2 && num1 < num3) {
			System.out.println(num1);
		} else if (num2 < num1 && num2 < num3) {
			System.out.println(num2);
		} else if (num3 < num1 && num3 < num2) {
			System.out.println(num3);
		}
		
		System.out.print("Middle: ");
		if ((num1 > num2 && num1 < num3) || (num1 < num2 && num1 > num3)) {
			System.out.println(num1);
		} else if ((num2 > num1 && num2 < num3) || (num2 < num1 && num2 > num3)) {
			System.out.println(num2);
		} else if ((num3 > num1 && num3 < num2) || (num3 < num1 && num3 > num2)) {
			System.out.println(num3);
		}
		
		System.out.print("Largest: ");
		if (num1 > num2 && num1 > num3) {
			System.out.println(num1);
		} else if (num2 > num1 && num2 > num3) {
			System.out.println(num2);
		} else if (num3 > num1 && num3 > num2) {
			System.out.println(num3);
		}
		input.close();
	}
}
