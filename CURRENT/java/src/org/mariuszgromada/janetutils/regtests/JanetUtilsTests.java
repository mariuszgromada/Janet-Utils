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
	static final int NUMBER_OF_TESTS = 3;
}