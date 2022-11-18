
/*
 * This class uses the linear search method to find the target
 * 
 * @Author: Yun-Ting Chen
 */
public class LinearSearch extends SearchAlgorithm {

	// Iterative linear search method
	@Override
	public int search(String[] words, String wordToFind) throws ItemNotFoundException {
		int index = 0;

		while (index < words.length && !(words[index].equalsIgnoreCase(wordToFind))) {
			incrementCount();
			index++;
		}

		if (index < words.length) {
			return index;
		} else {
			throw new ItemNotFoundException();
		}
	}

	// Recursive linear search method
	@Override
	public int recSearch(String[] words, String wordToFind) throws ItemNotFoundException {
		return recSearch(words, wordToFind, 0);
	}

	// Helper function for recSearch method
	private int recSearch(String[] words, String wordToFind, int index) throws ItemNotFoundException {
		if (index < 0) {
			throw new ItemNotFoundException();
		}

		if (words[index].equals(wordToFind)) {
			return index;
		}

		incrementCount();
		return recSearch(words, wordToFind, index + 1);
	}

}
