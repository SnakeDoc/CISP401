package com.snakedoc.cisp401.march212013;

import java.io.IOException;

public class WriteData {

	public static void main(String[] args) throws IOException {

		java.io.File fName = new java.io.File("scores.txt");

		if (fName.exists()) {
			System.out.println("File already exists");
			System.exit(1);
		}

		java.io.PrintWriter output = new java.io.PrintWriter(fName);
		output.print("John T Smith ");
		output.println(90);
		output.print("Eric K Jones ");
		output.println(85);
		output.close();
	}
}
