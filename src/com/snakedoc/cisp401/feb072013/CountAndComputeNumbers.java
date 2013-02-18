package com.snakedoc.cisp401.feb072013;

import java.util.Scanner;

public class CountAndComputeNumbers {
	public static void main(String[] args) {
		int num = 0;
		int numOfPositive = 0;
		int numOfNegative = 0;
		int sum = 0;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number (negative or positive, 0 to stop): ");
		num = input.nextInt();
		while (num != 0) {
			if (num > 0) {
				numOfPositive++;
			} else if (num < 0) {
				numOfNegative++;
			}
			sum += num;
			System.out.print("Enter a number (negative or positive, 0 to stop): ");
			num = input.nextInt();
		}
		System.out.println("Sum: " + sum);
		System.out.println("Average: " + (sum / (numOfPositive + numOfNegative)));
		
	}
}
