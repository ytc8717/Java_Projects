
/*
 * This the driver to test the findFile class methods
 * 
 * @Author: Yun-Ting Chen
 */
public class Driver {
	public static void main(String[] args) {

		String targetFile = ".txt"; // target file
		String filePath = "/Users/bioha/Desktop"; // file path on my machine
		FindFile find = new FindFile(100); // declare FindFile instance

		// try catch block to throw the exception
		try {
			find.directorySearch(targetFile, filePath); // call the method to find file
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("MAX_NUMBER_OF_FILES_TO_FIND");
		}

		// print out the results
		System.out.println(find.getCount() + " files found");
		String[] location = find.getFiles();

		System.out.println("File location:");
		for (int i = 0; i < location.length; i++) {
			if (location[i] != null)
				System.out.println(location[i]);
		}
	}
}
