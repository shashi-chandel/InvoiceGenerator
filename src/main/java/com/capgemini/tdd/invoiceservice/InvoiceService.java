package com.capgemini.tdd.invoiceservice;

public class InvoiceService {
	public final double NORMAL_MINIMUM_COST_PER_KILOMETER = 10.0;
	public final int NORMAL_COST_PER_TIME = 1;
	public final double NORMAL_MINIMUM_FARE = 5;
	public final double PREMIUM_MINIMUM_COST_PER_KILOMETER = 15.0;
	public final int PREMIUM_COST_PER_TIME = 2;
	public final double PREMIUM_MINIMUM_FARE = 20;
	private final RideRepository rideRepository;

	public InvoiceService() {
		this.rideRepository = new RideRepository();
	}

	public double calculateFare(double distance, int time) {
		double totalFare = distance * NORMAL_MINIMUM_COST_PER_KILOMETER + time * NORMAL_COST_PER_TIME;
		return Math.max(totalFare, NORMAL_MINIMUM_FARE);
	}

	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0.0;
		for (Ride ride : rides) {
			totalFare += this.calculateFare(ride.distance, ride.time);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}

	public void addRides(String userId, Ride[] rides) {
		rideRepository.addRides(userId, rides);
	}

	public InvoiceSummary getInvoiceSummary(String userId) {
		return this.calculateFare(rideRepository.getRides(userId));
	}
}
