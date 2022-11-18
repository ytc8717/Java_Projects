
/*
 * This class uses binary search method to find the target
 * 
 * @Author: Yun-Ting Chen
 */
public class BinarySearch extends SearchAlgorithm {

	// Iterative binary search method
	@Override
	public int search(String[] words, String wordToFind) throws ItemNotFoundException {

		int left = 0; // left index
		int right = words.length - 1; // right index
		int middle;

		while (left <= right) {
			middle = (left + right) / 2;
			incrementCount();

			if (words[middle].equals(wordToFind)) {
				return middle; // return meddle if target is found
			}

			if (words[middle].compareTo(wordToFind) > 0) {
				right = middle - 1;
			} else if (words[middle].compareTo(wordToFind) < 0) {
				left = middle + 1;
			}
		}
		throw new ItemNotFoundException(); // throw exception if not found
	}

	// Recursive binary search method
	@Override
	public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
		int leftIndex = 0;
		int rightIndex = words.length - 1;
		int midIndex = rightIndex / 2;
		return recSearch(words, wordToFind, leftIndex, rightIndex, midIndex);
	}

	// helper function for recSearch method
	private int recSearch(String[] words, String wordToFind, int left, int right, int mid)
			throws ItemNotFoundException {

		while (left <= right) {
			this.incrementCount();
			if (wordToFind.equals(words[mid]))
				return mid;
			if (wordToFind.compareTo(words[mid]) < 0)
				return recSearch(words, wordToFind, left, mid - 1, left + ((mid - 1 - left) / 2));
			else
				return recSearch(words, wordToFind, mid + 1, right, (mid + 1) + ((right - mid) / 2));
		}
		throw new ItemNotFoundException();
	}

}
