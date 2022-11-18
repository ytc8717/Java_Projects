
/**
 * This class is use to represent the data structure as queue
 *
 * @author (Yun-Ting Chen)
 * @version (v1.0)
 */
public class Queue {

	// declare array to store the value
	private Object[] queue = new Object[5];
	// count the total element in the array
	private int total = 0;

	// Add the object to array
	public void enqueue(Object next) {
		// create a new copy array with fixed size
		Object[] newQueue;

		// if total element is equal to the size of the array
		// copy all the elements to new array with fixed size
		if (total == queue.length) {
			newQueue = new Object[queue.length * 2];
			for (int i = 0; i < queue.length; i++) {
				newQueue[i] = queue[i];
			}
			// update array and total
			queue = newQueue;
			queue[total] = next;
			total++;
		} else {
			queue[total] = next;
			total++;
		}
	}

	// remove the first value in the array and return the removed value
	public Object dequeue() {
		// create new copy array
		Object[] newQueue = new Object[queue.length];
		int index = 0;
		Object obj = queue[0];

		// use for loop to re-arrange the array
		for (int i = 1; i < queue.length; i++) {
			newQueue[index] = queue[i];
			index++;
		}

		// update array with new array
		queue = newQueue;

		// if total is not equal to zero
		// total -1
		if (total != 0)
			total--;
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
			str += queue[i];
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
		 * Check if other is an instance of Queue or not "null instanceof [type]" also
		 * returns false
		 */
		if (!(other instanceof Queue)) {
			return false;
		}

		// typecast other to Queue so that we can compare data members
		Queue that = (Queue) other;

		// use if & for loop to check the size and element in the list
		if (this.size() == that.size()) {
			for (int i = 0; i < this.size(); i++) {
				if (!(this.queue[i] == that.queue[i])) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}
}
