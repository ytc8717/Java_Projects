import java.io.*;
import java.util.*;

/*
 * This class is used to find the target file
 * 
 * @Author: Yun-Ting Chen
 */
public class FindFile {

	// declare instance variables
	private int maxFiles;
	private int count;
	private String[] locations;

	// constructor to initialize the values
	public FindFile(int maxFiles) {
		this.maxFiles = maxFiles;
		this.locations = new String[maxFiles];
	}

	// search the file based on the given values
	public void directorySearch(String target, String dirName) {
		// Create file object
		File f = new File(dirName);

		// check if it is directory
		if (f.isDirectory()) {
			String[] fileList = f.list();

			for (int i = 0; i < fileList.length; i++) {
				directorySearch(target, dirName + "/" + fileList[i]);
			}
		} else if (target
				.equals(dirName.substring(((dirName.length() - 1) - (target.length() - 1)), (dirName.length())))) {
			if (count < maxFiles) {
				locations[count++] = dirName;
			} else {
				// throw exception
				throw new IllegalArgumentException("MAX_NUMBER_OF_FILES_TO_FIND");
			}
		}
	}

	// return the total count
	public int getCount() {
		return count;
	}

	// return the locations
	public String[] getFiles() {
		return locations;
	}
}
