package org.mariuszgromada.janetutils;

public final class RandomX {
	public static final String CLASS_NAME = RandomX.class.getName();
	/**
	 * Random number generator for n returning random number between 0, 1, ... n-1.
	 *
	 * @param     n    The parameter influencing random number generation process.
	 * @return    Random number between 0, 1, ... n-1 if n is 1 or above, otherwise
	 *            error {@link ErrorCodes#CODE_INCORRECT_PARAMETER}
	 *            is returned.
	 */
	public static final int randomIndex(int n) {
		if (n < 0)
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		return (int)Math.floor(Math.random() * n);
	}
	/**
	 * Random number generator for n returning random number between 1, 2, ... n.
	 *
	 * @param     n    The parameter influencing random number generation process.
	 * @return    Random number between 1, 2, ... n if n is 1 or above, otherwise
	 *            error {@link ErrorCodes#CODE_INCORRECT_PARAMETER}
	 *            is returned.
	 */
	public static final int randomNumber(int n) {
		if (n < 1)
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		return (int)Math.floor(Math.random() * n) + 1;
	}
}
