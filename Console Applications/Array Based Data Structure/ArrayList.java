
/**
 * This class is use to represent the data structure as ArrayList
 *
 * @author (Yun-Ting Chen)
 * @version (v1.0)
 */
public class ArrayList {

	// declare array to store the value
	private Object[] list = new Object[5];
	// count the total element in the array
	private int total = 0;

	// Add the object at the specified index
	public void insert(Object next, int index) {
		// if index is greater than total
		// print out the error message and exit method
		if (index > total) {
			System.out.println("Index out of bounds: " + next + " index: " + index);
			return;
		}

		// create new array to copy the element in the list array
		Object[] newList;

		// if total element is equal to the size of the array
		// copy all the elements to new array with fixed size
		if (total == list.length) {
			newList = new Object[list.length * 2];
			for (int i = 0; i < index; i++) {
				newList[i] = list[i];
			}
			newList[index] = next;
			for (int i = index; i < list.length; i++) {
				newList[i + 1] = list[i];
			}
			// update total elements and array
			total++;
			list = newList;
		} else {
			for (int i = total; i > index; i--) {
				list[i] = list[i - 1];
			}
			list[index] = next;
			total++;
		}
	}

	// Remove and return the object at the specified index
	public Object remove(int index) {
		// get the value from the list at the specified index
		Object obj = list[index];
		// update total element
		total--;

		// re-arrange the elements in the array
		for (int i = index; i < total; i++) {
			list[i] = list[i + 1];
		}
		return obj;
	}

	// return the total element count
	public int size() {
		return total;
	}

	// return the values in the list as string
	@Override
	public String toString() {
		String str = "";
		// use for loop to get each value in array
		for (int i = 0; i < total; i++) {
			str += list[i];
		}
		return str;
	}

	// check if array is empty
	public boolean isEmpty() {
		boolean empty = false;
		if (total == 0) {
			empty = true;
		}
		return empty;
	}

	// return the index of the specified target
	public int indexOf(Object target) {
		// Returns -1 if not found
		int index = -1;

		// use for loop to get the index
		for (int i = 0; i < list.length; i++) {
			if (list[i] == target) {
				index = i;
			}
		}
		return index;
	}

	// Compare sizes and elements in the data structure
	public boolean equals(Object other) {
		// If the object is compared with itself then return true
		if (other == this) {
			return true;
		}

		/*
		 * Check if other is an instance of ArrayList or not "null instanceof [type]"
		 * also returns false
		 */
		if (!(other instanceof ArrayList)) {
			return false;
		}

		// typecast other to ArrayList so that we can compare data members
		ArrayList that = (ArrayList) other;

		// use if & for loop to check the size and element in the list
		if (this.size() == that.size()) {
			for (int i = 0; i < this.size(); i++) {
				if (!(list[i] == that.list[i])) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	// Returns the object at index specified
	public Object get(int index) {
		return list[index];
	}
}
