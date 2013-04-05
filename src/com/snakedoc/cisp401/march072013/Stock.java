package com.snakedoc.cisp401.march072013;

public class Stock {
	
	/* declare working variables */
	String symbol = "";
	String name = "";
	double previousClosingPrice = 0.00d;
	double currentPrice = 0.00d;
	
	/* constructor */
	Stock(String symbol, String name, double previousClosingPrice, double currentPrice) {
		this.symbol = symbol;
		this.name = name;
		this.previousClosingPrice = previousClosingPrice;
		this.currentPrice = currentPrice;
	}
	
	/**
	 * Gets percentage of change between
	 * previous and current price.
	 * 
	 * @return Percentage of change in a double type.
	 */
	public double getChangePercent() {
		return (((this.currentPrice - this.previousClosingPrice) / this.previousClosingPrice) * 100);
	}
	
	/* block of setters */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPreviousClosingPrice(double previousClosingPrice) {
		this.previousClosingPrice = previousClosingPrice;
	}
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	
	/* block of getters */
	public String getSymbol() {
		return this.symbol;
	}
	public String getName() {
		return this.name;
	}
	public double getPreviousClosingPrice() {
		return this.getPreviousClosingPrice();
	}
	public double getCurrentPrice() {
		return this.currentPrice;
	}
	
}
