/*
 * @(#)SnippetInjectorIntoJavaDoc.java        0.0.1    2016-01-18
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
package org.mariuszgromada.utils.javadoc;

import java.io.File;
import java.util.ArrayList;

import org.mariuszgromada.utils.io.FileX;
import org.mariuszgromada.utils.io.FilesListRecursive;

/**
 * Google Analytics snippet injection into each html file
 * generated using JAVADOC tool. Master title changing (title of the window, not the document).
 * WARNING!!!!! Software overwrites all found html files  !!!!!
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
 * @version        0.0.1
 */
public class SnippetInjectorIntoJavaDoc {
	/**
	 * JAVADOC root folder
	 */
	private File rootFolder;
	/**
	 * Object for recursive file system scan
	 */
	private FilesListRecursive filesList;
	/**
	 * Files list
	 */
	private File[] files;
	/**
	 * Google Analytics snippet
	 */
	private String gaSnippet;
	/**
	 * Master title
	 */
	private String pageMasertTitle;
	/**
	 * Constructor based on string path to the JAVADOC folder.
	 * @param rootFolderPath   Full path to the JAVADOC main folder.
	 */
	public SnippetInjectorIntoJavaDoc(String rootFolderPath) {
		rootFolder = new File(rootFolderPath);
		filesList = new FilesListRecursive(rootFolder);
		files = filesList.getFiles();
		gaSnippet = "";
		pageMasertTitle = "";
	}
	/**
	 * Add full google analytics tracking code
	 *
	 * @param gaSnippet   Single line string containing google analytics tracking code
	 */
	public void addGoogleAnalyticsSnippet(String gaSnippet) {
		this.gaSnippet = gaSnippet;
	}
	/**
	 * Add master title to each page, by default JAVADOC
	 * gives the class name between <title></title>.
	 *
	 * This method allows to add something more than that :-)
	 *
	 * @param masterTitle   Single line string containing title,
	 * title will appear after class name.
	 */
	public void addMasterTitle(String masterTitle) {
		this.pageMasertTitle = masterTitle;
	}
	/**
	 * Start injecting defined snippets
	 */
	public void injectSnippets() {
		for (File file : files) {
			if ( FileX.fileExtIs(file, "html") )
				injectSnippet(file);
		}
	}
	/**
	 * Injects snippets into the given file
	 * @param file   FIle object
	 */
	private void injectSnippet(File file) {
		ArrayList<String> fileContent = FileX.readFileLines2ArraList(file);
		if (fileContent != null) {
			int numberOfLines = fileContent.size();
			if (numberOfLines > 0)
				for (int i = 0; i < numberOfLines; i++) {
					String line = fileContent.get(i);
					String lineLowerCase = line.toLowerCase();
					int titleEndIndex = lineLowerCase.indexOf("</title>");
					int headEndIndex = lineLowerCase.indexOf("</head>");
					if (titleEndIndex >= 0) {
						String newLine = line.substring(0, titleEndIndex) + pageMasertTitle + line.substring(titleEndIndex);
						fileContent.set(i, newLine);
					}
					if (headEndIndex >= 0) {
						fileContent.add(i, gaSnippet);
						numberOfLines++;
						i++;
					}
				}
				for (int i = 0; i < numberOfLines; i++) {
					System.out.println(fileContent.get(i));
				}
				FileX.writeFileLines(file, fileContent);
		}
	}
}
