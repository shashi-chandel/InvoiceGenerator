package com.capgemini.tdd.invoiceservice;

public class InvoiceGenerator {
	public final double MINIMUM_COST_PER_KILOMETER = 10.0;
	public final int COST_PER_TIME = 1;
	public final double MINIMUM_FARE = 5;

	public double calculateFare(double distance, int time) {
		double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
		if (totalFare < MINIMUM_FARE)
			return MINIMUM_FARE;
		return totalFare;
	}
	public double calculateFare(Ride[] rides) {
		return 0;
	}
}
