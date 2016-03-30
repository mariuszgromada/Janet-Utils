package org.mariuszgromada.janetutils;

import java.util.ArrayList;

public class Log {
	public static final String CLASS_NAME = Log.class.getName();
	public ArrayList<LogEntry> logEntries;
	public String logDescription;
	public Log() {
		logEntries = new ArrayList<LogEntry>();
	}
	public Log(String logDescription) {
		logEntries = new ArrayList<LogEntry>();
		this.logDescription = logDescription;
	}
	public void clear() {
		logEntries.clear();
	}
	public void addEntry(LogEntry entry) {
		logEntries.add(entry);
	}
	public void consolePrint() {
		System.out.println(logDescription);
		System.out.println("-----------------------------------------");
		for (LogEntry entry : logEntries) {
			System.out.println(entry.messageId + ";" + entry.timeStamp + ";" + entry.className + ";" + entry.methodName + ";" + entry.errorCode + ";" + entry.errorDescription + ";" + entry.messageType + ";" + entry.logMessage + ";" + entry.processingTime + "s.");
		}
		System.out.println("-----------------------------------------");
	}
}
