package com.capgemini.tdd.invoiceservice;

public class InvoiceGenerator {
	public final double MINIMUM_COST_PER_KILOMETER = 10.0;
	public final int COST_PER_TIME = 1;

	public double calculateFare(double distance, int time) {
		return (distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME);
	}
}
