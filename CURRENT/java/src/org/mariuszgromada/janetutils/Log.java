package org.mariuszgromada.janetutils;

import java.util.ArrayList;

public class Log {
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
		ConsoleX.println(logDescription);
		ConsoleX.println("-----------------------------------------");
		for (LogEntry entry : logEntries) {
			ConsoleX.println(entry.messageId + ";" + entry.timeStamp + ";" + entry.packageName + ";" + entry.className + ";" + entry.methodName + ";" + entry.errorCode + ";" + entry.errorDescription + ";" + entry.messageType + ";" + entry.logMessage + ";" + entry.processingTime + "s.");
		}
		ConsoleX.println("-----------------------------------------");
	}
}
