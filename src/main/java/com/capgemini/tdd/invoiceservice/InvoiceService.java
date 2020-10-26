package com.capgemini.tdd.invoiceservice;

public class InvoiceService {
	public final double MINIMUM_COST_PER_KILOMETER = 10.0;
	public final int COST_PER_TIME = 1;
	public final double MINIMUM_FARE = 5;

	public double calculateFare(double distance, int time) {
		double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
		return Math.max(totalFare, MINIMUM_FARE);
	}

	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0.0;
		for (Ride ride : rides) {
			totalFare += this.calculateFare(ride.distance, ride.time);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}

	public void addRides(String userId,Ride[] rides) {
	
	}

	public InvoiceSummary getInvoiceSummary(String userId) {
		return null;
	}
}
