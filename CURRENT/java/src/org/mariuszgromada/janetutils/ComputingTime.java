package org.mariuszgromada.janetutils;

public class ComputingTime {
	private long startTimeMs;
	private long endTimeMs;
	private long computingTimeMs;
	private double computingTime;
	public void start() {
		startTimeMs = DateTimeX.currentTimeMillis();
		endTimeMs = startTimeMs;
	}
	public void end() {
		endTimeMs = DateTimeX.currentTimeMillis();
		computingTimeMs = (endTimeMs - startTimeMs);
		computingTime = computingTimeMs / 1000.0;
	}
	public long getComputingTimeMs() {
		return computingTimeMs;
	}
	public double getComputingTime() {
		return computingTime;
	}	
}
