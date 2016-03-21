package org.mariuszgromada.janetutils;

public final class ErrorCodes {
	public static final int INCORRECT_PARAMETER = -100;
	public static final String INCORRECT_PARAMETER_MSG = "Incorrect parameter.";
	public static final String ERROR_CODE_UNKNOWN_MSG = "Incorrect error code.";
	public static final String getErrorDescription(int errorCode) {
		switch(errorCode) {
		case INCORRECT_PARAMETER: return INCORRECT_PARAMETER_MSG;
		}
		return ERROR_CODE_UNKNOWN_MSG;
	}
	
}
