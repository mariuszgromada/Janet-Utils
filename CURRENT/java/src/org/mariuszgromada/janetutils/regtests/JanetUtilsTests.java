/*
 * @(#)JanetUtilsTests.java        1.0.0    2016-03-19
 *
 * You may use this software under the condition of "Simplified BSD License"
 *
 * Copyright 2016 MARIUSZ GROMADA. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 *
 *    1. Redistributions of source code must retain the above copyright notice, this list of
 *       conditions and the following disclaimer.
 *
 *    2. Redistributions in binary form must reproduce the above copyright notice, this list
 *       of conditions and the following disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY <MARIUSZ GROMADA> ``AS IS'' AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are those of the
 * authors and should not be interpreted as representing official policies, either expressed
 * or implied, of MARIUSZ GROMADA.
 *
 * If you have any questions/bugs feel free to contact:
 *
 *     Mariusz Gromada
 *     mariusz.gromada@mathspace.pl
 *     http://mathspace.pl/
 *     http://mathparser.org/
 *     http://github.com/mariuszgromada/java-utils
 *     http://github.com/mariuszgromada/MathParser.org-mXparser
 *     http://mariuszgromada.github.io/MathParser.org-mXparser/
 *     http://mxparser.sourceforge.net/
 *     http://bitbucket.org/mariuszgromada/mxparser/
 *     http://mxparser.codeplex.com/
 *
 *                              Asked if he believes in one God, a mathematician answered:
 *                              "Yes, up to isomorphism."
 */

package org.mariuszgromada.janetutils.regtests;

import java.util.ArrayList;
import java.util.Stack;

import org.mariuszgromada.janetutils.ArrayX;
import org.mariuszgromada.janetutils.ComputingTime;
import org.mariuszgromada.janetutils.ConsoleX;
import org.mariuszgromada.janetutils.DateTimeX;
import org.mariuszgromada.janetutils.RandomX;
import org.mariuszgromada.janetutils.StringX;

/**
 * Regression tests for public API provided by Janet-Sudoku.
 *
 * @author         <b>Mariusz Gromada</b><br/>
 *                 <a href="mailto:mariusz.gromada@mathspace.pl">mariusz.gromada@mathspace.pl</a><br>
 *                 <a href="http://mathspace.pl/" target="_blank">MathSpace.pl</a><br>
 *                 <a href="http://mathparser.org/" target="_blank">MathParser.org - mXparser project page</a><br>
 *                 <a href="http://github.com/mariuszgromada/java-utils" target="_blank">Java-Utils on GitHub</a><br>
 *                 <a href="http://github.com/mariuszgromada/MathParser.org-mXparser" target="_blank">mXparser on GitHub</a><br>
 *                 <a href="http://mariuszgromada.github.io/MathParser.org-mXparser/" target="_blank">mXparser on GitHub pages</a><br>
 *                 <a href="http://mxparser.sourceforge.net/" target="_blank">mXparser on SourceForge</a><br>
 *                 <a href="http://bitbucket.org/mariuszgromada/mxparser/" target="_blank">mXparser on Bitbucket</a><br>
 *                 <a href="http://mxparser.codeplex.com/" target="_blank">mXparser on CodePlex</a><br>
 *
 * @version        1.0.0
 *
 */
public class JanetUtilsTests {
	public static int start() {
		int numberOfTests = UtilsTests.NUMBER_OF_TESTS;
		int resultsError = 0;
		int resultsOk = 0;
		ComputingTime ct = new ComputingTime();
		ct.start();
		boolean[] testResults = new boolean[UtilsTests.NUMBER_OF_TESTS];
		for (int t = 0; t < numberOfTests; t++) {
			testResults[t] = UtilsTests.runTest(t);
			if (testResults[t] == true)
				resultsOk++;
			else
				resultsError++;
		}
		ct.end();
		ConsoleX.println("=============================================================");
		ConsoleX.println("Number of test: " + numberOfTests + ", OK: " + resultsOk + ", ERRORS: " + resultsError + ", computing time: " + ct.getComputingTime());
		for (int t = 0; t < numberOfTests; t++)
			if (testResults[t] == false)
				ConsoleX.println("ERROR: " + t);
		ConsoleX.println("=============================================================");
		return resultsError;
	}
	/**
	 * Runs regression tests
	 * @param args     Optional first argument with threads number,
	 *                 otherwise default threads number is used.
	 */
	public static void main(String[] args) {
		start();
	}
}
/**
 * Regression tests definition.
 */
final class UtilsTests {
	/**
	 * Test scenario implementation.
	 * @param testId        Test id.
	 * @return              True is test successful, otherwise false.
	 */
	static boolean runTest(int testId) {
		boolean testResult = true;
		String testDesc = "", resultDesc = "";
		switch(testId) {
		case 0:
			testDesc = "ArrayX.toArray(List)";
			{
				ArrayList<String> al = new ArrayList<String>();
				al.add("0");
				al.add("1");
				al.add("2");
				al.add("3");
				al.add("4");
				String[] as = ArrayX.toArray(String.class, al);
				if (as.length != 5) {
					testResult = false;
				} else if ( 
							(as[0].equals("0") == false) ||
							(as[1].equals("1") == false) ||
							(as[2].equals("2") == false) ||
							(as[3].equals("3") == false) ||
							(as[4].equals("4") == false)
						) {
					testResult = false;
				}
				if (testResult == true) {
					resultDesc = "Expecting equal - are equal.";
				} else {
					resultDesc = "Expecting equal - are not equal.";
				}
			}
			break;
		case 1:
			testDesc = "ArrayX.toArray(Stack)";
			{
				Stack<String> st = new Stack<String>();
				st.push("0");
				st.push("1");
				st.push("2");
				st.push("3");
				st.push("4");
				String[] as = ArrayX.toArray(String.class, st);
				if (as.length != 5) {
					testResult = false;
				} else if ( 
							(as[0].equals("0") == false) ||
							(as[1].equals("1") == false) ||
							(as[2].equals("2") == false) ||
							(as[3].equals("3") == false) ||
							(as[4].equals("4") == false)
						) {
					testResult = false;
				}
				if (testResult == true) {
					resultDesc = "Expecting equal - are equal.";
				} else {
					resultDesc = "Expecting equal - are not equal.";
				}
			}
			break;
		case 2:
			testDesc = "ComputingTime";
			{
				ComputingTime ct = new ComputingTime();
				ct.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ct.end();
				if ( Math.abs(ct.getComputingTimeMs()-1000) > 1 )
					testResult = false;
				if ( Math.abs(ct.getComputingTime()-1.0) > 0.001 )
					testResult = false;
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - is equal.";
			} else {
				resultDesc = "Expecting equal - is not equal.";
			}
			break;
		case 3:
			testDesc = "DateTimeX.getCurrDateTimeStr()";
			{
				String dt = DateTimeX.getCurrDateTimeStr();
				if (dt == null) testResult = false;
				if (dt.length() != 19) testResult = false;
				if (StringX.regexMatch(dt, StringX.PATTERN_DATE_TIME_YYYYMMDDHHMMSS) == false) testResult = false;					
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - is equal.";
			} else {
				resultDesc = "Expecting equal - is not equal.";
			}
			break;
		case 4:
			testDesc = "DateTimeX.currentTimeMillis()";
			{
				long startTime = DateTimeX.currentTimeMillis();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				long endTime = DateTimeX.currentTimeMillis();
				long delta = endTime - startTime;
				if ( Math.abs(delta - 1000) > 1 )
					testResult = false;
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - is equal.";
			} else {
				resultDesc = "Expecting equal - is not equal.";
			}
			break;
		case 5:
			testDesc = "RandomX.randomIndex()";
			{
				for (int i = 0; i < 100000; i++) {
					int r = RandomX.randomIndex(20);
					if ( (r < 0) || (r > 19) ) {
						testResult = false;
						break;
					}
				}
			}
			if (testResult == true) {
				resultDesc = "Expecting between 0 and 19 - is between 0 and 19.";
			} else {
				resultDesc = "Expecting between 0 and 19 - found other value.";
			}
			break;
		case 6:
			testDesc = "RandomX.randomNumber()";
			{
				for (int i = 0; i < 100000; i++) {
					int r = RandomX.randomNumber(20);
					if ( (r < 1) || (r > 20) ) {
						testResult = false;
						break;
					}
				}
			}
			if (testResult == true) {
				resultDesc = "Expecting between 1 and 20 - is between 1 and 20.";
			} else {
				resultDesc = "Expecting between 1 and 20 - found other value.";
			}
			break;
		case 7:
			testDesc = "StringX.randomString()";
			{
				for (int i = 0; i < 10; i++) {
					String s = StringX.randomString(20);
					ConsoleX.println(s);
					if (s.length() != 20) {
						testResult = false;
						break;
					}
				}
			}
			if (testResult == true) {
				resultDesc = "Expecting length 20 - is 20.";
			} else {
				resultDesc = "Expecting length 20 - is not 20.";
			}
			break;
		case 8:
			testDesc = "ArrayX.sort(boolean[])";
			{
				boolean[] a = {true, false, false, true, true, false, true};
				boolean[] b = {false, false, false, true, true, true, true};
				ArrayX.sort(a);
				if (ArrayX.equals(a, b) == false)
					testResult = false;
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - are equal";
			} else {
				resultDesc = "Expecting equal - are not equal";
			}
			break;
		case 9:
			testDesc = "ArrayX.sort(char[])";
			{
				char[] a = {'b', 'a', 'd', 'c', 'f', 'g', 'e'};
				char[] b = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
				ArrayX.sort(a);
				if (ArrayX.equals(a, b) == false)
					testResult = false;
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - are equal";
			} else {
				resultDesc = "Expecting equal - are not equal";
			}
			break;
		case 10:
			testDesc = "ArrayX.sort(String[])";
			{
				String[] a = {"Ola", "Zosia", "Ala", "Ela", "Gosia", "Basia", "Halina"};
				String[] b = {"Ala", "Basia", "Ela", "Gosia",  "Halina", "Ola", "Zosia"};
				ArrayX.sort(a);
				if (ArrayX.equals(a, b) == false)
					testResult = false;
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - are equal";
			} else {
				resultDesc = "Expecting equal - are not equal";
			}
			break;
		case 11:
			testDesc = "ArrayX.sort(byte[])";
			{
				byte[] a = {6, 2, 4, 3, 0, 1, 5};
				byte[] b = {0, 1, 2, 3, 4, 5, 6};
				ArrayX.sort(a);
				if (ArrayX.equals(a, b) == false)
					testResult = false;
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - are equal";
			} else {
				resultDesc = "Expecting equal - are not equal";
			}
			break;
		case 12:
			testDesc = "ArrayX.sort(short[])";
			{
				short[] a = {6, 2, 4, 3, 0, 1, 5};
				short[] b = {0, 1, 2, 3, 4, 5, 6};
				ArrayX.sort(a);
				if (ArrayX.equals(a, b) == false)
					testResult = false;
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - are equal";
			} else {
				resultDesc = "Expecting equal - are not equal";
			}
			break;
		case 13:
			testDesc = "ArrayX.sort(int[])";
			{
				int[] a = {6, 2, 4, 3, 0, 1, 5};
				int[] b = {0, 1, 2, 3, 4, 5, 6};
				ArrayX.sort(a);
				if (ArrayX.equals(a, b) == false)
					testResult = false;
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - are equal";
			} else {
				resultDesc = "Expecting equal - are not equal";
			}
			break;
		case 14:
			testDesc = "ArrayX.sort(long[])";
			{
				long[] a = {6, 2, 4, 3, 0, 1, 5};
				long[] b = {0, 1, 2, 3, 4, 5, 6};
				ArrayX.sort(a);
				if (ArrayX.equals(a, b) == false)
					testResult = false;
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - are equal";
			} else {
				resultDesc = "Expecting equal - are not equal";
			}
			break;
		case 15:
			testDesc = "ArrayX.sort(float[])";
			{
				float[] a = {6, 2, 4, 3, 0, 1, 5};
				float[] b = {0, 1, 2, 3, 4, 5, 6};
				ArrayX.sort(a);
				if (ArrayX.equals(a, b) == false)
					testResult = false;
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - are equal";
			} else {
				resultDesc = "Expecting equal - are not equal";
			}
			break;
		case 16:
			testDesc = "ArrayX.sort(double[])";
			{
				double[] a = {6, 2, 4, 3, 0, 1, 5};
				double[] b = {0, 1, 2, 3, 4, 5, 6};
				ArrayX.sort(a);
				if (ArrayX.equals(a, b) == false)
					testResult = false;
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - are equal";
			} else {
				resultDesc = "Expecting equal - are not equal";
			}
			break;
		case 17:
			testDesc = "ArrayX.swapElements(boolean[], int, int)";
			{
				boolean[] a = {true, false, false, true, true, false, true};
				boolean[] b = {true, false, true, false, true, false, true};
				ArrayX.swapElements(a, 2, 3);
				if (ArrayX.equals(a, b) == false)
					testResult = false;
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - are equal";
			} else {
				resultDesc = "Expecting equal - are not equal";
			}
			break;
		case 18:
			testDesc = "ArrayX.swapElements(char[], int, int)";
			{
				char[] a = {'b', 'a', 'd', 'c', 'f', 'g', 'e'};
				char[] b = {'b', 'a', 'c', 'd', 'f', 'g', 'e'};
				ArrayX.swapElements(a, 2, 3);
				if (ArrayX.equals(a, b) == false)
					testResult = false;
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - are equal";
			} else {
				resultDesc = "Expecting equal - are not equal";
			}
			break;
		case 19:
			testDesc = "ArrayX.swapElements(String[], int, int)";
			{
				String[] a = {"Ola", "Zosia", "Ala", "Ela", "Gosia", "Basia", "Halina"};
				String[] b = {"Ola", "Zosia", "Ela", "Ala", "Gosia", "Basia", "Halina"};
				ArrayX.swapElements(a, 2, 3);
				if (ArrayX.equals(a, b) == false)
					testResult = false;
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - are equal";
			} else {
				resultDesc = "Expecting equal - are not equal";
			}
			break;
		case 20:
			testDesc = "ArrayX.swapElements(byte[], int, int)";
			{
				byte[] a = {6, 2, 4, 3, 0, 1, 5};
				byte[] b = {6, 2, 3, 4, 0, 1, 5};
				ArrayX.swapElements(a, 2, 3);
				if (ArrayX.equals(a, b) == false)
					testResult = false;
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - are equal";
			} else {
				resultDesc = "Expecting equal - are not equal";
			}
			break;
		case 21:
			testDesc = "ArrayX.swapElements(short[], int, int)";
			{
				short[] a = {6, 2, 4, 3, 0, 1, 5};
				short[] b = {6, 2, 3, 4, 0, 1, 5};
				ArrayX.swapElements(a, 2, 3);
				if (ArrayX.equals(a, b) == false)
					testResult = false;
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - are equal";
			} else {
				resultDesc = "Expecting equal - are not equal";
			}
			break;
		case 22:
			testDesc = "ArrayX.swapElements(int[], int, int)";
			{
				int[] a = {6, 2, 4, 3, 0, 1, 5};
				int[] b = {6, 2, 3, 4, 0, 1, 5};
				ArrayX.swapElements(a, 2, 3);
				if (ArrayX.equals(a, b) == false)
					testResult = false;
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - are equal";
			} else {
				resultDesc = "Expecting equal - are not equal";
			}
			break;
		case 23:
			testDesc = "ArrayX.swapElements(long[], int, int)";
			{
				long[] a = {6, 2, 4, 3, 0, 1, 5};
				long[] b = {6, 2, 3, 4, 0, 1, 5};
				ArrayX.swapElements(a, 2, 3);
				if (ArrayX.equals(a, b) == false)
					testResult = false;
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - are equal";
			} else {
				resultDesc = "Expecting equal - are not equal";
			}
			break;
		case 24:
			testDesc = "ArrayX.swapElements(float[], int, int)";
			{
				float[] a = {6, 2, 4, 3, 0, 1, 5};
				float[] b = {6, 2, 3, 4, 0, 1, 5};
				ArrayX.swapElements(a, 2, 3);
				if (ArrayX.equals(a, b) == false)
					testResult = false;
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - are equal";
			} else {
				resultDesc = "Expecting equal - are not equal";
			}
			break;
		case 25:
			testDesc = "ArrayX.swapElements(double[], int, int)";
			{
				double[] a = {6, 2, 4, 3, 0, 1, 5};
				double[] b = {6, 2, 3, 4, 0, 1, 5};
				ArrayX.swapElements(a, 2, 3);
				if (ArrayX.equals(a, b) == false)
					testResult = false;
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - are equal";
			} else {
				resultDesc = "Expecting equal - are not equal";
			}
			break;
		case 26:
			testDesc = "ArrayX.sort(boolean[], int, int)";
			{
				boolean[] a = {true, false, false, true, true, false, true};
				boolean[] b = {true, false, false, false, true, true, true};
				ArrayX.sort(a, 2, 5);
				if (ArrayX.equals(a, b) == false)
					testResult = false;
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - are equal";
			} else {
				resultDesc = "Expecting equal - are not equal";
			}
			break;
		case 27:
			testDesc = "ArrayX.sort(char[], int, int)";
			{
				char[] a = {'b', 'a', 'd', 'c', 'f', 'g', 'e'};
				char[] b = {'b', 'a', 'c', 'd', 'f', 'g', 'e'};
				ArrayX.sort(a, 2, 5);
				if (ArrayX.equals(a, b) == false)
					testResult = false;
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - are equal";
			} else {
				resultDesc = "Expecting equal - are not equal";
			}
			break;
		case 28:
			testDesc = "ArrayX.sort(String[], int, int)";
			{
				String[] a = {"Ola", "Zosia", "Ala", "Ela", "Gosia", "Basia", "Halina"};
				String[] b = {"Ola", "Zosia", "Ala", "Basia", "Ela", "Gosia", "Halina"};
				ArrayX.sort(a, 2, 5);
				if (ArrayX.equals(a, b) == false)
					testResult = false;
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - are equal";
			} else {
				resultDesc = "Expecting equal - are not equal";
			}
			break;
		case 29:
			testDesc = "ArrayX.sort(byte[], int, int)";
			{
				byte[] a = {6, 2, 4, 3, 0, 1, 5};
				byte[] b = {6, 2, 0, 1, 3, 4, 5};
				ArrayX.sort(a, 2, 5);
				if (ArrayX.equals(a, b) == false)
					testResult = false;
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - are equal";
			} else {
				resultDesc = "Expecting equal - are not equal";
			}
			break;
		case 30:
			testDesc = "ArrayX.sort(short[], int, int)";
			{
				short[] a = {6, 2, 4, 3, 0, 1, 5};
				short[] b = {6, 2, 0, 1, 3, 4, 5};
				ArrayX.sort(a, 2, 5);
				if (ArrayX.equals(a, b) == false)
					testResult = false;
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - are equal";
			} else {
				resultDesc = "Expecting equal - are not equal";
			}
			break;
		case 31:
			testDesc = "ArrayX.sort(int[], int, int)";
			{
				int[] a = {6, 2, 4, 3, 0, 1, 5};
				int[] b = {6, 2, 0, 1, 3, 4, 5};
				ArrayX.sort(a, 2, 5);
				if (ArrayX.equals(a, b) == false)
					testResult = false;
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - are equal";
			} else {
				resultDesc = "Expecting equal - are not equal";
			}
			break;
		case 32:
			testDesc = "ArrayX.sort(long[], int, int)";
			{
				long[] a = {6, 2, 4, 3, 0, 1, 5};
				long[] b = {6, 2, 0, 1, 3, 4, 5};
				ArrayX.sort(a, 2, 5);
				if (ArrayX.equals(a, b) == false)
					testResult = false;
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - are equal";
			} else {
				resultDesc = "Expecting equal - are not equal";
			}
			break;
		case 33:
			testDesc = "ArrayX.sort(float[], int, int)";
			{
				float[] a = {6, 2, 4, 3, 0, 1, 5};
				float[] b = {6, 2, 0, 1, 3, 4, 5};
				ArrayX.sort(a, 2, 5);
				if (ArrayX.equals(a, b) == false)
					testResult = false;
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - are equal";
			} else {
				resultDesc = "Expecting equal - are not equal";
			}
			break;
		case 34:
			testDesc = "ArrayX.sort(double[], int, int)";
			{
				double[] a = {6, 2, 4, 3, 0, 1, 5};
				double[] b = {6, 2, 0, 1, 3, 4, 5};
				ArrayX.sort(a, 2, 5);
				if (ArrayX.equals(a, b) == false)
					testResult = false;
			}
			if (testResult == true) {
				resultDesc = "Expecting equal - are equal";
			} else {
				resultDesc = "Expecting equal - are not equal";
			}
			break;
		}
		if (testResult == true)
			ConsoleX.println("(JanetUtilsTests) [Test: " + testId + "] " + testDesc + " " + resultDesc + " >>> result: OK");
		else
			ConsoleX.println("(JanetUtilsTests) [Test: " + testId + "] " + testDesc + " " + resultDesc + " >>> result: ERROR");
		return testResult;
	}
	/**
	 * Number of regression tests;
	 */
	static final int NUMBER_OF_TESTS = 34;
}