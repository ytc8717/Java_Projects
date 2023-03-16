/*
 * This class is used to throw exceptions
 * 
 * Yun-Ting Chen
 */
public class GroceryException extends Exception {

	// declare two constructors
	public GroceryException(String msg) {
		super(msg);
	}

	public GroceryException() {
		super("ERROR");
	}
}
