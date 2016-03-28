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
		int n = arrayList.size();
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
		int n = stack.size();
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
		if (array == null) return ErrorCodes.CODE_NULL_PARAMETER;
		if (array.length < 2) return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		if ( (fromIndex < 0) || (fromIndex > array.length -1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if ( (toIndex < 0) || (toIndex > array.length -1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if (fromIndex == toIndex) return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		quickSort(array, fromIndex, toIndex);
		return ErrorCodes.CODE_NO_ERRORS;
	}
	public static final int sort(byte[] array) {
		if (array == null) return ErrorCodes.CODE_NULL_PARAMETER;
		if (array.length < 2) return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		quickSort(array, 0, array.length - 1);
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
		if (array == null) return ErrorCodes.CODE_NULL_PARAMETER;
		if (array.length < 2) return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		if ( (fromIndex < 0) || (fromIndex > array.length -1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if ( (toIndex < 0) || (toIndex > array.length -1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if (fromIndex == toIndex) return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		quickSort(array, fromIndex, toIndex);
		return ErrorCodes.CODE_NO_ERRORS;
	}
	public static final int sort(short[] array) {
		if (array == null) return ErrorCodes.CODE_NULL_PARAMETER;
		if (array.length < 2) return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		quickSort(array, 0, array.length - 1);
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
		if (array == null) return ErrorCodes.CODE_NULL_PARAMETER;
		if (array.length < 2) return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		if ( (fromIndex < 0) || (fromIndex > array.length -1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if ( (toIndex < 0) || (toIndex > array.length -1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if (fromIndex == toIndex) return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		quickSort(array, fromIndex, toIndex);
		return ErrorCodes.CODE_NO_ERRORS;
	}
	public static final int sort(int[] array) {
		if (array == null) return ErrorCodes.CODE_NULL_PARAMETER;
		if (array.length < 2) return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		quickSort(array, 0, array.length - 1);
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
		if (array == null) return ErrorCodes.CODE_NULL_PARAMETER;
		if (array.length < 2) return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		if ( (fromIndex < 0) || (fromIndex > array.length -1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if ( (toIndex < 0) || (toIndex > array.length -1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if (fromIndex == toIndex) return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		quickSort(array, fromIndex, toIndex);
		return ErrorCodes.CODE_NO_ERRORS;
	}
	public static final int sort(long[] array) {
		if (array == null) return ErrorCodes.CODE_NULL_PARAMETER;
		if (array.length < 2) return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		quickSort(array, 0, array.length - 1);
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
		if (array == null) return ErrorCodes.CODE_NULL_PARAMETER;
		if (array.length < 2) return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		if ( (fromIndex < 0) || (fromIndex > array.length -1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if ( (toIndex < 0) || (toIndex > array.length -1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if (fromIndex == toIndex) return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		quickSort(array, fromIndex, toIndex);
		return ErrorCodes.CODE_NO_ERRORS;
	}
	public static final int sort(double[] array) {
		if (array == null) return ErrorCodes.CODE_NULL_PARAMETER;
		if (array.length < 2) return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		quickSort(array, 0, array.length - 1);
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
		if (array == null) return ErrorCodes.CODE_NULL_PARAMETER;
		if (array.length < 2) return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		if ( (fromIndex < 0) || (fromIndex > array.length -1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if ( (toIndex < 0) || (toIndex > array.length -1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if (fromIndex == toIndex) return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		quickSort(array, fromIndex, toIndex);
		return ErrorCodes.CODE_NO_ERRORS;
	}
	public static final int sort(float[] array) {
		if (array == null) return ErrorCodes.CODE_NULL_PARAMETER;
		if (array.length < 2) return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		quickSort(array, 0, array.length - 1);
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
		if (array == null) return ErrorCodes.CODE_NULL_PARAMETER;
		if (array.length < 2) return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		if ( (fromIndex < 0) || (fromIndex > array.length -1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if ( (toIndex < 0) || (toIndex > array.length -1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if (fromIndex == toIndex) return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		quickSort(array, fromIndex, toIndex);
		return ErrorCodes.CODE_NO_ERRORS;
	}
	public static final int sort(boolean[] array) {
		if (array == null) return ErrorCodes.CODE_NULL_PARAMETER;
		if (array.length < 2) return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		quickSort(array, 0, array.length - 1);
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
		if (array == null) return ErrorCodes.CODE_NULL_PARAMETER;
		if (array.length < 2) return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		if ( (fromIndex < 0) || (fromIndex > array.length -1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if ( (toIndex < 0) || (toIndex > array.length -1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if (fromIndex == toIndex) return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		quickSort(array, fromIndex, toIndex);
		return ErrorCodes.CODE_NO_ERRORS;
	}
	public static final int sort(char[] array) {
		if (array == null) return ErrorCodes.CODE_NULL_PARAMETER;
		if (array.length < 2) return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		quickSort(array, 0, array.length - 1);
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
		if (array == null) return ErrorCodes.CODE_NULL_PARAMETER;
		if (array.length < 2) return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		if ( (fromIndex < 0) || (fromIndex > array.length -1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if ( (toIndex < 0) || (toIndex > array.length -1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if (fromIndex == toIndex) return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		quickSort(array, fromIndex, toIndex);
		return ErrorCodes.CODE_NO_ERRORS;
	}
	public static final int sort(String[] array) {
		if (array == null) return ErrorCodes.CODE_NULL_PARAMETER;
		if (array.length < 2) return ErrorCodes.CODE_NOTHING_TO_PROCESS;
		quickSort(array, 0, array.length - 1);
		return ErrorCodes.CODE_NO_ERRORS;
	}
	/**
	 * Given array copy.
	 * @param array   The array to be copied.
	 * @return        Given array copy;
	 */
	public static final boolean[] copy(boolean[] array) {
		if (array == null) return null;
		int n = array.length;
		boolean[] arrayCopy = new boolean[n];
		for (int i = 0; i < n; i++) {
			arrayCopy[i] = array[i];
		}
		return arrayCopy;
	}
	/**
	 * Given array copy.
	 * @param array   The array to be copied.
	 * @return        Given array copy;
	 */
	public static final byte[] copy(byte[] array) {
		if (array == null) return null;
		int n = array.length;
		byte[] arrayCopy = new byte[n];
		for (int i = 0; i < n; i++) {
			arrayCopy[i] = array[i];
		}
		return arrayCopy;
	}
	/**
	 * Given array copy.
	 * @param array   The array to be copied.
	 * @return        Given array copy;
	 */
	public static final short[] copy(short[] array) {
		if (array == null) return null;
		int n = array.length;
		short[] arrayCopy = new short[n];
		for (int i = 0; i < n; i++) {
			arrayCopy[i] = array[i];
		}
		return arrayCopy;
	}
	/**
	 * Given array copy.
	 * @param array   The array to be copied.
	 * @return        Given array copy;
	 */
	public static final int[] copy(int[] array) {
		if (array == null) return null;
		int n = array.length;
		int[] arrayCopy = new int[n];
		for (int i = 0; i < n; i++) {
			arrayCopy[i] = array[i];
		}
		return arrayCopy;
	}
	/**
	 * Given array copy.
	 * @param array   The array to be copied.
	 * @return        Given array copy;
	 */
	public static final long[] copy(long[] array) {
		if (array == null) return null;
		int n = array.length;
		long[] arrayCopy = new long[n];
		for (int i = 0; i < n; i++) {
			arrayCopy[i] = array[i];
		}
		return arrayCopy;
	}
	/**
	 * Given array copy.
	 * @param array   The array to be copied.
	 * @return        Given array copy;
	 */
	public static final float[] copy(float[] array) {
		if (array == null) return null;
		int n = array.length;
		float[] arrayCopy = new float[n];
		for (int i = 0; i < n; i++) {
			arrayCopy[i] = array[i];
		}
		return arrayCopy;
	}
	/**
	 * Given array copy.
	 * @param array   The array to be copied.
	 * @return        Given array copy;
	 */
	public static final double[] copy(double[] array) {
		if (array == null) return null;
		int n = array.length;
		double[] arrayCopy = new double[n];
		for (int i = 0; i < n; i++) {
			arrayCopy[i] = array[i];
		}
		return arrayCopy;
	}
	/**
	 * Given array copy.
	 * @param array   The array to be copied.
	 * @return        Given array copy;
	 */
	public static final char[] copy(char[] array) {
		if (array == null) return null;
		int n = array.length;
		char[] arrayCopy = new char[n];
		for (int i = 0; i < n; i++) {
			arrayCopy[i] = array[i];
		}
		return arrayCopy;
	}
	/**
	 * Given array copy.
	 * @param array   The array to be copied.
	 * @return        Given array copy;
	 */
	public static final String[] copy(String[] array) {
		if (array == null) return null;
		int n = array.length;
		String[] arrayCopy = new String[n];
		for (int i = 0; i < n; i++) {
			arrayCopy[i] = new String(array[i]);
		}
		return arrayCopy;
	}
	/**
	 * Check whether array content is equal.
	 * @param array1   First array.
	 * @param array2   Second array.
	 * @return         True if array content is equal, otherwise false.
	 */
	public static final boolean equals(boolean[] array1, boolean[] array2) {
		if (array1 == null) return false;
		if (array2 == null) return false;
		if (array1.length != array2.length) return false;
		int n = array1.length;
		for (int i = 0; i < n; i++) {
			if (array1[i] != array2[i]) return false;
		}
		return true;
	}
	/**
	 * Check whether array content is equal.
	 * @param array1   First array.
	 * @param array2   Second array.
	 * @return         True if array content is equal, otherwise false.
	 */
	public static final boolean equals(byte[] array1, byte[] array2) {
		if (array1 == null) return false;
		if (array2 == null) return false;
		if (array1.length != array2.length) return false;
		int n = array1.length;
		for (int i = 0; i < n; i++) {
			if (array1[i] != array2[i]) return false;
		}
		return true;
	}
	/**
	 * Check whether array content is equal.
	 * @param array1   First array.
	 * @param array2   Second array.
	 * @return         True if array content is equal, otherwise false.
	 */
	public static final boolean equals(short[] array1, short[] array2) {
		if (array1 == null) return false;
		if (array2 == null) return false;
		if (array1.length != array2.length) return false;
		int n = array1.length;
		for (int i = 0; i < n; i++) {
			if (array1[i] != array2[i]) return false;
		}
		return true;
	}
	/**
	 * Check whether array content is equal.
	 * @param array1   First array.
	 * @param array2   Second array.
	 * @return         True if array content is equal, otherwise false.
	 */
	public static final boolean equals(int[] array1, int[] array2) {
		if (array1 == null) return false;
		if (array2 == null) return false;
		if (array1.length != array2.length) return false;
		int n = array1.length;
		for (int i = 0; i < n; i++) {
			if (array1[i] != array2[i]) return false;
		}
		return true;
	}
	/**
	 * Check whether array content is equal.
	 * @param array1   First array.
	 * @param array2   Second array.
	 * @return         True if array content is equal, otherwise false.
	 */
	public static final boolean equals(long[] array1, long[] array2) {
		if (array1 == null) return false;
		if (array2 == null) return false;
		if (array1.length != array2.length) return false;
		int n = array1.length;
		for (int i = 0; i < n; i++) {
			if (array1[i] != array2[i]) return false;
		}
		return true;
	}
	/**
	 * Check whether array content is equal.
	 * @param array1   First array.
	 * @param array2   Second array.
	 * @return         True if array content is equal, otherwise false.
	 */
	public static final boolean equals(float[] array1, float[] array2) {
		if (array1 == null) return false;
		if (array2 == null) return false;
		if (array1.length != array2.length) return false;
		int n = array1.length;
		for (int i = 0; i < n; i++) {
			if (array1[i] != array2[i]) return false;
		}
		return true;
	}
	/**
	 * Check whether array content is equal.
	 * @param array1   First array.
	 * @param array2   Second array.
	 * @return         True if array content is equal, otherwise false.
	 */
	public static final boolean equals(double[] array1, double[] array2) {
		if (array1 == null) return false;
		if (array2 == null) return false;
		if (array1.length != array2.length) return false;
		int n = array1.length;
		for (int i = 0; i < n; i++) {
			if (array1[i] != array2[i]) return false;
		}
		return true;
	}
	/**
	 * Check whether array content is equal.
	 * @param array1   First array.
	 * @param array2   Second array.
	 * @return         True if array content is equal, otherwise false.
	 */
	public static final boolean equals(char[] array1, char[] array2) {
		if (array1 == null) return false;
		if (array2 == null) return false;
		if (array1.length != array2.length) return false;
		int n = array1.length;
		for (int i = 0; i < n; i++) {
			if (array1[i] != array2[i]) return false;
		}
		return true;
	}
	/**
	 * Check whether array content is equal.
	 * @param array1   First array.
	 * @param array2   Second array.
	 * @return         True if array content is equal, otherwise false.
	 */
	public static final boolean equals(String[] array1, String[] array2) {
		if (array1 == null) return false;
		if (array2 == null) return false;
		if (array1.length != array2.length) return false;
		int n = array1.length;
		for (int i = 0; i < n; i++) {
			if (array1[i].equals(array2[i]) == false) return false;
		}
		return true;
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
		if (array == null) return ErrorCodes.CODE_NULL_PARAMETER;
		if ( (index1 < 0) || (index1 > array.length - 1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if ( (index2 < 0) || (index2 > array.length - 1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if (index1 == index2) return ErrorCodes.CODE_NO_ERRORS; 
		boolean w = array[index1];
		array[index1] = array[index2];
		array[index2] = w;
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
		if (array == null) return ErrorCodes.CODE_NULL_PARAMETER;
		if ( (index1 < 0) || (index1 > array.length - 1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if ( (index2 < 0) || (index2 > array.length - 1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if (index1 == index2) return ErrorCodes.CODE_NO_ERRORS; 
		byte w = array[index1];
		array[index1] = array[index2];
		array[index2] = w;
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
		if (array == null) return ErrorCodes.CODE_NULL_PARAMETER;
		if ( (index1 < 0) || (index1 > array.length - 1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if ( (index2 < 0) || (index2 > array.length - 1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if (index1 == index2) return ErrorCodes.CODE_NO_ERRORS; 
		short w = array[index1];
		array[index1] = array[index2];
		array[index2] = w;
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
		if (array == null) return ErrorCodes.CODE_NULL_PARAMETER;
		if ( (index1 < 0) || (index1 > array.length - 1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if ( (index2 < 0) || (index2 > array.length - 1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if (index1 == index2) return ErrorCodes.CODE_NO_ERRORS; 
		int w = array[index1];
		array[index1] = array[index2];
		array[index2] = w;
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
		if (array == null) return ErrorCodes.CODE_NULL_PARAMETER;
		if ( (index1 < 0) || (index1 > array.length - 1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if ( (index2 < 0) || (index2 > array.length - 1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if (index1 == index2) return ErrorCodes.CODE_NO_ERRORS; 
		long w = array[index1];
		array[index1] = array[index2];
		array[index2] = w;
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
		if (array == null) return ErrorCodes.CODE_NULL_PARAMETER;
		if ( (index1 < 0) || (index1 > array.length - 1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if ( (index2 < 0) || (index2 > array.length - 1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if (index1 == index2) return ErrorCodes.CODE_NO_ERRORS; 
		char w = array[index1];
		array[index1] = array[index2];
		array[index2] = w;
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
		if (array == null) return ErrorCodes.CODE_NULL_PARAMETER;
		if ( (index1 < 0) || (index1 > array.length - 1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if ( (index2 < 0) || (index2 > array.length - 1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if (index1 == index2) return ErrorCodes.CODE_NO_ERRORS; 
		float w = array[index1];
		array[index1] = array[index2];
		array[index2] = w;
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
		if (array == null) return ErrorCodes.CODE_NULL_PARAMETER;
		if ( (index1 < 0) || (index1 > array.length - 1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if ( (index2 < 0) || (index2 > array.length - 1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if (index1 == index2) return ErrorCodes.CODE_NO_ERRORS; 
		double w = array[index1];
		array[index1] = array[index2];
		array[index2] = w;
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
		if (array == null) return ErrorCodes.CODE_NULL_PARAMETER;
		if ( (index1 < 0) || (index1 > array.length - 1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if ( (index2 < 0) || (index2 > array.length - 1) ) return ErrorCodes.CODE_INCORRECT_PARAMETER;
		if (index1 == index2) return ErrorCodes.CODE_NO_ERRORS; 
		Object w = array[index1];
		array[index1] = array[index2];
		array[index2] = w;
		return ErrorCodes.CODE_NO_ERRORS;
	}
}