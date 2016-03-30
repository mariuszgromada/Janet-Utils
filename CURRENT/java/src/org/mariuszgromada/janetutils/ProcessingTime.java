package org.mariuszgromada.janetutils;

public class ProcessingTime {
	public static final String CLASS_NAME = ProcessingTime.class.getName();
	private long startTimeMs;
	private long endTimeMs;
	private long processingTimeMs;
	private double processingTime;
	public void start() {
		startTimeMs = DateTimeX.currentTimeMillis();
		endTimeMs = startTimeMs;
	}
	public void end() {
		endTimeMs = DateTimeX.currentTimeMillis();
		processingTimeMs = (endTimeMs - startTimeMs);
		processingTime = processingTimeMs / 1000.0;
	}
	public long getProcessingTimeMs() {
		return processingTimeMs;
	}
	public double getProcessingTime() {
		return processingTime;
	}	
}
