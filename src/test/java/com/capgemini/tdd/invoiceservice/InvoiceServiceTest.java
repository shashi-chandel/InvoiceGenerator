package com.capgemini.tdd.invoiceservice;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class InvoiceServiceTest {
	Ride[] rides = null;
	InvoiceSummary expectedInvoiceSummary = null;
	InvoiceService invoiceService = null;
	private RideRepository rideRepository = null;

	@Before
	public void setUp() throws Exception {
		invoiceService = new InvoiceService();
		rideRepository = new RideRepository();
		invoiceService.setRideRepository(rideRepository);
		rides = new Ride[] {
				new Ride(2.0, 5,CabRide.NORMAL),
				new Ride(0.1, 1,CabRide.PREMIUM)
		};
		
		expectedInvoiceSummary = new InvoiceSummary(2, 45.0);
	}

	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		double distance = 2.0;
		int time = 5;
		double fare = invoiceService.calculateFare(distance, time);
		Assert.assertEquals(25, fare, 0.0);
	}

	@Test
	public void givenLessDistanceAndTime_ShouldReturnTotalMinFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceService.calculateFare(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}

	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		InvoiceSummary summary = invoiceService.calculateFare(rides);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 45.0);
		Assert.assertEquals(expectedSummary, summary);
	}

	@Test
	public void givenUserIdAndRidesForTwoCategoriesRides_ShouldReturnInvoiceSummary() {
		String userId = "a@s.com";
		invoiceService.addRides(userId, rides);
		InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}

}
