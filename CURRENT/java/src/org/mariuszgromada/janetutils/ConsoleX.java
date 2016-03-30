package org.mariuszgromada.janetutils;

public final class ConsoleX {
	public static final String CLASS_NAME = ConsoleX.class.getName();
	private static final String DEFAULT_CONSOLE_PREFIX = "[" + JanetUtils.NAME + "-v." + JanetUtils.VERSION + "] ";
	private static String CONSOLE_OUTPUT = "";
	private static String CONSOLE_PREFIX = DEFAULT_CONSOLE_PREFIX;
	private static String CONSOLE_OUTPUT_PREFIX = DEFAULT_CONSOLE_PREFIX;
	private static int CONSOLE_ROW_NUMBER = 1;
	/**
	 * Prints object.toString to the Console + new line
	 *
	 * @param o    Object to print
	 */
	public static final void println(Object o) {
		final String METHOD_NAME = "println(Object o)";
		if (o == null) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "o = null");
		}
		if ((CONSOLE_ROW_NUMBER == 1) && (CONSOLE_OUTPUT.equals(""))) {
			System.out.print(CONSOLE_PREFIX);
			CONSOLE_OUTPUT = CONSOLE_PREFIX;
		}
		System.out.println(o);
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Printing to console, CONSOLE_ROW_NUMBER = " + CONSOLE_ROW_NUMBER + ", o = " + o);
		CONSOLE_ROW_NUMBER++;
		System.out.print(CONSOLE_PREFIX);
		CONSOLE_OUTPUT = CONSOLE_OUTPUT + o + "\n" + CONSOLE_OUTPUT_PREFIX;
	}
	/**
	 * Prints new line to the Console, no new line
	 *
	 */
	public static final void println() {
		final String METHOD_NAME = "println()";
		if ((CONSOLE_ROW_NUMBER == 1) && (CONSOLE_OUTPUT.equals(""))) {
			System.out.print(CONSOLE_PREFIX);
			CONSOLE_OUTPUT = CONSOLE_PREFIX;
		}
		System.out.println();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Printing new line to console, CONSOLE_ROW_NUMBER = " + CONSOLE_ROW_NUMBER);
		CONSOLE_ROW_NUMBER++;
		System.out.print(CONSOLE_PREFIX);
		CONSOLE_OUTPUT = CONSOLE_OUTPUT + "\n" + CONSOLE_OUTPUT_PREFIX;
	}
	/**
	 * Prints object.toString to the Console
	 *
	 * @param o    Object to print
	 */
	public static final void print(Object o) {
		final String METHOD_NAME = "print(Object o)";
		if (o == null) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "o = null");
		}
		if ((CONSOLE_ROW_NUMBER == 1) && (CONSOLE_OUTPUT.equals(""))) {
			System.out.print(CONSOLE_PREFIX);
			CONSOLE_OUTPUT = CONSOLE_PREFIX;
		}
		System.out.print(o);
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Printing to console, CONSOLE_ROW_NUMBER = " + CONSOLE_ROW_NUMBER + ", o = " + o);
		CONSOLE_OUTPUT = CONSOLE_OUTPUT + o;
	}
	/**
	 * Resets console output string, console output
	 * string is being built by consolePrintln(), consolePrint().
	 */
	public static final void resetConsoleOutput() {
		final String METHOD_NAME = "resetConsoleOutput()";
		CONSOLE_OUTPUT = "";
		CONSOLE_ROW_NUMBER = 1;
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Setting blank console outputm, CONSOLE_ROW_NUMBER = " + CONSOLE_ROW_NUMBER);
	}
	/**
	 * Sets default console prefix.
	 */
	public void setDefaultConsolePrefix() {
		final String METHOD_NAME = "resetConsoleOutput()";
		CONSOLE_PREFIX = DEFAULT_CONSOLE_PREFIX;
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "CONSOLE_PREFIX = " + CONSOLE_PREFIX);
	}
	/**
	 * Sets default console output string prefix.
	 */
	public void setDefaultConsoleOutputPrefix() {
		final String METHOD_NAME = "resetConsoleOutput()";
		CONSOLE_OUTPUT_PREFIX = DEFAULT_CONSOLE_PREFIX;
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "CONSOLE_OUTPUT_PREFIX = " + CONSOLE_OUTPUT_PREFIX);
	}
	/**
	 * Sets console prefix.
	 */
	public void setConsolePrefix(String consolePrefix) {
		final String METHOD_NAME = "setConsolePrefix(String consolePrefix)";
		if (consolePrefix == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "consolePrefix = null");
		}
		CONSOLE_PREFIX = consolePrefix;
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "CONSOLE_PREFIX = " + CONSOLE_PREFIX);
	}
	/**
	 * Sets console output string prefix.
	 */
	public void setConsoleOutputPrefix(String consoleOutputPrefix) {
		final String METHOD_NAME = "setConsoleOutputPrefix(String consoleOutputPrefix)";
		if (consoleOutputPrefix == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "consoleOutputPrefix = null");
		}
		CONSOLE_OUTPUT_PREFIX = consoleOutputPrefix;
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "CONSOLE_OUTPUT_PREFIX = " + CONSOLE_OUTPUT_PREFIX);
	}
	/**
	 * Returns console output string, console output string
	 * is being built by consolePrintln(), consolePrint().
	 *
	 * @return Console output string
	 */
	public static final String getConsoleOutput() {
		return CONSOLE_OUTPUT;
	}

}
