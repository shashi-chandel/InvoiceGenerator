package com.capgemini.tdd.invoiceservice;

public class Ride {
	public double distance;
	public int time;
	public final CabRide cabRide;

	public Ride(double distance, int time, CabRide ride) {
		this.distance = distance;
		this.time = time;
		this.cabRide = ride;
	}
}
