package org.mariuszgromada.janetutils;

public final class ErrorCodes {
	public static final int NO_ERRORS = 0;
	public static final int INCORRECT_PARAMETER = -100;
	public static final int NULL_PARAMETER = -101;
	public static final int NOTHING_TO_PROCESS = -102;
	public static final String NO_ERRORS_MSG = "No errors.";
	public static final String INCORRECT_PARAMETER_MSG = "Incorrect parameter.";
	public static final String NULL_PARAMETER_MSG = "Null parameter.";
	public static final String ERROR_CODE_UNKNOWN_MSG = "Incorrect error code.";
	public static final String NOTHING_TO_PROCESS_MSG = "Nothing to process.";
	public static final String getErrorDescription(int errorCode) {
	switch(errorCode) {
		case NO_ERRORS: return NO_ERRORS_MSG;
		case INCORRECT_PARAMETER: return INCORRECT_PARAMETER_MSG;
		case NULL_PARAMETER: return NULL_PARAMETER_MSG;
		case NOTHING_TO_PROCESS: return NOTHING_TO_PROCESS_MSG;
		}
		return ERROR_CODE_UNKNOWN_MSG;
	}
	
}
