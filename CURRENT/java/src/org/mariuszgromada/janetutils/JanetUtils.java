package org.mariuszgromada.janetutils;

public final class JanetUtils {
	public static final String CLASS_NAME = JanetUtils.class.getName();
	public static boolean logInfo = true;
	public static boolean logWarnings = true;
	public static boolean logErrors = true;
	public static final String VERSION = "0.0.1";
	public static final String NAME = "Janet-Utils";
	public static final String AUTHOR = "Mariusz Gromada";
	public static final Log eventslog = new Log("Janet-Utils events log");
	public static final void logInfo(String className, String methodName, String logMessage) {
		LogEntry entry = new LogEntry();
		entry.errorCode = ErrorCodes.CODE_NO_ERRORS;
		entry.errorDescription = ErrorCodes.DESCR_NO_ERRORS;
		entry.timeStamp = DateTimeX.getCurrDateTimeStr();
		entry.className = className;
		entry.methodName = methodName;
		entry.logMessage = "(info) " + logMessage;
		entry.messageType = LogEntry.INFO;
		entry.messageId = eventslog.logEntries.size();
		eventslog.addEntry(entry);
	}
	public static final void logInfo(String className, String methodName, String logMessage, double processingTime) {
		LogEntry entry = new LogEntry();
		entry.errorCode = ErrorCodes.CODE_NO_ERRORS;
		entry.errorDescription = ErrorCodes.DESCR_NO_ERRORS;
		entry.timeStamp = DateTimeX.getCurrDateTimeStr();
		entry.className = className;
		entry.methodName = methodName;
		entry.logMessage = "(info) " + logMessage;
		entry.messageType = LogEntry.INFO;
		entry.messageId = eventslog.logEntries.size();
		entry.processingTime = processingTime;
		eventslog.addEntry(entry);
	}
	public static final void logWarning(String className, String methodName, String logMessage) {
		LogEntry entry = new LogEntry();
		entry.errorCode = ErrorCodes.CODE_NO_ERRORS;
		entry.errorDescription = ErrorCodes.DESCR_NO_ERRORS;
		entry.timeStamp = DateTimeX.getCurrDateTimeStr();
		entry.className = className;
		entry.methodName = methodName;
		entry.logMessage = "(warning) " + logMessage;
		entry.messageType = LogEntry.WARNING;
		entry.messageId = eventslog.logEntries.size();
		eventslog.addEntry(entry);
	}
	public static final void logWarning(String className, String methodName, int errorCode, String logMessage) {
		LogEntry entry = new LogEntry();
		entry.errorCode = errorCode;
		entry.errorDescription = ErrorCodes.getErrorDescription(errorCode);
		entry.timeStamp = DateTimeX.getCurrDateTimeStr();
		entry.className = className;
		entry.methodName = methodName;
		entry.logMessage = "(warning) " + logMessage;
		entry.messageType = LogEntry.WARNING;
		entry.messageId = eventslog.logEntries.size();
		eventslog.addEntry(entry);
	}
	public static final void logError(String className, String methodName, int errorCode, String logMessage) {
		LogEntry entry = new LogEntry();
		entry.errorCode = errorCode;
		entry.errorDescription = ErrorCodes.getErrorDescription(errorCode);
		entry.timeStamp = DateTimeX.getCurrDateTimeStr();
		entry.className = className;
		entry.methodName = methodName;
		entry.logMessage = "(error) " + logMessage;
		entry.messageType = LogEntry.ERROR;
		entry.messageId = eventslog.logEntries.size();
		eventslog.addEntry(entry);
	}
}
