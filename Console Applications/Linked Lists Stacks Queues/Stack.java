
/*
 * This class extends the List super class to represent the stack data structure.
 * 
 * @Author: Yun-Ting Chen
 */
public class Stack extends List {

	// insert the object to the beginning of the list
	public void push(Object obj) throws LinkedListException {
		super.insert(obj, 0);
	}

	// removes the object from the beginning of the list
	public Object pop() throws LinkedListException {
		return super.remove(0);
	}

	// override the insert method
	@Override
	public void insert(Object next, int index) throws LinkedListException {
		this.push(next);
	}

	// override the remove method
	@Override
	public Object remove(int index) throws LinkedListException {
		return this.pop();
	}

	// test driver method
	public static void main(String[] args) {
		Stack stack = new Stack();
		for (int i = 1; i <= 10; i++) {
			stack.push(i);
			System.out.println(stack.toString());
		}

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

		// stack.pop(); //test that attempts to pop elements from an empty list
	}
}
