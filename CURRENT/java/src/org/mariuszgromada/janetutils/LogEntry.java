package org.mariuszgromada.janetutils;

public class LogEntry {
	public static final int INFO = 1;
	public static final int WARNING = 0;
	public static final int ERROR = -1;
	public String packageName;
	public String className;
	public String methodName;
	public String timeStamp;
	public int messageId;
	public int messageType;
	public int errorCode;
	public String errorDescription;
	public String logMessage;
	double processingTime;
}
