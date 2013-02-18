package com.snakedoc.cisp401.jan312013;

//ComputeTaxWithSelectionStatement.java
import javax.swing.JOptionPane;
	public class ComputeTaxWithSelectionStatement {
		public static void main(String[] args) {
			String statusString = JOptionPane.showInputDialog (
				"Enter the filling status\n" + 
				"0-single filer, 1-married jointly,\n" +
				"2-married separetely, 3-head of household");
			int status = Integer.parseInt(statusString);

			String incomeString = JOptionPane.showInputDialog(
				"Enter the taxable income: ");
			double income = Double.parseDouble(incomeString);

			double tax = 0;
			if (status == 0) {
				
			}
		}
}
