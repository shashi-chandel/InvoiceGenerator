package com.capgemini.tdd.invoiceservice;

public class InvoiceGenerator {
	private static final int RATE_PER_DAY = 250;

	public int calculateRate(int days) {
		return RATE_PER_DAY * days;
	}
}
