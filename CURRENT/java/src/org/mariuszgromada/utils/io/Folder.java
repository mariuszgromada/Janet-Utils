/*
 * @(#)Folder.java        1.0.0    2016-01-18
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
package org.mariuszgromada.utils.io;

import java.io.File;
import java.util.ArrayList;

import org.mariuszgromada.utils.ArrayX;

/**
 * General purpose class to help working with folders.
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
public class Folder {
	/**
	 * Folder definition.
	 */
	File folder;
	/**
	 * All list of folder elements
	 */
	File[] elements;
	/**
	 * Collection of all of folder elements
	 */
	ArrayList<File> elementsCollection;
	/**
	 * Folder files only (excluding directories)
	 */
	File[] files;
	/**
	 * A collections of folder files only (excluding directories)
	 */
	ArrayList<File> filesCollection;
	/**
	 * List of direct subfolders
	 */
	File[] subfolders;
	/**
	 * A collection of folder direct subfolders
	 */
	ArrayList<File> subfoldersCollection;
	/**
	 * Constructor based on folder path.
	 *
	 * @param folderPath       Full path to the folder
	 */
	public Folder(String folderPath) {
		folder = new File(folderPath);
		elementsCollection = new ArrayList<File>();
		filesCollection = new ArrayList<File>();
		subfoldersCollection = new ArrayList<File>();
		refresh();
	}
	/**
	 * Constructor based on file object containing folder
	 * definition.
	 *
	 * @param folderPath       Full path to the folder
	 */
	public Folder(File folder) {
		this.folder = folder;
		elementsCollection = new ArrayList<File>();
		filesCollection = new ArrayList<File>();
		subfoldersCollection = new ArrayList<File>();
		refresh();
	}
	/**
	 * Finds and categorize folder elements
	 */
	private void findElements() {
		elements = folder.listFiles();
		for (File file : elements) {
			elementsCollection.add(file);
			if ( file.isDirectory() ) subfoldersCollection.add(file);
			if ( file.isFile() ) filesCollection.add(file);
		}
		files = ArrayX.toArray(File.class, filesCollection);
		subfolders = ArrayX.toArray(File.class, subfoldersCollection);
	}
	/**
	 * Refresh state of the folder elements
	 */
	public void refresh() {
		elementsCollection.clear();
		filesCollection.clear();
		subfoldersCollection.clear();
		findElements();
	}
	/**
	 * Gets all folder elements.
	 *
	 * @return       All folder elements
	 */
	public File[] getElements() {
		return elements;
	}
	/**
	 * Gets collection of all folder elements.
	 *
	 * @return       All folder elements
	 */
	public ArrayList<File> getElementsCollection() {
		return elementsCollection;
	}
	/**
	 * Gets all folder elements, which are files.
	 *
	 * @return       All folder elements, which are files.
	 */
	public File[] getFiles() {
		return files;
	}
	/**
	 * Gets collection of all folder files.
	 *
	 * @return       All folder elements, which are files.
	 */
	public ArrayList<File> getFilesCollection() {
		return filesCollection;
	}
	/**
	 * Gets all folder elements, which are files with file
	 * extension provided on the list.
	 *
	 * extsList      List of file extension to be checked.
	 *
	 * @return       All folder elements, which are files
	 *               with file extension provided on the list.
	 */
	public File[] getFiles(String... extsList) {
		ArrayList<File> files = new ArrayList<File>();
		for (File file : files) {
			if ( FileX.fileExtIs(file, extsList) )
				files.add(file);
		}
		return ArrayX.toArray(File.class, files);
	}
	/**
	 * Gets collection of all folder elements, which are files with file
	 * extension provided on the list.
	 *
	 * extsList      List of file extension to be checked.
	 *
	 * @return       All folder elements, which are files
	 *               with file extension provided on the list.
	 */
	public ArrayList<File> getFilesCollection(String... extsList) {
		ArrayList<File> files = new ArrayList<File>();
		for (File file : files) {
			if ( FileX.fileExtIs(file, extsList) )
				files.add(file);
		}
		return files;
	}
	/**
	 * Get folder direct subfolders.
	 *
	 * @return       All direct subfolders.
	 */
	public File[] getSubfolders() {
		return subfolders;
	}
	/**
	 * Gets collection of all folder subfolders.
	 *
	 * @return       All direct subfolders.
	 */
	public ArrayList<File> getSubfoldersCollection() {
		return subfoldersCollection;
	}
	/**
	 * Prints to the console all folder elements.
	 */
	public void printElements() {
		FileX.printFiles(elements);
	}
	/**
	 * Prints to the console all folder files.
	 */
	public void printFiles() {
		FileX.printFiles(files);
	}
	/**
	 * Prints to the console all folder files.
	 */
	public void printSubfolders() {
		FileX.printFiles(subfolders);
	}
}
