
/*
 * This class extends the List super class to represent the queue data structure.
 * 
 * @Author: Yun-Ting Chen
 */
public class Queue extends List {

	// inserts the object to the beginning of the list
	public void enqueue(Object obj) throws LinkedListException {
		super.insert(obj, 0);
	}

	// removes the object from the end of the list
	public Object dequeue() throws LinkedListException {
		return super.remove(size() - 1);
	}

	// override the insert method
	@Override
	public void insert(Object next, int index) throws LinkedListException {
		this.enqueue(next);
	}

	// override the remove method
	@Override
	public Object remove(int index) throws LinkedListException {
		return this.dequeue();
	}

	// test driver method
	public static void main(String[] args) {
		Queue queue = new Queue();
		for (int i = 1; i <= 10; i++) {
			queue.enqueue(i);
			System.out.println(queue.toString());
		}

		while (!queue.isEmpty()) {
			System.out.println(queue.dequeue());
		}

		// queue.dequeue(); //test that attempts to dequeue elements from an empty queue
	}
}
