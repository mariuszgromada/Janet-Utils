package org.mariuszgromada.janetutils;

import java.util.regex.Pattern;

public final class StringX {
	public static final String CLASS_NAME = StringX.class.getName();
	public static final String PATTERN_DATE_TIME_YYYYMMDDHHMMSS = "[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}";
	/**
	 * Function used to introduce some compatibility
	 * between JAVA and C# while regexp matching.
	 *
	 * @param str         String
	 * @param pattern     Pattern (regexp)
	 *
	 * @return            True if pattern matches entirely, False otherwise
	 */
    public static final boolean regexMatch(String str, String pattern){
        return Pattern.matches(pattern, str);
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
			rndStr = rndStr + chars[ RandomX.randomIndex(chars.length) ];
		return rndStr;
	}
}
