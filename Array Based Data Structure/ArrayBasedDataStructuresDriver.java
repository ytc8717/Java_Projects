
/**
 * This class is use to test out the method for the three data structure:
 * ArrayList, Stack, and Queue.
 *
 * @author (Yun-Ting Chen)
 * @version (v1.0)
 */
public class ArrayBasedDataStructuresDriver {

	public static void main(String[] args) {
		// call the test methods
		stackTests();
		queueTests();
		arrayListTests();
	}

	/*
	 * This method is used to call out all the methods in the ArrayList class to
	 * test if the output value is correct or not
	 */
	private static void arrayListTests() {

		System.out.println("ArrayList Test:");

		ArrayList a = new ArrayList();
		ArrayList b = new ArrayList();
		ArrayList c = new ArrayList();

		c = a;

		a.insert('B', 0);
		a.insert('a', 1);
		a.insert('t', 2);

		System.out.println(a.size());
		System.out.println(a.toString());

		a.insert('m', 3);
		a.insert('a', 4);
		a.insert('n', 6);

		System.out.println(a.size());

		System.out.println(a.toString());

		System.out.println(a.indexOf('a'));

		if (a.isEmpty() == false) {
			System.out.println(a.remove(1));
		}

		System.out.println(a.toString());

		System.out.println(a.size());

		if (b.isEmpty() == true) {
			System.out.println("empty list");
		}

		System.out.println(b.indexOf('b'));

		System.out.println(a.equals(b));

		System.out.println(a.equals(c));

		System.out.println(c.get(4));
	}

	/*
	 * This method is used to call out all the methods in the Queue class to test if
	 * the output value is correct or not
	 */
	private static void queueTests() {

		System.out.println("Queue Test:");

		Queue a = new Queue();
		Queue b = new Queue();
		Queue c = new Queue();

		c = a;

		a.enqueue('B');
		a.enqueue('a');
		a.enqueue('t');

		System.out.println(a.toString());
		System.out.println(a.size());

		while (a.isEmpty() == false) {
			System.out.println(a.dequeue());
		}

		a.dequeue();

		System.out.println(a.toString());
		System.out.println(a.size());

		a.enqueue('d');

		System.out.println(a.toString());
		System.out.println(a.size());

		a.enqueue('d');
		a.enqueue('y');

		System.out.println(a.toString());
		System.out.println(a.size());

		System.out.println(a.equals(b));
		System.out.println(a.equals(c));

	}

	/*
	 * This method is used to call out all the methods in the Stack class to test if
	 * the output value is correct or not
	 */
	private static void stackTests() {

		System.out.println("Stack Test:");

		Stack a = new Stack();
		Stack b = new Stack();
		Stack c = new Stack();

		b = a;

		a.push('B');
		a.push('a');
		a.push('t');
		a.push('v');
		a.push('n');
		a.push('t');

		System.out.println(a.toString());
		System.out.println(a.size());

		if (a.isEmpty() == false) {
			System.out.println(a.pop());
		}

		System.out.println(a.toString());
		System.out.println(a.size());

		a.push('d');

		System.out.println(a.toString());
		System.out.println(a.size());

		System.out.println(a.equals(b));
		System.out.println(a.equals(c));
	}

}
