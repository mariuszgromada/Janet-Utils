/*
 * @(#)FilesListRecursive.java        1.0.0    2016-01-18
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
package org.mariuszgromada.janetutils.io;

import java.io.File;
import java.util.ArrayList;

import org.mariuszgromada.janetutils.ArrayX;

/**
 * Class scans a given folder recursively
 * building list/collections of elements.
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
public class FilesListRecursive {
	/**
	 * All elements found recursively starting from a given root folder
	 */
	File[] elements;
	/**
	 * Collection of all elements found recursively starting from a given root folder
	 */
	ArrayList<File> elementsCollection;
	/**
	 * All elements, that are files,
	 * found recursively starting from a given root folder
	 */
	File[] files;
	/**
	 * Collection of all elements, that are files,
	 * found recursively starting from a given root folder
	 */
	ArrayList<File> filesCollection;
	/**
	 * All elements, that are folders,
	 * found recursively starting from a given root folder
	 */
	File[] folders;
	/**
	 * Collection of all elements, that are folders,
	 * found recursively starting from a given root folder
	 */
	ArrayList<File> foldersCollection;
	/**
	 * Starting (root) folder
	 */
	private File rootFolder;
	/**
	 * Constructor based on string folder path
	 * @param rootFolderPath
	 */
	public FilesListRecursive(String rootFolderPath) {
		elementsCollection = new ArrayList<File>();
		filesCollection = new ArrayList<File>();
		foldersCollection = new ArrayList<File>();
		rootFolder = new File(rootFolderPath);
		searchForFiles();
	}
	/**
	 * Constructor based on File object representing folder
	 * @param rootFolderPath
	 */
	public FilesListRecursive(File rootFileFolder) {
		elementsCollection = new ArrayList<File>();
		filesCollection = new ArrayList<File>();
		foldersCollection = new ArrayList<File>();
		this.rootFolder = rootFileFolder;
		searchForFiles();
	}
	/**
	 * Constructor based on Folder object representing folder
	 * @param rootFolderPath
	 */
	public FilesListRecursive(Folder rootFolder) {
		elementsCollection = new ArrayList<File>();
		filesCollection = new ArrayList<File>();
		foldersCollection = new ArrayList<File>();
		this.rootFolder = rootFolder.folder;
		searchForFiles();
	}
	/**
	 * Recursive scanning
	 *
	 * @param fileFolder     Starting folder for a given step
	 */
	private void getFilesListRecursively(File fileFolder) {
		Folder folder = new Folder(fileFolder);
		elementsCollection.addAll(folder.elementsCollection);
		filesCollection.addAll(folder.filesCollection);
		foldersCollection.addAll(folder.subfoldersCollection);
		for (File file : folder.subfoldersCollection)
			getFilesListRecursively(file);
	}
	/**
	 * Initialization of recursive file system scanning
	 */
	private void searchForFiles() {
		getFilesListRecursively(rootFolder);
		elements = ArrayX.toArray(File.class, elementsCollection);
		files = ArrayX.toArray(File.class, filesCollection);
		folders = ArrayX.toArray(File.class, foldersCollection);
	}
	/**
	 * Gets elements found recursively starting from a given root folder.
	 * @return  Elements, that are files, found recursively starting from a given root folder.
	 */
	public File[] getElements() {
		return elements;
	}
	/**
	 * Gets elements, that are files, found recursively starting from a given root folder.
	 * @return  Elements, that are files, found recursively starting from a given root folder.
	 */
	public File[] getFiles() {
		return files;
	}
	/**
	 * Gets elements, that are folders, found recursively starting from a given root folder.
	 * @return  Elements, that are files, found recursively starting from a given root folder.
	 */
	public File[] getFolders() {
		return folders;
	}
	/**
	 * Gets collection of elements found recursively starting from a given root folder.
	 * @return  Elements, that are files, found recursively starting from a given root folder.
	 */
	public ArrayList<File> getElementsCollection() {
		return elementsCollection;
	}
	/**
	 * Gets collection of elements, that are files, found recursively starting from a given root folder.
	 * @return  Elements, that are files, found recursively starting from a given root folder.
	 */
	public ArrayList<File> getFilesCollection() {
		return filesCollection;
	}
	/**
	 * Gets collection of elements, that are folders, found recursively starting from a given root folder.
	 * @return  Elements, that are files, found recursively starting from a given root folder.
	 */
	public ArrayList<File> getFoldersCollection() {
		return foldersCollection;
	}
	/**
	 * Prints to the console all elements
	 * found recursively starting from a given root folder.
	 */
	public void printElements() {
		FileX.printFiles(elements);
	}
	/**
	 * Prints to the console elements, that are files,
	 * found recursively starting from a given root folder.
	 */
	public void printFiles() {
		FileX.printFiles(files);
	}
	/**
	 * Prints to the console elements, that are folders,
	 * found recursively starting from a given root folder.
	 */
	public void printFolders() {
		FileX.printFiles(folders);
	}
}
