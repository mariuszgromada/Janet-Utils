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
	public void quickSort(byte[] array, int fromIndex, int toIndex) {
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
	/**
	 * Quick sort of the array.
	 */
	public void quickSort(byte[] array) {
		quickSort(array, 0, array.length - 1);
	}
	/**
	 * Quick sort of the array.
	 * @param fromIndex    Starting left index.
	 * @param toIndex    Starting right index.
	 */
	public void quickSort(short[] array, int fromIndex, int toIndex) {
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
	/**
	 * Quick sort of the array.
	 */
	public void quickSort(short[] array) {
		quickSort(array, 0, array.length - 1);
	}
	/**
	 * Quick sort of the array.
	 * @param fromIndex    Starting left index.
	 * @param toIndex    Starting right index.
	 */
	public void quickSort(int[] array, int fromIndex, int toIndex) {
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
	/**
	 * Quick sort of the array.
	 */
	public void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}
	/**
	 * Quick sort of the array.
	 * @param fromIndex    Starting left index.
	 * @param toIndex    Starting right index.
	 */
	public void quickSort(long[] array, int fromIndex, int toIndex) {
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
	/**
	 * Quick sort of the array.
	 */
	public void quickSort(long[] array) {
		quickSort(array, 0, array.length - 1);
	}
	/**
	 * Quick sort of the array.
	 * @param fromIndex    Starting left index.
	 * @param toIndex    Starting right index.
	 */
	public void quickSort(double[] array, int fromIndex, int toIndex) {
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
	/**
	 * Quick sort of the array.
	 */
	public void quickSort(double[] array) {
		quickSort(array, 0, array.length - 1);
	}
	/**
	 * Quick sort of the array.
	 * @param fromIndex    Starting left index.
	 * @param toIndex    Starting right index.
	 */
	public void quickSort(float[] array, int fromIndex, int toIndex) {
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
	/**
	 * Quick sort of the array.
	 */
	public void quickSort(float[] array) {
		quickSort(array, 0, array.length - 1);
	}
	/**
	 * Quick sort of the array.
	 * @param fromIndex    Starting left index.
	 * @param toIndex    Starting right index.
	 */
	public void quickSort(boolean[] array, int fromIndex, int toIndex) {
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
	/**
	 * Quick sort of the array.
	 */
	public void quickSort(boolean[] array) {
		quickSort(array, 0, array.length - 1);
	}
	/**
	 * Quick sort of the array.
	 * @param fromIndex    Starting left index.
	 * @param toIndex    Starting right index.
	 */
	public void quickSort(char[] array, int fromIndex, int toIndex) {
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
	/**
	 * Quick sort of the array.
	 */
	public void quickSort(char[] array) {
		quickSort(array, 0, array.length - 1);
	}

}