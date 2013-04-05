package com.snakedoc.cisp401.march212013;

import java.util.Scanner;

public class ReadData {
	public static void main(String[] args) throws Exception {

		java.io.File fileIn = new java.io.File("scores.txt");
		Scanner input = new Scanner(fileIn);
		
		while (input.hasNext()) {
			String firstName = input.next();
			String mi = input.next();
			String lastname = input.next();
			int score = input.nextInt();
			System.out.println(firstName + " " + mi + " " + lastname + " " + score);
		}
		input.close();
	}
}
