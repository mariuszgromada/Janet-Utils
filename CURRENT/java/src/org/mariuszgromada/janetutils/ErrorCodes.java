package org.mariuszgromada.janetutils;

public final class ErrorCodes {

	public static final int CODE_NO_ERRORS = 0;
	public static final int CODE_INCORRECT_PARAMETER = -100;
	public static final int CODE_NULL_PARAMETER = -101;
	public static final int CODE_NOTHING_TO_PROCESS = -102;
	public static final int CODE_UNKNOWN_ERROR = -200;
	
	private static final String CODE_STR_PREFIX = "`$>^}@!#<{%~?&:";
	public static final String CODE_STR_INCORRECT_PARAMETER = CODE_STR_PREFIX + "-100";
	public static final String CODE_STR_NULL_PARAMETER = CODE_STR_PREFIX + "-101";
	public static final String CODE_STR_NOTHING_TO_PROCESS = CODE_STR_PREFIX + "-102";
	public static final String CODE_STR_UNKNOWN_ERROR = CODE_STR_PREFIX + "-200";
	
	public static final String DESCR_NO_ERRORS = "No errors.";
	public static final String DESCR_INCORRECT_PARAMETER = "Incorrect parameter.";
	public static final String DESCR_NULL_PARAMETER = "Null parameter.";
	public static final String DESCR_ERROR_CODE_UNKNOWN = "Incorrect error code.";
	public static final String DESCR_NOTHING_TO_PROCESS = "Nothing to process.";
	public static final String DESCR_UNKNOWN_ERROR = "Unknown error.";

	public static final int getErrorCode(String codeString) {
		if (codeString.equals(CODE_STR_INCORRECT_PARAMETER)) return CODE_INCORRECT_PARAMETER;
		else if (codeString.equals(CODE_STR_NULL_PARAMETER)) return CODE_NULL_PARAMETER;
		else if (codeString.equals(CODE_STR_NOTHING_TO_PROCESS)) return CODE_NOTHING_TO_PROCESS;
		else if (codeString.equals(CODE_STR_UNKNOWN_ERROR)) return CODE_UNKNOWN_ERROR;
		else return CODE_NO_ERRORS;
	}
	
	public static final String getErrorDescription(int errorCode) {
	switch(errorCode) {
		case CODE_NO_ERRORS: return DESCR_NO_ERRORS;
		case CODE_INCORRECT_PARAMETER: return DESCR_INCORRECT_PARAMETER;
		case CODE_NULL_PARAMETER: return DESCR_NULL_PARAMETER;
		case CODE_NOTHING_TO_PROCESS: return DESCR_NOTHING_TO_PROCESS;
		}
		return DESCR_ERROR_CODE_UNKNOWN;
	}
	
}
