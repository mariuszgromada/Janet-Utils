package org.mariuszgromada.janetutils;

public final class RandomX {
	/**
	 * Random number generator for n returning random number between 0, 1, ... n-1.
	 *
	 * @param     n    The parameter influencing random number generation process.
	 * @return    Random number between 0, 1, ... n-1 if n is 1 or above, otherwise
	 *            error {@link ErrorCodes#INCORRECT_PARAMETER}
	 *            is returned.
	 */
	public static final int randomIndex(int n) {
		if (n < 0)
			return ErrorCodes.INCORRECT_PARAMETER;
		return (int)Math.floor(Math.random() * n);
	}
	/**
	 * Random number generator for n returning random number between 1, 2, ... n.
	 *
	 * @param     n    The parameter influencing random number generation process.
	 * @return    Random number between 1, 2, ... n if n is 1 or above, otherwise
	 *            error {@link ErrorCodes#INCORRECT_PARAMETER}
	 *            is returned.
	 */
	public static final int randomNumber(int n) {
		if (n < 1)
			return ErrorCodes.INCORRECT_PARAMETER;
		return (int)Math.floor(Math.random() * n) + 1;
	}
	/**
	 * Random string generator.
	 * @param length    Length of random string.
	 * @return          Random string containing a-zA-Z0-9.
	 */
	public static final String randomString(int length) {
		if (length < 1) return "";
		char[] chars = {
							'z','x','c','v','b','n','m','a','s','d','f','g','h','j','k','l','q','w','e','r','t','y','u','i','o','p',
							'Z','X','C','V','B','N','M','A','S','D','F','G','H','J','K','L','Q','W','E','R','T','Y','U','I','O','P',
							'0','1','2','3','4','5','6','7','8','9'
				};
		String rndStr = "";
		for (int i = 0; i < length; i++)
			rndStr = rndStr + chars[ randomIndex(chars.length) ];
		return rndStr;
	}
}
