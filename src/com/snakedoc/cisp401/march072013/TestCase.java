package com.snakedoc.cisp401.march072013;

public class TestCase {
	public static void main(String[] args) {
		
		/* construct new Stock() */
		Stock stock = new Stock
				(
					"ORCL",
					"Oracle Corporation",
					34.5,
					34.35
				);
		/* display percentage of change */
		System.out.println("Percentage of change: " + stock.getChangePercent() + "%");
	}
}
