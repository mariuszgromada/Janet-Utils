/*
 * @(#)FileX.java        1.0.0    2016-01-18
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.mariuszgromada.janetutils.ArrayX;
import org.mariuszgromada.janetutils.ErrorCodes;
import org.mariuszgromada.janetutils.StringX;

/**
 * Class implements general purpose methods
 * helping to work File object.
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
public final class FileX {
	/**
	 * If case sensitive indicator
	 * for whole org.mariuszgromada.utils.io.* package.
	 */
	private static boolean CASE_SENSITIVE = false;
	/**
	 * Call this method to set Case Sensitive mode
	 * for whole org.mariuszgromada.utils.io.* package.
	 */
	public static final void setCaseSensitive() {
		CASE_SENSITIVE = true;
	}
	/**
	 * Call this method to set Case Insensitive mode
	 * for whole org.mariuszgromada.utils.io.* package.
	 */
	public static final void setCaseInsensitive() {
		CASE_SENSITIVE = false;
	}
	/**
	 * Verify Case Sensitive mode
	 * for whole org.mariuszgromada.utils.io.* package.
	 */
	public static final boolean isCaseSensitive() {
		return CASE_SENSITIVE;
	}
	/**
	 * Verify Case Insensitive mode
	 * for whole org.mariuszgromada.utils.io.* package.
	 */
	public static final boolean isCaseInsensitive() {
		return !CASE_SENSITIVE;
	}
	/**
	 *
	 * Gets file extension.
	 *
	 * @param fullFilePath    Full file path
	 * @return                The file extension name (i.e.: jpg, html)
	 */
	public static final String getExtName(String fullFilePath) {
		if (fullFilePath == null) return ErrorCodes.CODE_STR_NULL_PARAMETER;
		if (fullFilePath.length() == 0) return ErrorCodes.CODE_STR_NOTHING_TO_PROCESS;
		String fileExt = "";
		if (fullFilePath != null) {
			int dotLastIndex = fullFilePath.lastIndexOf('.');
			if ( (dotLastIndex >= 0) && (dotLastIndex < fullFilePath.length()-1) )
				fileExt = fullFilePath.substring(dotLastIndex + 1);
		}
		if (isCaseInsensitive())
			fileExt = fileExt.toLowerCase();
		return fileExt;
	}
	/**
	 * Gets file extension.
	 *
	 * @param file            File object containing file definition.
	 * @return                The file extension name (i.e.: jpg, html)
	 */
	public static final String getExtName(File file) {
		if (file == null) return ErrorCodes.CODE_STR_NULL_PARAMETER;
		if (file.getName().length() == 0) return ErrorCodes.CODE_STR_NOTHING_TO_PROCESS;
		return getExtName(file.getName());
	}
	/**
	 * Checks whether file extension matches one of the given extension.
	 *
	 * @param file            File object containing file definition.
	 * @param extsList        String variadic params containing file list of file
	 *                        extension to compare (i.e.: "jpg", "html").
	 * @return                True if file extension was matched (case insensitive),
	 *                        false otherwise.
	 */
	public static final boolean fileExtIs(File file, String... extsList) {
		String fileExt = getExtName(file);
		if (isCaseInsensitive()) {
			fileExt = fileExt.toLowerCase();
			for (String ext : extsList)
				ext = ext.toLowerCase();
		}
		for (String ext : extsList) {
			if (fileExt.equals(ext))
				return true;
		}
		return false;
	}
	/**
	 * Check whether file extension are the same
	 *
	 * @param file1     File object 1
	 * @param file2     File object 2
	 *
	 * @return          True if extensions are the same, otherwise false.
	 */
	public static final boolean theSameFileExts(File file1, File file2) {
		String ext1 = getExtName(file1);
		String ext2 = getExtName(file2);
		if (isCaseInsensitive()) {
			ext1 = ext1.toLowerCase();
			ext2 = ext2.toLowerCase();
		}
		if (ext1.equals(ext2))
			return true;
		else
			return false;
	}
	/**
	 * Returns file name without last '.' and without extension string
	 *
	 * @param fileName        String containing file name
	 * @return                File name without extension.
	 */
	public static final String getNameWithouExt(String fileName) {
		if (fileName == null) return ErrorCodes.CODE_STR_NULL_PARAMETER;
		if (fileName.length() == 0) return ErrorCodes.CODE_STR_NOTHING_TO_PROCESS;
		File file = new File(fileName);
		return getNameWithouExt(file);
	}
	/**
	 * Returns file name without last '.' and without extension string
	 *
	 * @param file            File object containing file definition.
	 * @return                File name without extension.
	 */
	public static final String getNameWithouExt(File file) {
		if (file == null) return ErrorCodes.CODE_STR_NULL_PARAMETER;
		String fileName = file.getName();
		if (fileName.length() == 0) return ErrorCodes.CODE_STR_NOTHING_TO_PROCESS;
		String fileNameWithoutExt = fileName;
		if (fileName != null) {
			int dotLastIndex = fileName.lastIndexOf('.');
			if (dotLastIndex > 0)
				fileNameWithoutExt = fileName.substring(0, dotLastIndex);
			else if (dotLastIndex == 0)
				fileNameWithoutExt = "";
		}
		return fileNameWithoutExt;
	}
	/**
	 * Prints file list to the console
	 *
	 * @param files           Array File objects
	 */
	public static final void printFiles(File[] files) {
		for (int i = 0; i < files.length; i++) {
			if ( files[i].isFile() )
				System.out.print(i + ". file: ");
			else
				System.out.print(i + ". dir : ");
			System.out.println(files[i].getName() + "     " + FileX.getNameWithouExt(files[i]) + "     " + FileX.getExtName(files[i]) + "     :     " + files[i].getPath());
		}
	}
	/**
	 * Prints file collection to the console
	 *
	 * @param files           Collection of File objects
	 */
	public static final void printFiles(ArrayList<File> files) {
		for (int i = 0; i < files.size(); i++) {
			if ( files.get(i).isFile() )
				System.out.print(i + ". file: ");
			else
				System.out.print(i + ". dir : ");
			System.out.println(files.get(i).getName() + "     " + FileX.getNameWithouExt(files.get(i)) + "     " + FileX.getExtName(files.get(i)) + "     :     " + files.get(i).getPath());
		}
	}
	/**
	 * Reads one file into one resulting String object.
	 *
	 * @param file            File object containing file definition.
	 * @return                If file reading was successful returns
	 *                        String with file content, otherwise
	 *                        returns null. Method do not throws
	 *                        IOException.
	 */
	public static final String readFile(File file)  {
		if (file == null) return ErrorCodes.CODE_STR_NULL_PARAMETER;
		String fileContent = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				fileContent = "";
				String line = null;
				while ((line = br.readLine()) != null) {
					fileContent = fileContent + line + "\n";
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
				return ErrorCodes.CODE_STR_UNKNOWN_ERROR;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return ErrorCodes.CODE_STR_INCORRECT_PARAMETER;
		}
		return fileContent;
	}
	/**
	 * Reads one file into one resulting String object.
	 *
	 * @param filePath        Full path to the file.
	 * @return                If file reading was successful returns
	 *                        String with file content, otherwise
	 *                        returns null. Method do not throws
	 *                        IOException.
	 */
	public static final String readFile(String filePath)  {
		if (filePath == null) return ErrorCodes.CODE_STR_NULL_PARAMETER;
		if (filePath.length() == 0) return ErrorCodes.CODE_STR_NOTHING_TO_PROCESS;
		return readFile(new File(filePath));
	}
	/**
	 * Reads file lines into separate strings stored in ArrayList.
	 *
	 * @param file            File object containing file definition.
	 * @return                If file reading was successful returns
	 *                        ArrayList<String> containing each lines
	 *                        from the file content, otherwise
	 *                        returns null. Method do not throws
	 *                        IOException.
	 */
	public static final ArrayList<String> readFileLines2ArraList(File file) {
		ArrayList<String> fileContent = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				fileContent = new ArrayList<String>();
				String line = null;
				while ((line = br.readLine()) != null) {
					fileContent.add(line);
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return fileContent;
	}
	/**
	 * Reads file lines into separate strings stored in ArrayList.
	 *
	 * @param filePath        Full path to the file.
	 * @return                If file reading was successful returns
	 *                        ArrayList<String> containing each lines
	 *                        from the file content, otherwise
	 *                        returns null. Method do not throws
	 *                        IOException.
	 */
	public static final ArrayList<String> readFileLines2ArraList(String filePath) {
		return readFileLines2ArraList(new File(filePath));
	}
	/**
	 * Reads file lines into separate strings stored in String[] array.
	 *
	 * @param file            File object containing file definition.
	 * @return                If file reading was successful returns
	 *                        String[] array containing each lines
	 *                        from the file content, otherwise
	 *                        returns null. Method do not throws
	 *                        IOException.
	 */
	public static final String[] readFileLines2Array(File file)  {
		String[] fileLines = null;
		ArrayList<String> fileContent = readFileLines2ArraList(file);
		if (fileContent != null)
			fileLines = ArrayX.toArray(String.class, fileContent);
		return fileLines;
	}
	/**
	 * Reads file lines into separate strings stored in String[] array.
	 *
	 * @param filePath        Full path to the file.
	 * @return                If file reading was successful returns
	 *                        String[] array containing each lines
	 *                        from the file content, otherwise
	 *                        returns null. Method do not throws
	 *                        IOException.
	 */
	public static final String[] readFileLines2Array(String filePath)  {
		return readFileLines2Array(new File(filePath));
	}
	/**
	 * Writes the given string into the the given file, previous file
	 * content will be overwritten.
	 *
	 * @param file            File object containing file definition.
	 * @param content         String containing content to be written.
	 * @return                True if write was successful, otherwise
	 *                        returns false. Method do not throws
	 *                        IOException.
	 */
	public static boolean writeFile(File file, String content) {
		FileWriter fw;
		try {
			fw = new FileWriter(file);
			fw.write(content);
			fw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * Writes the given string into the the given file, previous file
	 * content will be overwritten.
	 *
	 * @param filePath        Full path to the file.
	 * @param content         String containing content to be written.
	 * @return                True if write was successful, otherwise
	 *                        returns false. Method do not throws
	 *                        IOException.
	 */
	public static boolean writeFile(String filePath, String content) {
		return writeFile( new File(filePath), content);
	}
	/**
	 * Writes the given collection of strings into the the given file, previous file
	 * content will be overwritten. New line character will not be added after each string.
	 *
	 * @param file            File object containing file definition.
	 * @param content         String collection containing content to be written.
	 * @return                True if write was successful, otherwise
	 *                        returns false. Method do not throws
	 *                        IOException.
	 */
	public static boolean writeFile(File file, Collection<String> content) {
		FileWriter fw;
		try {
			fw = new FileWriter(file);
			for (String line : content) {
				fw.write(line);
			}
			fw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * Writes the given collection of strings into the the given file, previous file
	 * content will be overwritten. New line character will not be added after each string.
	 *
	 * @param filePath        Full path to the file.
	 * @param content         String collection containing content to be written.
	 * @return                True if write was successful, otherwise
	 *                        returns false. Method do not throws
	 *                        IOException.
	 */
	public static boolean writeFile(String filePath, Collection<String> content) {
		return writeFile( new File(filePath), content);
	}
	/**
	 * Writes the given collection of strings into the the given file, previous file
	 * content will be overwritten. New line character will be added after each string.
	 *
	 * @param file            File object containing file definition.
	 * @param content         String collection containing content to be written.
	 * @return                True if write was successful, otherwise
	 *                        returns false. Method do not throws
	 *                        IOException.
	 */
	public static boolean writeFileLines(File file, Collection<String> content) {
		FileWriter fw;
		try {
			fw = new FileWriter(file);
			for (String line : content) {
				fw.write(line + "\n");
			}
			fw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * Writes the given collection of strings into the the given file, previous file
	 * content will be overwritten. New line character will be added after each string.
	 *
	 * @param filePath        Full path to the file.
	 * @param content         String collection containing content to be written.
	 * @return                True if write was successful, otherwise
	 *                        returns false. Method do not throws
	 *                        IOException.
	 */
	public static boolean writeFileLines(String filePath, Collection<String> content) {
		return writeFileLines( new File(filePath), content);
	}
	/**
	 * Creates directory given by the specified path
	 * 
	 * @param dirPath         Directory name.
	 * @return                True if directory was created, false otherwise.
	 */
	public static final boolean makeDir(String dirPath) {
		if (dirPath == null) return false;
		if (dirPath.length() == 0) return false;
		File dir = new File(dirPath);
		return dir.mkdir();
	}
	/**
	 * Removes empty directory denoted as directory path.
	 * 
	 * @param dirPath         Directory name.
	 * @return                True if directory was removed, false otherwise.
	 */
	public static final boolean removeDir(String dirPath) {
		if (dirPath == null) return false;
		if (dirPath.length() == 0) return false;
		File dir = new File(dirPath);
		if ( dir.isDirectory() == false) return false;
		return dir.delete();
	}
	/**
	 * Removes file denoted as file path.
	 * 
	 * @param filePath         File pathname.
	 * @return                 True if file was removed, false otherwise.
	 */
	public static final boolean removeFile(String filePath) {
		if (filePath == null) return false;
		if (filePath.length() == 0) return false;
		File file = new File(filePath);
		if ( file.isFile() == false) return false;
		return file.delete();
	}
	/**
	 * Removes file denoted as file path.
	 * 
	 * @param file             File object.
	 * @return                 True if file was removed, false otherwise.
	 */
	public static final boolean removeFile(File file) {
		if (file == null) return false;
		if ( file.isFile() == false) return false;
		return file.delete();
	}
	/**
	 * Generates random file name.
	 * @param length    File name length (without extension).
	 * @param fileExt   File extension.
	 * @return          Random file name containing a-zA-Z0-9.
	 */
	public static final String genRndFileName(int length, String fileExt) {
		if (length <= 0) return ErrorCodes.CODE_STR_INCORRECT_PARAMETER;
		if (fileExt == null) return ErrorCodes.CODE_STR_NULL_PARAMETER;
		return StringX.randomString(length) + "." + fileExt;
	}
	/**
	 * Returns temporary directory location.
	 * @return Temporary directory location.
	 */
	public static final String getTmpDir() {
		return System.getProperty("java.io.tmpdir");
	}
}