
/*
 * This class represents the Linked List data structure.
 * 
 * @Author: Yun-Ting Chen
 */
public class List {

	// the start of the linked list
	private Node head = null;

	// inner Node class
	private class Node {
		Object data = null;
		Node next = null;

		// constructor that initialize the value
		public Node(Object data) {
			this.data = data;
			this.next = null;
		}
	}

	// insert the object at the position specified by index
	public void insert(Object next, int index) {

		// check if the given index is valid of not
		if (index < 0 || index > size()) {
			throw new LinkedListException("Index out of bounds");
		}

		// If adding to an empty list (changes head)
		if (head == null) {
			head = new Node(next);
			return;
		}

		// if index equals 0 (changes head)
		if (index == 0) {
			Node new_node = new Node(next);
			new_node.next = head;
			head = new_node;
			return;
		}

		// get the prev node value
		Node prev_node = head;
		for (int i = 0; i < index - 1; i++) {
			prev_node = prev_node.next;
		}

		// update the list
		Node new_node = new Node(next);
		new_node.next = prev_node.next;
		prev_node.next = new_node;

	}

	// find and delete the node at the position specified by index
	public Object remove(int index) {

		// check if the given index is valid of not
		if (index < 0 || index > size()) {
			throw new LinkedListException("Index out of bounds");
		}

		// if head equals null do nothing
		if (head == null) {
			throw new LinkedListException("cannot remove from empty list");
		}

		Node temp = head;

		// delete value at index 0 and update list
		if (index == 0) {
			head = temp.next;
			return temp.data;
		}

		for (int i = 0; temp != null && i < index - 1; i++) {
			temp = temp.next;
		}

		if (temp == null || temp.next == null) {
		}

		// update list
		Node next = temp.next;
		temp.next = temp.next.next;
		return next.data;
	}

	// return the size of the list
	public int size() {
		int count = 0;
		Node current = head;
		while (current != null) {
			current = current.next;
			count++;
		}
		return count;
	}

	// return the values in the list as string
	@Override
	public String toString() {
		String str = "";
		Node current = head;
		while (current != null) {
			str += current.data + (current.next == null ? "" : ", ");
			current = current.next;
		}
		return str;
	}

	// returns true if empty, false otherwise
	public boolean isEmpty() {
		return head == null;
	}

	// a sequential search that returns the index if found or -1 if not found
	public int indexOf(Object target) {
		int index = 0;
		Node current = head;
		while (!current.equals(null) && !current.data.equals(target)) {
			current = current.next;
			index++;
		}
		return index < size() ? index : -1;
	}

	// appends to the end of the list.
	public void append(Object obj) {
		Node new_node = new Node(obj);

		// If adding to an empty list (changes head)
		if (head == null) {
			head = new Node(obj);
			return;
		}

		new_node.next = null;

		Node last = head;
		while (last.next != null) {
			last = last.next;
		}

		last.next = new_node;
		return;
	}

	// test driver method
	public static void main(String[] args) {
		List empty = new List();
		List one = new List();
		List multiple = new List();

		one.append(5);
		multiple.append(10);
		multiple.append(20);
		multiple.append(30);
		multiple.insert(15, 0);

		System.out.println("Empty:" + empty);
		System.out.println("Empty is empty:" + empty.isEmpty());
		System.out.println("One:" + one.toString());
		System.out.println("One size:" + one.size());
		System.out.println("One is empty:" + one.isEmpty());
		System.out.println("Multiple:" + multiple.toString());
		System.out.println("Multiple size:" + multiple.size());
		System.out.println("Multiple indexOf test:" + multiple.indexOf(20));

		one.remove(0);
		multiple.remove(1);
		System.out.println("One (upon remove):" + one);
		System.out.println("Multiple (upon remove):" + multiple);
		multiple.remove(0);
		System.out.println("Multiple (upon remove):" + multiple);

		one.append(600);
		multiple.append(400);
		System.out.println("One (on append):" + one);
		System.out.println("Multiple(on append):" + multiple);

		// empty.remove(0); // remove elements from an empty list test
	}
}
