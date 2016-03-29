/*
 * @(#)ArrayX.java        1.0.0    2016-01-18
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
package org.mariuszgromada.janetutils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;
/**
 * Class implements general purpose methods
 * helping to work with arrays, array lists, etc.
 *
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
 */
public final class ArrayX {
	public static final String CLASS_NAME = "ArrayX";
	/**
	 * Converts generic ArraList to array
	 *
	 * @param componentType    Class type, i.e. if ArrayList<String> is converted
	 *                         then componentType = String.class
	 * @param arrayList        ArrayList of <T> to be converted to T[]
	 *
	 * @return                 Array T[] including elements of ArrayList<T>
	 */
	public static final <T> T[] toArray(Class<T> componentType, ArrayList<T> arrayList) {
		final String METHOD_NAME = "toArray(Class<T> componentType, ArrayList<T> arrayList)";
		if (componentType == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "componentType = null");
			return null;
		}
		if (arrayList == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "arrayList = null");
			return null;
		}
		if (arrayList.size() == 0) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "arrayList.size() = 0");
		}
		int n = arrayList.size();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "arrayList.size() = " + n + ", componentType = " + componentType.getName());
		@SuppressWarnings("unchecked")
		T[] array = (T[])Array.newInstance(componentType, n);
		for (int i = 0; i < n; i++)
			array[i] = arrayList.get(i);
		return array;
	}
	/**
	 * Converts generic Stack to array
	 *
	 * @param componentType    Class type, i.e. if Stack<String> is converted
	 *                         then componentType = String.class
	 * @param stack            Stack of <T> to be converted to T[]
	 *
	 * @return                 Array T[] including elements of Stack<T>
	 */
	public static final <T> T[] toArray(Class<T> componentType, Stack<T> stack) {
		final String METHOD_NAME = "toArray(Class<T> componentType, Stack<T> stack)";
		if (componentType == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "componentType = null");
			return null;
		}
		if (stack == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "stack = null");
			return null;
		}
		if (stack.size() == 0) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "stack.size() = 0");
		}
		int n = stack.size();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "stack.size() = " + n + ", componentType = " + componentType.getName());
		@SuppressWarnings("unchecked")
		T[] array = (T[])Array.newInstance(componentType, n);
		for (int i = 0; i < n; i++)
			array[i] = stack.get(i);
		return array;
	}
	/**
	 * Quick sort of the array.
	 * @param fromIndex    Starting left index.
	 * @param toIndex    Starting right index.
	 */
	private static final void quickSort(byte[] array, int fromIndex, int toIndex) {
		int i = fromIndex;
		int j = toIndex;
		byte x;
		byte w;
		x = array[(fromIndex+toIndex)/2];
		do {
			while ( array[i] < x )
				i++;
			while ( array[j] > x )
				j--;
			if (i<=j)
			{
				w = array[i];
				array[i] = array[j];
				array[j] = w;
				i++;
				j--;
			}
		} while (i <= j);
		if (fromIndex < j)
			quickSort(array, fromIndex,j);
		if (i < toIndex)
			quickSort(array, i,toIndex);
	}
	public static final int sort(byte[] array, int fromIndex, int toIndex) {
		final String METHOD_NAME = "sort(byte[] array, int fromIndex, int toIndex)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return ErrorCodes.CODE_NULL_PARAMETER;
		}
		if (array.length < 2) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "array.length < 2");
			return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		}
		if ( (fromIndex < 0) || (fromIndex > array.length -1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "Incorrect fromIndex: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if ( (toIndex < 0) || (toIndex > array.length -1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "Incorrect toIndex: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if (fromIndex == toIndex) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "Equal fromIndex and toIndex: fromIndex = " + fromIndex + ", toIndex = " + toIndex);
			return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		}
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting started: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		quickSort(array, fromIndex, toIndex);
		pt.end();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting finished: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex, pt.getProcessingTime());
		return ErrorCodes.CODE_NO_ERRORS;
	}
	public static final int sort(byte[] array) {
		final String METHOD_NAME = "sort(byte[] array)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return ErrorCodes.CODE_NULL_PARAMETER;
		}
		if (array.length < 2) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "array.length < 2");
			return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		}
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting started: array.length = " + array.length);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		quickSort(array, 0, array.length - 1);
		pt.end();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting finished: array.length = " + array.length, pt.getProcessingTime());
		return ErrorCodes.CODE_NO_ERRORS;
	}
	/**
	 * Quick sort of the array.
	 * @param fromIndex    Starting left index.
	 * @param toIndex    Starting right index.
	 */
	private static final void quickSort(short[] array, int fromIndex, int toIndex) {
		int i = fromIndex;
		int j = toIndex;
		short x;
		short w;
		x = array[(fromIndex+toIndex)/2];
		do {
			while ( array[i] < x )
				i++;
			while ( array[j] > x )
				j--;
			if (i<=j)
			{
				w = array[i];
				array[i] = array[j];
				array[j] = w;
				i++;
				j--;
			}
		} while (i <= j);
		if (fromIndex < j)
			quickSort(array, fromIndex,j);
		if (i < toIndex)
			quickSort(array, i,toIndex);
	}
	public static final int sort(short[] array, int fromIndex, int toIndex) {
		final String METHOD_NAME = "sort(short[] array, int fromIndex, int toIndex)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return ErrorCodes.CODE_NULL_PARAMETER;
		}
		if (array.length < 2) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "array.length < 2");
			return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		}
		if ( (fromIndex < 0) || (fromIndex > array.length -1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "Incorrect fromIndex: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if ( (toIndex < 0) || (toIndex > array.length -1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "Incorrect toIndex: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if (fromIndex == toIndex) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "Equal fromIndex and toIndex: fromIndex = " + fromIndex + ", toIndex = " + toIndex);
			return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		}
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting started: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		quickSort(array, fromIndex, toIndex);
		pt.end();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting finished: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex, pt.getProcessingTime());
		return ErrorCodes.CODE_NO_ERRORS;
	}
	public static final int sort(short[] array) {
		final String METHOD_NAME = "sort(short[] array)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return ErrorCodes.CODE_NULL_PARAMETER;
		}
		if (array.length < 2) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "array.length < 2");
			return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		}
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting started: array.length = " + array.length);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		quickSort(array, 0, array.length - 1);
		pt.end();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting finished: array.length = " + array.length, pt.getProcessingTime());
		return ErrorCodes.CODE_NO_ERRORS;
	}
	/**
	 * Quick sort of the array.
	 * @param fromIndex    Starting left index.
	 * @param toIndex    Starting right index.
	 */
	private static final void quickSort(int[] array, int fromIndex, int toIndex) {
		int i = fromIndex;
		int j = toIndex;
		int x;
		int w;
		x = array[(fromIndex+toIndex)/2];
		do {
			while ( array[i] < x )
				i++;
			while ( array[j] > x )
				j--;
			if (i<=j)
			{
				w = array[i];
				array[i] = array[j];
				array[j] = w;
				i++;
				j--;
			}
		} while (i <= j);
		if (fromIndex < j)
			quickSort(array, fromIndex,j);
		if (i < toIndex)
			quickSort(array, i,toIndex);
	}
	public static final int sort(int[] array, int fromIndex, int toIndex) {
		final String METHOD_NAME = "sort(int[] array, int fromIndex, int toIndex)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return ErrorCodes.CODE_NULL_PARAMETER;
		}
		if (array.length < 2) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "array.length < 2");
			return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		}
		if ( (fromIndex < 0) || (fromIndex > array.length -1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "Incorrect fromIndex: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if ( (toIndex < 0) || (toIndex > array.length -1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "Incorrect toIndex: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if (fromIndex == toIndex) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "Equal fromIndex and toIndex: fromIndex = " + fromIndex + ", toIndex = " + toIndex);
			return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		}
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting started: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		quickSort(array, fromIndex, toIndex);
		pt.end();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting finished: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex, pt.getProcessingTime());
		return ErrorCodes.CODE_NO_ERRORS;
	}
	public static final int sort(int[] array) {
		final String METHOD_NAME = "sort(int[] array)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return ErrorCodes.CODE_NULL_PARAMETER;
		}
		if (array.length < 2) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "array.length < 2");
			return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		}
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting started: array.length = " + array.length);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		quickSort(array, 0, array.length - 1);
		pt.end();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting finished: array.length = " + array.length, pt.getProcessingTime());
		return ErrorCodes.CODE_NO_ERRORS;
	}
	/**
	 * Quick sort of the array.
	 * @param fromIndex    Starting left index.
	 * @param toIndex    Starting right index.
	 */
	private static final void quickSort(long[] array, int fromIndex, int toIndex) {
		int i = fromIndex;
		int j = toIndex;
		long x;
		long w;
		x = array[(fromIndex+toIndex)/2];
		do {
			while ( array[i] < x )
				i++;
			while ( array[j] > x )
				j--;
			if (i<=j)
			{
				w = array[i];
				array[i] = array[j];
				array[j] = w;
				i++;
				j--;
			}
		} while (i <= j);
		if (fromIndex < j)
			quickSort(array, fromIndex,j);
		if (i < toIndex)
			quickSort(array, i,toIndex);
	}
	public static final int sort(long[] array, int fromIndex, int toIndex) {
		final String METHOD_NAME = "sort(long[] array, int fromIndex, int toIndex)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return ErrorCodes.CODE_NULL_PARAMETER;
		}
		if (array.length < 2) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "array.length < 2");
			return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		}
		if ( (fromIndex < 0) || (fromIndex > array.length -1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "Incorrect fromIndex: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if ( (toIndex < 0) || (toIndex > array.length -1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "Incorrect toIndex: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if (fromIndex == toIndex) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "Equal fromIndex and toIndex: fromIndex = " + fromIndex + ", toIndex = " + toIndex);
			return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		}
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting started: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		quickSort(array, fromIndex, toIndex);
		pt.end();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting finished: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex, pt.getProcessingTime());
		return ErrorCodes.CODE_NO_ERRORS;
	}
	public static final int sort(long[] array) {
		final String METHOD_NAME = "sort(long[] array)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return ErrorCodes.CODE_NULL_PARAMETER;
		}
		if (array.length < 2) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "array.length < 2");
			return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		}
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting started: array.length = " + array.length);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		quickSort(array, 0, array.length - 1);
		pt.end();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting finished: array.length = " + array.length, pt.getProcessingTime());
		return ErrorCodes.CODE_NO_ERRORS;
	}
	/**
	 * Quick sort of the array.
	 * @param fromIndex    Starting left index.
	 * @param toIndex    Starting right index.
	 */
	private static final void quickSort(double[] array, int fromIndex, int toIndex) {
		int i = fromIndex;
		int j = toIndex;
		double x;
		double w;
		x = array[(fromIndex+toIndex)/2];
		do {
			while ( array[i] < x )
				i++;
			while ( array[j] > x )
				j--;
			if (i<=j)
			{
				w = array[i];
				array[i] = array[j];
				array[j] = w;
				i++;
				j--;
			}
		} while (i <= j);
		if (fromIndex < j)
			quickSort(array, fromIndex,j);
		if (i < toIndex)
			quickSort(array, i,toIndex);
	}
	public static final int sort(double[] array, int fromIndex, int toIndex) {
		final String METHOD_NAME = "sort(double[] array, int fromIndex, int toIndex)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return ErrorCodes.CODE_NULL_PARAMETER;
		}
		if (array.length < 2) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "array.length < 2");
			return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		}
		if ( (fromIndex < 0) || (fromIndex > array.length -1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "Incorrect fromIndex: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if ( (toIndex < 0) || (toIndex > array.length -1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "Incorrect toIndex: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if (fromIndex == toIndex) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "Equal fromIndex and toIndex: fromIndex = " + fromIndex + ", toIndex = " + toIndex);
			return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		}
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting started: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		quickSort(array, fromIndex, toIndex);
		pt.end();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting finished: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex, pt.getProcessingTime());
		return ErrorCodes.CODE_NO_ERRORS;
	}
	public static final int sort(double[] array) {
		final String METHOD_NAME = "sort(double[] array)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return ErrorCodes.CODE_NULL_PARAMETER;
		}
		if (array.length < 2) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "array.length < 2");
			return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		}
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting started: array.length = " + array.length);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		quickSort(array, 0, array.length - 1);
		pt.end();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting finished: array.length = " + array.length, pt.getProcessingTime());
		return ErrorCodes.CODE_NO_ERRORS;
	}
	/**
	 * Quick sort of the array.
	 * @param fromIndex    Starting left index.
	 * @param toIndex    Starting right index.
	 */
	private static final void quickSort(float[] array, int fromIndex, int toIndex) {
		int i = fromIndex;
		int j = toIndex;
		float x;
		float w;
		x = array[(fromIndex+toIndex)/2];
		do {
			while ( array[i] < x )
				i++;
			while ( array[j] > x )
				j--;
			if (i<=j)
			{
				w = array[i];
				array[i] = array[j];
				array[j] = w;
				i++;
				j--;
			}
		} while (i <= j);
		if (fromIndex < j)
			quickSort(array, fromIndex,j);
		if (i < toIndex)
			quickSort(array, i,toIndex);
	}
	public static final int sort(float[] array, int fromIndex, int toIndex) {
		final String METHOD_NAME = "sort(float[] array, int fromIndex, int toIndex)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return ErrorCodes.CODE_NULL_PARAMETER;
		}
		if (array.length < 2) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "array.length < 2");
			return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		}
		if ( (fromIndex < 0) || (fromIndex > array.length -1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "Incorrect fromIndex: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if ( (toIndex < 0) || (toIndex > array.length -1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "Incorrect toIndex: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if (fromIndex == toIndex) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "Equal fromIndex and toIndex: fromIndex = " + fromIndex + ", toIndex = " + toIndex);
			return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		}
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting started: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		quickSort(array, fromIndex, toIndex);
		pt.end();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting finished: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex, pt.getProcessingTime());
		return ErrorCodes.CODE_NO_ERRORS;
	}
	public static final int sort(float[] array) {
		final String METHOD_NAME = "sort(float[] array)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return ErrorCodes.CODE_NULL_PARAMETER;
		}
		if (array.length < 2) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "array.length < 2");
			return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		}
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting started: array.length = " + array.length);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		quickSort(array, 0, array.length - 1);
		pt.end();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting finished: array.length = " + array.length, pt.getProcessingTime());
		return ErrorCodes.CODE_NO_ERRORS;
	}
	/**
	 * Quick sort of the array.
	 * @param fromIndex    Starting left index.
	 * @param toIndex    Starting right index.
	 */
	private static final void quickSort(boolean[] array, int fromIndex, int toIndex) {
		int i = fromIndex;
		int j = toIndex;
		boolean x;
		boolean w;
		x = array[(fromIndex+toIndex)/2];
		do {
			while ( (array[i] == false) && (x == true) )
				i++;
			while ( (array[j] == true) && (x == false) )
				j--;
			if (i<=j)
			{
				w = array[i];
				array[i] = array[j];
				array[j] = w;
				i++;
				j--;
			}
		} while (i <= j);
		if (fromIndex < j)
			quickSort(array, fromIndex,j);
		if (i < toIndex)
			quickSort(array, i,toIndex);
	}
	public static final int sort(boolean[] array, int fromIndex, int toIndex) {
		final String METHOD_NAME = "sort(boolean[] array, int fromIndex, int toIndex)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return ErrorCodes.CODE_NULL_PARAMETER;
		}
		if (array.length < 2) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "array.length < 2");
			return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		}
		if ( (fromIndex < 0) || (fromIndex > array.length -1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "Incorrect fromIndex: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if ( (toIndex < 0) || (toIndex > array.length -1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "Incorrect toIndex: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if (fromIndex == toIndex) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "Equal fromIndex and toIndex: fromIndex = " + fromIndex + ", toIndex = " + toIndex);
			return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		}
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting started: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		quickSort(array, fromIndex, toIndex);
		pt.end();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting finished: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex, pt.getProcessingTime());
		return ErrorCodes.CODE_NO_ERRORS;
	}
	public static final int sort(boolean[] array) {
		final String METHOD_NAME = "sort(boolean[] array)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return ErrorCodes.CODE_NULL_PARAMETER;
		}
		if (array.length < 2) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "array.length < 2");
			return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		}
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting started: array.length = " + array.length);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		quickSort(array, 0, array.length - 1);
		pt.end();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting finished: array.length = " + array.length, pt.getProcessingTime());
		return ErrorCodes.CODE_NO_ERRORS;
	}
	/**
	 * Quick sort of the array.
	 * @param fromIndex    Starting left index.
	 * @param toIndex    Starting right index.
	 */
	private static final void quickSort(char[] array, int fromIndex, int toIndex) {
		int i = fromIndex;
		int j = toIndex;
		char x;
		char w;
		x = array[(fromIndex+toIndex)/2];
		do {
			while ( array[i] < x )
				i++;
			while ( array[j] > x )
				j--;
			if (i<=j)
			{
				w = array[i];
				array[i] = array[j];
				array[j] = w;
				i++;
				j--;
			}
		} while (i <= j);
		if (fromIndex < j)
			quickSort(array, fromIndex,j);
		if (i < toIndex)
			quickSort(array, i,toIndex);
	}
	public static final int sort(char[] array, int fromIndex, int toIndex) {
		final String METHOD_NAME = "sort(char[] array, int fromIndex, int toIndex)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return ErrorCodes.CODE_NULL_PARAMETER;
		}
		if (array.length < 2) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "array.length < 2");
			return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		}
		if ( (fromIndex < 0) || (fromIndex > array.length -1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "Incorrect fromIndex: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if ( (toIndex < 0) || (toIndex > array.length -1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "Incorrect toIndex: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if (fromIndex == toIndex) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "Equal fromIndex and toIndex: fromIndex = " + fromIndex + ", toIndex = " + toIndex);
			return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		}
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting started: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		quickSort(array, fromIndex, toIndex);
		pt.end();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting finished: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex, pt.getProcessingTime());
		return ErrorCodes.CODE_NO_ERRORS;
	}
	public static final int sort(char[] array) {
		final String METHOD_NAME = "sort(char[] array)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return ErrorCodes.CODE_NULL_PARAMETER;
		}
		if (array.length < 2) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "array.length < 2");
			return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		}
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting started: array.length = " + array.length);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		quickSort(array, 0, array.length - 1);
		pt.end();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting finished: array.length = " + array.length, pt.getProcessingTime());
		return ErrorCodes.CODE_NO_ERRORS;
	}
	/**
	 * Quick sort of the array.
	 * @param fromIndex    Starting left index.
	 * @param toIndex    Starting right index.
	 */
	private static final void quickSort(String[] array, int fromIndex, int toIndex) {
		int i = fromIndex;
		int j = toIndex;
		String x;
		String w;
		x = array[(fromIndex+toIndex)/2];
		do {
			while ( array[i].compareTo(x) < 0 )
				i++;
			while ( array[j].compareTo(x) > 0 )
				j--;
			if (i<=j)
			{
				w = array[i];
				array[i] = array[j];
				array[j] = w;
				i++;
				j--;
			}
		} while (i <= j);
		if (fromIndex < j)
			quickSort(array, fromIndex,j);
		if (i < toIndex)
			quickSort(array, i,toIndex);
	}
	public static final int sort(String[] array, int fromIndex, int toIndex) {
		final String METHOD_NAME = "sort(String[] array, int fromIndex, int toIndex)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return ErrorCodes.CODE_NULL_PARAMETER;
		}
		if (array.length < 2) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "array.length < 2");
			return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		}
		if ( (fromIndex < 0) || (fromIndex > array.length -1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "Incorrect fromIndex: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if ( (toIndex < 0) || (toIndex > array.length -1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "Incorrect toIndex: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if (fromIndex == toIndex) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "Equal fromIndex and toIndex: fromIndex = " + fromIndex + ", toIndex = " + toIndex);
			return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		}
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting started: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		quickSort(array, fromIndex, toIndex);
		pt.end();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting finished: array.length = " + array.length + ", fromIndex = " + fromIndex + ", toIndex = " + toIndex, pt.getProcessingTime());
		return ErrorCodes.CODE_NO_ERRORS;
	}
	public static final int sort(String[] array) {
		final String METHOD_NAME = "sort(String[] array)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return ErrorCodes.CODE_NULL_PARAMETER;
		}
		if (array.length < 2) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "array.length < 2");
			return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		}
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting started: array.length = " + array.length);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		quickSort(array, 0, array.length - 1);
		pt.end();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Sorting finished: array.length = " + array.length, pt.getProcessingTime());
		return ErrorCodes.CODE_NO_ERRORS;
	}
	/**
	 * Given array copy.
	 * @param array   The array to be copied.
	 * @return        Given array copy;
	 */
	public static final boolean[] copy(boolean[] array) {
		final String METHOD_NAME = "copy(boolean[] array)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return null;
		}
		if (array.length == 0) if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "array.length = 0");
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Copying started: array.length = " + array.length);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		boolean[] arrayCopy = new boolean[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayCopy[i] = array[i];
		}
		pt.end();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Copying finished: array.length = " + array.length, pt.getProcessingTime());
		return arrayCopy;
	}
	/**
	 * Given array copy.
	 * @param array   The array to be copied.
	 * @return        Given array copy;
	 */
	public static final byte[] copy(byte[] array) {
		final String METHOD_NAME = "copy(byte[] array)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return null;
		}
		if (array.length == 0) if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "array.length = 0");
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Copying started: array.length = " + array.length);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		byte[] arrayCopy = new byte[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayCopy[i] = array[i];
		}
		pt.end();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Copying finished: array.length = " + array.length, pt.getProcessingTime());
		return arrayCopy;
	}
	/**
	 * Given array copy.
	 * @param array   The array to be copied.
	 * @return        Given array copy;
	 */
	public static final short[] copy(short[] array) {
		final String METHOD_NAME = "copy(short[] array)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return null;
		}
		if (array.length == 0) if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "array.length = 0");
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Copying started: array.length = " + array.length);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		short[] arrayCopy = new short[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayCopy[i] = array[i];
		}
		pt.end();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Copying finished: array.length = " + array.length, pt.getProcessingTime());
		return arrayCopy;
	}
	/**
	 * Given array copy.
	 * @param array   The array to be copied.
	 * @return        Given array copy;
	 */
	public static final int[] copy(int[] array) {
		final String METHOD_NAME = "copy(int[] array)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return null;
		}
		if (array.length == 0) if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "array.length = 0");
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Copying started: array.length = " + array.length);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		int[] arrayCopy = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayCopy[i] = array[i];
		}
		pt.end();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Copying finished: array.length = " + array.length, pt.getProcessingTime());
		return arrayCopy;
	}
	/**
	 * Given array copy.
	 * @param array   The array to be copied.
	 * @return        Given array copy;
	 */
	public static final long[] copy(long[] array) {
		final String METHOD_NAME = "copy(long[] array)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return null;
		}
		if (array.length == 0) if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "array.length = 0");
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Copying started: array.length = " + array.length);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		long[] arrayCopy = new long[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayCopy[i] = array[i];
		}
		pt.end();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Copying finished: array.length = " + array.length, pt.getProcessingTime());
		return arrayCopy;
	}
	/**
	 * Given array copy.
	 * @param array   The array to be copied.
	 * @return        Given array copy;
	 */
	public static final float[] copy(float[] array) {
		final String METHOD_NAME = "copy(float[] array)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return null;
		}
		if (array.length == 0) if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "array.length = 0");
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Copying started: array.length = " + array.length);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		float[] arrayCopy = new float[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayCopy[i] = array[i];
		}
		pt.end();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Copying finished: array.length = " + array.length, pt.getProcessingTime());
		return arrayCopy;
	}
	/**
	 * Given array copy.
	 * @param array   The array to be copied.
	 * @return        Given array copy;
	 */
	public static final double[] copy(double[] array) {
		final String METHOD_NAME = "copy(double[] array)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return null;
		}
		if (array.length == 0) if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "array.length = 0");
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Copying started: array.length = " + array.length);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		double[] arrayCopy = new double[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayCopy[i] = array[i];
		}
		pt.end();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Copying finished: array.length = " + array.length, pt.getProcessingTime());
		return arrayCopy;
	}
	/**
	 * Given array copy.
	 * @param array   The array to be copied.
	 * @return        Given array copy;
	 */
	public static final char[] copy(char[] array) {
		final String METHOD_NAME = "copy(char[] array)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return null;
		}
		if (array.length == 0) if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "array.length = 0");
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Copying started: array.length = " + array.length);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		char[] arrayCopy = new char[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayCopy[i] = array[i];
		}
		pt.end();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Copying finished: array.length = " + array.length, pt.getProcessingTime());
		return arrayCopy;
	}
	/**
	 * Given array copy.
	 * @param array   The array to be copied.
	 * @return        Given array copy;
	 */
	public static final String[] copy(String[] array) {
		final String METHOD_NAME = "copy(String[] array)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return null;
		}
		if (array.length == 0) if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NOTHING_TO_PROCESS, "array.length = 0");
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Copying started: array.length = " + array.length);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		String[] arrayCopy = new String[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayCopy[i] = new String(array[i]);
		}
		pt.end();
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Copying finished: array.length = " + array.length, pt.getProcessingTime());
		return arrayCopy;
	}
	/**
	 * Check whether array content is equal.
	 * @param array1   First array.
	 * @param array2   Second array.
	 * @return         True if array content is equal, otherwise false.
	 */
	public static final boolean equals(boolean[] array1, boolean[] array2) {
		final String METHOD_NAME = "equals(boolean[] array1, boolean[] array2)";
		if (array1 == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array1 = null");
			return false;
		}
		if (array2 == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array2 = null");
			return false;
		}
		if (array1.length != array2.length) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Difference in lengths: array1.length = " + array1.length + ", array2.length = " + array2.length);
			return false;
		}
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Equality test started: array1.length = " + array1.length + ", array2.length = " + array2.length);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		int n = array1.length;
		boolean result = true;
		int i;
		for (i = 0; i < n; i++) {
			if (array1[i] != array2[i]) {
				result = false;
				break;
			}
		}
		pt.end();
		if (JanetUtils.logInfo) {
			if (result == true)
				JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Equality test finished: array1.length = " + array1.length + ", array2.length = " + array2.length + ", result = " + result, pt.getProcessingTime());
			else
				JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Equality test finished: array1.length = " + array1.length + ", array2.length = " + array2.length + ", result = " + result + ", array1[" + i + "] = " + array1[i] + ", array2[" + i + "] = " + array2[i], pt.getProcessingTime());
		}
		return result;
	}
	/**
	 * Check whether array content is equal.
	 * @param array1   First array.
	 * @param array2   Second array.
	 * @return         True if array content is equal, otherwise false.
	 */
	public static final boolean equals(byte[] array1, byte[] array2) {
		final String METHOD_NAME = "equals(byte[] array1, boolean[] array2)";
		if (array1 == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array1 = null");
			return false;
		}
		if (array2 == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array2 = null");
			return false;
		}
		if (array1.length != array2.length) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Difference in lengths: array1.length = " + array1.length + ", array2.length = " + array2.length);
			return false;
		}
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Equality test started: array1.length = " + array1.length + ", array2.length = " + array2.length);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		int n = array1.length;
		boolean result = true;
		int i;
		for (i = 0; i < n; i++) {
			if (array1[i] != array2[i]) {
				result = false;
				break;
			}
		}
		pt.end();
		if (JanetUtils.logInfo) {
			if (result == true)
				JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Equality test finished: array1.length = " + array1.length + ", array2.length = " + array2.length + ", result = " + result, pt.getProcessingTime());
			else
				JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Equality test finished: array1.length = " + array1.length + ", array2.length = " + array2.length + ", result = " + result + ", array1[" + i + "] = " + array1[i] + ", array2[" + i + "] = " + array2[i], pt.getProcessingTime());
		}
		return result;
	}
	/**
	 * Check whether array content is equal.
	 * @param array1   First array.
	 * @param array2   Second array.
	 * @return         True if array content is equal, otherwise false.
	 */
	public static final boolean equals(short[] array1, short[] array2) {
		final String METHOD_NAME = "equals(short[] array1, boolean[] array2)";
		if (array1 == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array1 = null");
			return false;
		}
		if (array2 == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array2 = null");
			return false;
		}
		if (array1.length != array2.length) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Difference in lengths: array1.length = " + array1.length + ", array2.length = " + array2.length);
			return false;
		}
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Equality test started: array1.length = " + array1.length + ", array2.length = " + array2.length);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		int n = array1.length;
		boolean result = true;
		int i;
		for (i = 0; i < n; i++) {
			if (array1[i] != array2[i]) {
				result = false;
				break;
			}
		}
		pt.end();
		if (JanetUtils.logInfo) {
			if (result == true)
				JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Equality test finished: array1.length = " + array1.length + ", array2.length = " + array2.length + ", result = " + result, pt.getProcessingTime());
			else
				JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Equality test finished: array1.length = " + array1.length + ", array2.length = " + array2.length + ", result = " + result + ", array1[" + i + "] = " + array1[i] + ", array2[" + i + "] = " + array2[i], pt.getProcessingTime());
		}
		return result;
	}
	/**
	 * Check whether array content is equal.
	 * @param array1   First array.
	 * @param array2   Second array.
	 * @return         True if array content is equal, otherwise false.
	 */
	public static final boolean equals(int[] array1, int[] array2) {
		final String METHOD_NAME = "equals(int[] array1, boolean[] array2)";
		if (array1 == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array1 = null");
			return false;
		}
		if (array2 == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array2 = null");
			return false;
		}
		if (array1.length != array2.length) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Difference in lengths: array1.length = " + array1.length + ", array2.length = " + array2.length);
			return false;
		}
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Equality test started: array1.length = " + array1.length + ", array2.length = " + array2.length);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		int n = array1.length;
		boolean result = true;
		int i;
		for (i = 0; i < n; i++) {
			if (array1[i] != array2[i]) {
				result = false;
				break;
			}
		}
		pt.end();
		if (JanetUtils.logInfo) {
			if (result == true)
				JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Equality test finished: array1.length = " + array1.length + ", array2.length = " + array2.length + ", result = " + result, pt.getProcessingTime());
			else
				JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Equality test finished: array1.length = " + array1.length + ", array2.length = " + array2.length + ", result = " + result + ", array1[" + i + "] = " + array1[i] + ", array2[" + i + "] = " + array2[i], pt.getProcessingTime());
		}
		return result;
	}
	/**
	 * Check whether array content is equal.
	 * @param array1   First array.
	 * @param array2   Second array.
	 * @return         True if array content is equal, otherwise false.
	 */
	public static final boolean equals(long[] array1, long[] array2) {
		final String METHOD_NAME = "equals(long[] array1, boolean[] array2)";
		if (array1 == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array1 = null");
			return false;
		}
		if (array2 == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array2 = null");
			return false;
		}
		if (array1.length != array2.length) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Difference in lengths: array1.length = " + array1.length + ", array2.length = " + array2.length);
			return false;
		}
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Equality test started: array1.length = " + array1.length + ", array2.length = " + array2.length);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		int n = array1.length;
		boolean result = true;
		int i;
		for (i = 0; i < n; i++) {
			if (array1[i] != array2[i]) {
				result = false;
				break;
			}
		}
		pt.end();
		if (JanetUtils.logInfo) {
			if (result == true)
				JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Equality test finished: array1.length = " + array1.length + ", array2.length = " + array2.length + ", result = " + result, pt.getProcessingTime());
			else
				JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Equality test finished: array1.length = " + array1.length + ", array2.length = " + array2.length + ", result = " + result + ", array1[" + i + "] = " + array1[i] + ", array2[" + i + "] = " + array2[i], pt.getProcessingTime());
		}
		return result;
	}
	/**
	 * Check whether array content is equal.
	 * @param array1   First array.
	 * @param array2   Second array.
	 * @return         True if array content is equal, otherwise false.
	 */
	public static final boolean equals(float[] array1, float[] array2) {
		final String METHOD_NAME = "equals(float[] array1, boolean[] array2)";
		if (array1 == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array1 = null");
			return false;
		}
		if (array2 == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array2 = null");
			return false;
		}
		if (array1.length != array2.length) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Difference in lengths: array1.length = " + array1.length + ", array2.length = " + array2.length);
			return false;
		}
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Equality test started: array1.length = " + array1.length + ", array2.length = " + array2.length);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		int n = array1.length;
		boolean result = true;
		int i;
		for (i = 0; i < n; i++) {
			if (array1[i] != array2[i]) {
				result = false;
				break;
			}
		}
		pt.end();
		if (JanetUtils.logInfo) {
			if (result == true)
				JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Equality test finished: array1.length = " + array1.length + ", array2.length = " + array2.length + ", result = " + result, pt.getProcessingTime());
			else
				JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Equality test finished: array1.length = " + array1.length + ", array2.length = " + array2.length + ", result = " + result + ", array1[" + i + "] = " + array1[i] + ", array2[" + i + "] = " + array2[i], pt.getProcessingTime());
		}
		return result;
	}
	/**
	 * Check whether array content is equal.
	 * @param array1   First array.
	 * @param array2   Second array.
	 * @return         True if array content is equal, otherwise false.
	 */
	public static final boolean equals(double[] array1, double[] array2) {
		final String METHOD_NAME = "equals(double[] array1, boolean[] array2)";
		if (array1 == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array1 = null");
			return false;
		}
		if (array2 == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array2 = null");
			return false;
		}
		if (array1.length != array2.length) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Difference in lengths: array1.length = " + array1.length + ", array2.length = " + array2.length);
			return false;
		}
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Equality test started: array1.length = " + array1.length + ", array2.length = " + array2.length);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		int n = array1.length;
		boolean result = true;
		int i;
		for (i = 0; i < n; i++) {
			if (array1[i] != array2[i]) {
				result = false;
				break;
			}
		}
		pt.end();
		if (JanetUtils.logInfo) {
			if (result == true)
				JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Equality test finished: array1.length = " + array1.length + ", array2.length = " + array2.length + ", result = " + result, pt.getProcessingTime());
			else
				JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Equality test finished: array1.length = " + array1.length + ", array2.length = " + array2.length + ", result = " + result + ", array1[" + i + "] = " + array1[i] + ", array2[" + i + "] = " + array2[i], pt.getProcessingTime());
		}
		return result;
	}
	/**
	 * Check whether array content is equal.
	 * @param array1   First array.
	 * @param array2   Second array.
	 * @return         True if array content is equal, otherwise false.
	 */
	public static final boolean equals(char[] array1, char[] array2) {
		final String METHOD_NAME = "equals(char[] array1, boolean[] array2)";
		if (array1 == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array1 = null");
			return false;
		}
		if (array2 == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array2 = null");
			return false;
		}
		if (array1.length != array2.length) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Difference in lengths: array1.length = " + array1.length + ", array2.length = " + array2.length);
			return false;
		}
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Equality test started: array1.length = " + array1.length + ", array2.length = " + array2.length);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		int n = array1.length;
		boolean result = true;
		int i;
		for (i = 0; i < n; i++) {
			if (array1[i] != array2[i]) {
				result = false;
				break;
			}
		}
		pt.end();
		if (JanetUtils.logInfo) {
			if (result == true)
				JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Equality test finished: array1.length = " + array1.length + ", array2.length = " + array2.length + ", result = " + result, pt.getProcessingTime());
			else
				JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Equality test finished: array1.length = " + array1.length + ", array2.length = " + array2.length + ", result = " + result + ", array1[" + i + "] = " + array1[i] + ", array2[" + i + "] = " + array2[i], pt.getProcessingTime());
		}
		return result;
	}
	/**
	 * Check whether array content is equal.
	 * @param array1   First array.
	 * @param array2   Second array.
	 * @return         True if array content is equal, otherwise false.
	 */
	public static final boolean equals(String[] array1, String[] array2) {
		final String METHOD_NAME = "equals(String[] array1, boolean[] array2)";
		if (array1 == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array1 = null");
			return false;
		}
		if (array2 == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array2 = null");
			return false;
		}
		if (array1.length != array2.length) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Difference in lengths: array1.length = " + array1.length + ", array2.length = " + array2.length);
			return false;
		}
		if (JanetUtils.logInfo) JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Equality test started: array1.length = " + array1.length + ", array2.length = " + array2.length);
		ProcessingTime pt = new ProcessingTime();
		pt.start();
		int n = array1.length;
		boolean result = true;
		int i;
		for (i = 0; i < n; i++) {
			if (array1[i].equals(array2[i]) == false) {
				result = false;
				break;
			}
		}
		pt.end();
		if (JanetUtils.logInfo) {
			if (result == true)
				JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Equality test finished: array1.length = " + array1.length + ", array2.length = " + array2.length + ", result = " + result, pt.getProcessingTime());
			else
				JanetUtils.logInfo(CLASS_NAME, METHOD_NAME, "Equality test finished: array1.length = " + array1.length + ", array2.length = " + array2.length + ", result = " + result + ", array1[" + i + "] = " + array1[i] + ", array2[" + i + "] = " + array2[i], pt.getProcessingTime());
		}
		return result;
	}
	/**
	 * Swaps elements of the given array.
	 * 
	 * @param array    Array with elements to be swapped.
	 * @param index1   First element index.
	 * @param index2   Second element index.
	 * @return         {@link ErrorCodes#CODE_NO_ERRORS} if successful.
	 *                 {@link ErrorCodes#CODE_NULL_PARAMETER} if null array.
	 *                 {@link ErrorCodes#CODE_INCORRECT_PARAMETER} if index parameters are incorrect.
	 */
	public static final int swapElements(boolean[] array, int index1, int index2) {
		final String METHOD_NAME = "swapElements(boolean[] array, int index1, int index2)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return ErrorCodes.CODE_NULL_PARAMETER;
		}
		if ( (index1 < 0) || (index1 > array.length - 1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "index1 out of range: index1 = " + index1 + ", array.length = " + array.length);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if ( (index2 < 0) || (index2 > array.length - 1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "index2 out of range: index2 = " + index2 + ", array.length = " + array.length);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if (index1 == index2) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Equal indexes, nothing to swap: index1 = " + index1 + ", index2 = " + index2 + ", array.length = " + array.length);
			return ErrorCodes.CODE_NO_ERRORS; 
		}
		if (JanetUtils.logInfo) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Swapping elements started: array[" + index1 + "] = " + array[index1] + ", array[" + index2 + "] = " + array[index2]);
		boolean w = array[index1];
		array[index1] = array[index2];
		array[index2] = w;
		if (JanetUtils.logInfo) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Swapping elements finished: array[" + index1 + "] = " + array[index1] + ", array[" + index2 + "] = " + array[index2]);
		return ErrorCodes.CODE_NO_ERRORS;
	}
	/**
	 * Swaps elements of the given array.
	 * 
	 * @param array    Array with elements to be swapped.
	 * @param index1   First element index.
	 * @param index2   Second element index.
	 * @return         {@link ErrorCodes#CODE_NO_ERRORS} if successful.
	 *                 {@link ErrorCodes#CODE_NULL_PARAMETER} if null array.
	 *                 {@link ErrorCodes#CODE_INCORRECT_PARAMETER} if index parameters are incorrect.
	 */
	public static final int swapElements(byte[] array, int index1, int index2) {
		final String METHOD_NAME = "swapElements(byte[] array, int index1, int index2)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return ErrorCodes.CODE_NULL_PARAMETER;
		}
		if ( (index1 < 0) || (index1 > array.length - 1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "index1 out of range: index1 = " + index1 + ", array.length = " + array.length);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if ( (index2 < 0) || (index2 > array.length - 1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "index2 out of range: index2 = " + index2 + ", array.length = " + array.length);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if (index1 == index2) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Equal indexes, nothing to swap: index1 = " + index1 + ", index2 = " + index2 + ", array.length = " + array.length);
			return ErrorCodes.CODE_NO_ERRORS; 
		}
		if (JanetUtils.logInfo) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Swapping elements started: array[" + index1 + "] = " + array[index1] + ", array[" + index2 + "] = " + array[index2]);
		byte w = array[index1];
		array[index1] = array[index2];
		array[index2] = w;
		if (JanetUtils.logInfo) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Swapping elements finished: array[" + index1 + "] = " + array[index1] + ", array[" + index2 + "] = " + array[index2]);
		return ErrorCodes.CODE_NO_ERRORS;
	}
	/**
	 * Swaps elements of the given array.
	 * 
	 * @param array    Array with elements to be swapped.
	 * @param index1   First element index.
	 * @param index2   Second element index.
	 * @return         {@link ErrorCodes#CODE_NO_ERRORS} if successful.
	 *                 {@link ErrorCodes#CODE_NULL_PARAMETER} if null array.
	 *                 {@link ErrorCodes#CODE_INCORRECT_PARAMETER} if index parameters are incorrect.
	 */
	public static final int swapElements(short[] array, int index1, int index2) {
		final String METHOD_NAME = "swapElements(short[] array, int index1, int index2)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return ErrorCodes.CODE_NULL_PARAMETER;
		}
		if ( (index1 < 0) || (index1 > array.length - 1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "index1 out of range: index1 = " + index1 + ", array.length = " + array.length);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if ( (index2 < 0) || (index2 > array.length - 1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "index2 out of range: index2 = " + index2 + ", array.length = " + array.length);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if (index1 == index2) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Equal indexes, nothing to swap: index1 = " + index1 + ", index2 = " + index2 + ", array.length = " + array.length);
			return ErrorCodes.CODE_NO_ERRORS; 
		}
		if (JanetUtils.logInfo) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Swapping elements started: array[" + index1 + "] = " + array[index1] + ", array[" + index2 + "] = " + array[index2]);
		short w = array[index1];
		array[index1] = array[index2];
		array[index2] = w;
		if (JanetUtils.logInfo) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Swapping elements finished: array[" + index1 + "] = " + array[index1] + ", array[" + index2 + "] = " + array[index2]);
		return ErrorCodes.CODE_NO_ERRORS;
	}
	/**
	 * Swaps elements of the given array.
	 * 
	 * @param array    Array with elements to be swapped.
	 * @param index1   First element index.
	 * @param index2   Second element index.
	 * @return         {@link ErrorCodes#CODE_NO_ERRORS} if successful.
	 *                 {@link ErrorCodes#CODE_NULL_PARAMETER} if null array.
	 *                 {@link ErrorCodes#CODE_INCORRECT_PARAMETER} if index parameters are incorrect.
	 */
	public static final int swapElements(int[] array, int index1, int index2) {
		final String METHOD_NAME = "swapElements(int[] array, int index1, int index2)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return ErrorCodes.CODE_NULL_PARAMETER;
		}
		if ( (index1 < 0) || (index1 > array.length - 1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "index1 out of range: index1 = " + index1 + ", array.length = " + array.length);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if ( (index2 < 0) || (index2 > array.length - 1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "index2 out of range: index2 = " + index2 + ", array.length = " + array.length);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if (index1 == index2) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Equal indexes, nothing to swap: index1 = " + index1 + ", index2 = " + index2 + ", array.length = " + array.length);
			return ErrorCodes.CODE_NO_ERRORS; 
		}
		if (JanetUtils.logInfo) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Swapping elements started: array[" + index1 + "] = " + array[index1] + ", array[" + index2 + "] = " + array[index2]);
		int w = array[index1];
		array[index1] = array[index2];
		array[index2] = w;
		if (JanetUtils.logInfo) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Swapping elements finished: array[" + index1 + "] = " + array[index1] + ", array[" + index2 + "] = " + array[index2]);
		return ErrorCodes.CODE_NO_ERRORS;
	}
	/**
	 * Swaps elements of the given array.
	 * 
	 * @param array    Array with elements to be swapped.
	 * @param index1   First element index.
	 * @param index2   Second element index.
	 * @return         {@link ErrorCodes#CODE_NO_ERRORS} if successful.
	 *                 {@link ErrorCodes#CODE_NULL_PARAMETER} if null array.
	 *                 {@link ErrorCodes#CODE_INCORRECT_PARAMETER} if index parameters are incorrect.
	 */
	public static final int swapElements(long[] array, int index1, int index2) {
		final String METHOD_NAME = "swapElements(long[] array, int index1, int index2)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return ErrorCodes.CODE_NULL_PARAMETER;
		}
		if ( (index1 < 0) || (index1 > array.length - 1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "index1 out of range: index1 = " + index1 + ", array.length = " + array.length);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if ( (index2 < 0) || (index2 > array.length - 1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "index2 out of range: index2 = " + index2 + ", array.length = " + array.length);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if (index1 == index2) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Equal indexes, nothing to swap: index1 = " + index1 + ", index2 = " + index2 + ", array.length = " + array.length);
			return ErrorCodes.CODE_NO_ERRORS; 
		}
		if (JanetUtils.logInfo) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Swapping elements started: array[" + index1 + "] = " + array[index1] + ", array[" + index2 + "] = " + array[index2]);
		long w = array[index1];
		array[index1] = array[index2];
		array[index2] = w;
		if (JanetUtils.logInfo) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Swapping elements finished: array[" + index1 + "] = " + array[index1] + ", array[" + index2 + "] = " + array[index2]);
		return ErrorCodes.CODE_NO_ERRORS;
	}
	/**
	 * Swaps elements of the given array.
	 * 
	 * @param array    Array with elements to be swapped.
	 * @param index1   First element index.
	 * @param index2   Second element index.
	 * @return         {@link ErrorCodes#CODE_NO_ERRORS} if successful.
	 *                 {@link ErrorCodes#CODE_NULL_PARAMETER} if null array.
	 *                 {@link ErrorCodes#CODE_INCORRECT_PARAMETER} if index parameters are incorrect.
	 */
	public static final int swapElements(char[] array, int index1, int index2) {
		final String METHOD_NAME = "swapElements(char[] array, int index1, int index2)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return ErrorCodes.CODE_NULL_PARAMETER;
		}
		if ( (index1 < 0) || (index1 > array.length - 1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "index1 out of range: index1 = " + index1 + ", array.length = " + array.length);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if ( (index2 < 0) || (index2 > array.length - 1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "index2 out of range: index2 = " + index2 + ", array.length = " + array.length);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if (index1 == index2) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Equal indexes, nothing to swap: index1 = " + index1 + ", index2 = " + index2 + ", array.length = " + array.length);
			return ErrorCodes.CODE_NO_ERRORS; 
		}
		if (JanetUtils.logInfo) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Swapping elements started: array[" + index1 + "] = " + array[index1] + ", array[" + index2 + "] = " + array[index2]);
		char w = array[index1];
		array[index1] = array[index2];
		array[index2] = w;
		if (JanetUtils.logInfo) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Swapping elements finished: array[" + index1 + "] = " + array[index1] + ", array[" + index2 + "] = " + array[index2]);
		return ErrorCodes.CODE_NO_ERRORS;
	}
	/**
	 * Swaps elements of the given array.
	 * 
	 * @param array    Array with elements to be swapped.
	 * @param index1   First element index.
	 * @param index2   Second element index.
	 * @return         {@link ErrorCodes#CODE_NO_ERRORS} if successful.
	 *                 {@link ErrorCodes#CODE_NULL_PARAMETER} if null array.
	 *                 {@link ErrorCodes#CODE_INCORRECT_PARAMETER} if index parameters are incorrect.
	 */
	public static final int swapElements(float[] array, int index1, int index2) {
		final String METHOD_NAME = "swapElements(float[] array, int index1, int index2)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return ErrorCodes.CODE_NULL_PARAMETER;
		}
		if ( (index1 < 0) || (index1 > array.length - 1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "index1 out of range: index1 = " + index1 + ", array.length = " + array.length);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if ( (index2 < 0) || (index2 > array.length - 1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "index2 out of range: index2 = " + index2 + ", array.length = " + array.length);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if (index1 == index2) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Equal indexes, nothing to swap: index1 = " + index1 + ", index2 = " + index2 + ", array.length = " + array.length);
			return ErrorCodes.CODE_NO_ERRORS; 
		}
		if (JanetUtils.logInfo) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Swapping elements started: array[" + index1 + "] = " + array[index1] + ", array[" + index2 + "] = " + array[index2]);
		float w = array[index1];
		array[index1] = array[index2];
		array[index2] = w;
		if (JanetUtils.logInfo) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Swapping elements finished: array[" + index1 + "] = " + array[index1] + ", array[" + index2 + "] = " + array[index2]);
		return ErrorCodes.CODE_NO_ERRORS;
	}
	/**
	 * Swaps elements of the given array.
	 * 
	 * @param array    Array with elements to be swapped.
	 * @param index1   First element index.
	 * @param index2   Second element index.
	 * @return         {@link ErrorCodes#CODE_NO_ERRORS} if successful.
	 *                 {@link ErrorCodes#CODE_NULL_PARAMETER} if null array.
	 *                 {@link ErrorCodes#CODE_INCORRECT_PARAMETER} if index parameters are incorrect.
	 */
	public static final int swapElements(double[] array, int index1, int index2) {
		final String METHOD_NAME = "swapElements(double[] array, int index1, int index2)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return ErrorCodes.CODE_NULL_PARAMETER;
		}
		if ( (index1 < 0) || (index1 > array.length - 1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "index1 out of range: index1 = " + index1 + ", array.length = " + array.length);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if ( (index2 < 0) || (index2 > array.length - 1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "index2 out of range: index2 = " + index2 + ", array.length = " + array.length);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if (index1 == index2) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Equal indexes, nothing to swap: index1 = " + index1 + ", index2 = " + index2 + ", array.length = " + array.length);
			return ErrorCodes.CODE_NO_ERRORS; 
		}
		if (JanetUtils.logInfo) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Swapping elements started: array[" + index1 + "] = " + array[index1] + ", array[" + index2 + "] = " + array[index2]);
		double w = array[index1];
		array[index1] = array[index2];
		array[index2] = w;
		if (JanetUtils.logInfo) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Swapping elements finished: array[" + index1 + "] = " + array[index1] + ", array[" + index2 + "] = " + array[index2]);
		return ErrorCodes.CODE_NO_ERRORS;
	}
	/**
	 * Swaps elements of the given array.
	 * 
	 * @param array    Array with elements to be swapped.
	 * @param index1   First element index.
	 * @param index2   Second element index.
	 * @return         {@link ErrorCodes#CODE_NO_ERRORS} if successful.
	 *                 {@link ErrorCodes#CODE_NULL_PARAMETER} if null array.
	 *                 {@link ErrorCodes#CODE_INCORRECT_PARAMETER} if index parameters are incorrect.
	 */
	public static final int swapElements(Object[] array, int index1, int index2) {
		final String METHOD_NAME = "swapElements(Object[] array, int index1, int index2)";
		if (array == null) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_NULL_PARAMETER, "array = null");
			return ErrorCodes.CODE_NULL_PARAMETER;
		}
		if ( (index1 < 0) || (index1 > array.length - 1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "index1 out of range: index1 = " + index1 + ", array.length = " + array.length);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if ( (index2 < 0) || (index2 > array.length - 1) ) {
			if (JanetUtils.logErrors) JanetUtils.logError(CLASS_NAME, METHOD_NAME, ErrorCodes.CODE_INCORRECT_PARAMETER, "index2 out of range: index2 = " + index2 + ", array.length = " + array.length);
			return ErrorCodes.CODE_INCORRECT_PARAMETER;
		}
		if (index1 == index2) {
			if (JanetUtils.logWarnings) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Equal indexes, nothing to swap: index1 = " + index1 + ", index2 = " + index2 + ", array.length = " + array.length);
			return ErrorCodes.CODE_NO_ERRORS; 
		}
		if (JanetUtils.logInfo) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Swapping elements started: array[" + index1 + "] = " + array[index1] + ", array[" + index2 + "] = " + array[index2]);
		Object w = array[index1];
		array[index1] = array[index2];
		array[index2] = w;
		if (JanetUtils.logInfo) JanetUtils.logWarning(CLASS_NAME, METHOD_NAME, "Swapping elements finished: array[" + index1 + "] = " + array[index1] + ", array[" + index2 + "] = " + array[index2]);
		return ErrorCodes.CODE_NO_ERRORS;
	}
}