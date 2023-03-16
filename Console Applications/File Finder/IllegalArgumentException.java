
/*
 * This class is used to throw the exceptions
 * 
 * @Author: Yun-Ting Chen
 */
public class IllegalArgumentException extends RuntimeException {

	// declare two constructors
	IllegalArgumentException() {
		super("ERROR");
	}

	IllegalArgumentException(String msg) {
		super(msg);
	}
}