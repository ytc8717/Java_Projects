
/*
 * This class is used to throw the exceptions
 * 
 * @Author: Yun-Ting Chen
 */
public class LinkedListException extends RuntimeException {

	// declare two constructors
	public LinkedListException() {
		super("ERROR");
	}

	public LinkedListException(String msg) {
		super(msg);
	}
}
