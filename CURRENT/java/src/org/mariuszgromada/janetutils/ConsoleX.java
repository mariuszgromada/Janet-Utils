package org.mariuszgromada.janetutils;

public final class ConsoleX {
	
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
		if ((CONSOLE_ROW_NUMBER == 1) && (CONSOLE_OUTPUT.equals(""))) {
			System.out.print(CONSOLE_PREFIX);
			CONSOLE_OUTPUT = CONSOLE_PREFIX;
		}
		System.out.println(o);
		CONSOLE_ROW_NUMBER++;
		System.out.print(CONSOLE_PREFIX);
		CONSOLE_OUTPUT = CONSOLE_OUTPUT + o + "\n" + CONSOLE_OUTPUT_PREFIX;
	}
	/**
	 * Prints new line to the Console, no new line
	 *
	 */
	public static final void println() {
		if ((CONSOLE_ROW_NUMBER == 1) && (CONSOLE_OUTPUT.equals(""))) {
			System.out.print(CONSOLE_PREFIX);
			CONSOLE_OUTPUT = CONSOLE_PREFIX;
		}
		System.out.println();
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
		if ((CONSOLE_ROW_NUMBER == 1) && (CONSOLE_OUTPUT.equals(""))) {
			System.out.print(CONSOLE_PREFIX);
			CONSOLE_OUTPUT = CONSOLE_PREFIX;
		}
		System.out.print(o);
		CONSOLE_OUTPUT = CONSOLE_OUTPUT + o;
	}
	/**
	 * Resets console output string, console output
	 * string is being built by consolePrintln(), consolePrint().
	 */
	public static final void resetConsoleOutput() {
		CONSOLE_OUTPUT = "";
		CONSOLE_ROW_NUMBER = 1;
	}
	/**
	 * Sets default console prefix.
	 */
	public void setDefaultConsolePrefix() {
		CONSOLE_PREFIX = DEFAULT_CONSOLE_PREFIX;
	}
	/**
	 * Sets default console output string prefix.
	 */
	public void setDefaultConsoleOutputPrefix() {
		CONSOLE_OUTPUT_PREFIX = DEFAULT_CONSOLE_PREFIX;
	}
	/**
	 * Sets console prefix.
	 */
	public void setConsolePrefix(String consolePrefix) {
		CONSOLE_PREFIX = consolePrefix;
	}
	/**
	 * Sets console output string prefix.
	 */
	public void setConsoleOutputPrefix(String consoleOutputPrefix) {
		CONSOLE_OUTPUT_PREFIX = consoleOutputPrefix;
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
