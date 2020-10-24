package com.capgemini.tdd.invoiceservice;

import org.junit.Test;
import org.junit.Assert;

public class InvoiceGeneratorTest {

	@Test
	public void givenDistanceAndTime_shouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(25, fare, 0.0);
	}
}
