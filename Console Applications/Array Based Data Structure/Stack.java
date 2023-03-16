
/**
 * This class is use to represent the data structure as stack
 *
 * @author (Yun-Ting Chen)
 * @version (v1.0)
 */
public class Stack {

	// declare array to store the value
	private Object[] stack = new Object[5];
	// count the total element in the array
	private int total = 0;

	// Add the object to array
	public void push(Object next) {
		// create a new copy array with fixed size
		Object[] newStack;

		// if total element is equal to the size of the array
		// copy all the elements to new array with fixed size
		if (total == stack.length) {
			newStack = new Object[stack.length * 2];

			for (int i = 0; i < stack.length; i++) {
				newStack[i] = stack[i];
			}

			// update array and total
			stack = newStack;
			stack[total] = next;
			total++;
		} else {
			stack[total] = next;
			total++;
		}
	}

	// remove the top(last) value in the array and return the removed value
	public Object pop() {
		Object obj = stack[total - 1];
		stack[total - 1] = null;
		total--;
		return obj;
	}

	// return total element count
	public int size() {
		return total;
	}

	// return the values in the list as string
	@Override
	public String toString() {
		String str = "";
		// use for loop to get each value in array
		for (int i = 0; i < total; i++) {
			str += stack[i];
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

	// Compare sizes and elements in the data structure
	public boolean equals(Object other) {
		// If the object is compared with itself then return true
		if (other == this) {
			return true;
		}

		/*
		 * Check if other is an instance of Stack or not "null instanceof [type]" also
		 * returns false
		 */
		if (!(other instanceof Stack)) {
			return false;
		}

		// typecast other to Stack so that we can compare data members
		Stack that = (Stack) other;

		// use if & for loop to check the size and element in the list
		if (this.size() == that.size()) {
			for (int i = 0; i < this.size(); i++) {
				if (!(this.stack[i] == that.stack[i])) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}
}
