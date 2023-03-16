
/*
 * This class is used to throw exceptions
 * 
 * @Author: Yun-Ting Chen
 */
public class ItemNotFoundException extends Exception {
	
	// declare two constructors
	public ItemNotFoundException() {
		super("Item not found.");
	}

	public ItemNotFoundException(String message) {
		super(message);
	}
}
