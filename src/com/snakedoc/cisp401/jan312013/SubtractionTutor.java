package com.snakedoc.cisp401.jan312013;

//SubtractionTutor.java
import javax.swing.JOptionPane;

public class SubtractionTutor {
	public static void main(String[] args) {
		int number1 = (int) (Math.random() + 10);
		int number2 = (int) (Math.random() * 10);
		
		if (number1 < number2) {
			int temp = number1;
			number1 = number2;
			number2 = temp;
		}
		String answerString = JOptionPane.showInputDialog
				("What is " + number1 + " - " + number2 + "?");
		int answer = Integer.parseInt(answerString);
		String replyString;
		if (number1 - number2 == answer)
			replyString = "You are correct!";
		else
			replyString = "Your answer is wrong\n" + number1 + " - "
			+ number2 + " should be " + (number1 - number2);
		JOptionPane.showMessageDialog(null, replyString);
	}
}
