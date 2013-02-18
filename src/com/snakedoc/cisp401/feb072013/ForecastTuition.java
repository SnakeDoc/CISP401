package com.snakedoc.cisp401.feb072013;

import java.math.BigDecimal;

public class ForecastTuition {
	public static void main(String[] args) {
		BigDecimal startTuition = new BigDecimal(10000.00);
		BigDecimal percentIncrease = new BigDecimal(1.05);
		
		BigDecimal tenYearTuition = (startTuition.multiply(percentIncrease)).multiply(new BigDecimal(10));
		tenYearTuition = startTuition.multiply(percentIncrease);
		for (int i = 0; i < 9; i++) {
			tenYearTuition = tenYearTuition.multiply(percentIncrease);
		}
		
		System.out.println("Tution in 10 years will cost: $" 
				+ tenYearTuition.setScale(2, BigDecimal.ROUND_HALF_UP) + " per year.");
		
		BigDecimal fourYearTotalTuitionInTenYears = tenYearTuition;
		for (int i = 0; i < 3; i++) {
			fourYearTotalTuitionInTenYears = fourYearTotalTuitionInTenYears.add(
					tenYearTuition.multiply(percentIncrease));
		}
		System.out.println("Total tuition cost starting 10 years from now over 4 years: $"
				+ fourYearTotalTuitionInTenYears.setScale(2, BigDecimal.ROUND_HALF_UP));
	}
}
