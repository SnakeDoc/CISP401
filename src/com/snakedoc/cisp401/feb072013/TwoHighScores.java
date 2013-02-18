package com.snakedoc.cisp401.feb072013;

import java.util.Scanner;

public class TwoHighScores {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String nameTemp = "";
		String nameFirst = "";
		String nameSecond = "";
		int scoreTemp = 0;
		int scoreFirst = 0;
		int scoreSecond = 0;
		System.out.print("Please enter the Student Name (type 'none' to quit): ");
		nameTemp = input.next();
		while (!nameTemp.equalsIgnoreCase("none")) {
			System.out.print("Please enter the Student Score: ");
			scoreTemp = input.nextInt();
			if (scoreTemp > scoreFirst) {
				scoreFirst = scoreTemp;
				nameFirst = nameTemp;
			} else if (scoreTemp > scoreSecond && scoreTemp < scoreFirst) {
				scoreSecond = scoreTemp;
				nameSecond = nameTemp;
			}
			scoreTemp = 0;
			nameTemp = "";
			System.out.print("Please enter the Student Name (type 'none' to quit): ");
			nameTemp = input.next();
		}
		System.out.println("High Score Student: " + nameFirst + " | Score: " + scoreFirst);
		System.out.println("Second High Score Student: " + nameSecond + " | Score: " + scoreSecond);
	}
}
