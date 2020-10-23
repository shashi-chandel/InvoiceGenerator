package com.capgemini.tdd.invoiceservice;

import org.junit.Test;
import org.junit.Assert;

public class InvoiceGeneratorTest {

	@Test
	public void numberOfDaysGiven_shouldReturnRate() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		int rate = invoiceGenerator.calculateRate(2);
		Assert.assertEquals(500, rate);
	}
}
