package com.capgemini.tdd.invoiceservice;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class InvoiceServiceTest {
	InvoiceService invoiceService = null;

	@Before
	public void setUp() throws Exception {
		invoiceService = new InvoiceService();
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
		Ride[] rides = { new Ride(2.0, 5, "NORMAL_RIDE"), new Ride(0.1, 1, "NORMAL_RIDE") };
		InvoiceSummary summary = invoiceService.calculateFare(rides);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expectedSummary, summary);
	}

	@Test
	public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
		String userId = "a@s.com";
		Ride[] rides = { new Ride(2.0, 5,"NORMAL_RIDE"), new Ride(0.1, 1,"NORMAL_RIDE") };
		invoiceService.addRides(userId, rides);
		InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}
	
	@Test
	public void givenUserIdAndRidesForTwoCategoriesRides_ShouldReturnInvoiceSummary() {
		String userId = "a@s.com";
		Ride[] rides = { new Ride(2.0, 5,"NORMAL_RIDE"), new Ride(0.1, 1,"PREMIUM_RIDE") };
		invoiceService.addRides(userId, rides);
		InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 45.0);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}
	
}
