package com.capgemini.tdd.invoiceservice;

public class InvoiceService {
	public final double NORMAL_MINIMUM_COST_PER_KILOMETER = 10.0;
	public final int NORMAL_COST_PER_TIME = 1;
	public final double NORMAL_MINIMUM_FARE = 5;
	public final double PREMIUM_MINIMUM_COST_PER_KILOMETER = 15.0;
	public final int PREMIUM_COST_PER_TIME = 2;
	public final double PREMIUM_MINIMUM_FARE = 20;
	private RideRepository rideRepository;

	public double calculateFare(double distance, int time) {
		double totalFare = distance * NORMAL_MINIMUM_COST_PER_KILOMETER + time * NORMAL_COST_PER_TIME;
		return Math.max(totalFare, NORMAL_MINIMUM_FARE);
	}

	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0.0;
		for (Ride ride : rides) {
			totalFare += ride.cabRide.calcCostOfCabRide(ride);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}
	 
	public void addRides(String userId, Ride[] rides) {
		rideRepository.addRides(userId, rides);
	}

	public InvoiceSummary getInvoiceSummary(String userId) {
		return this.calculateFare(rideRepository.getRides(userId));
	}

	public void setRideRepository(RideRepository rideRepository) {
		this.rideRepository = rideRepository;
		
	}
}
