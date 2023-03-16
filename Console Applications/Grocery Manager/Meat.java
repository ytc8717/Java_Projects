/*
 * This class is used to represent the meat item in grocery
 * 
 * Yun-Ting Chen
 */
public class Meat extends GroceryItem {

	// instance data
	private boolean isGround;

	// constructor
	public Meat(String name, int quantity, double price, boolean isGround) {
		// call super constructor to initialize the data
		super(name, quantity, price);
		// initialize instance data
		this.isGround = isGround;
	}

	// constructor
	public Meat(String name, int quantity) {
		// call super constructor to initialize the data
		super(name, quantity, 0);
		// initialize instance data
		this.isGround = false;
	}

	// constructor that takes inputLine from txt file
	public Meat(String inputLine) {
		// split the string in parts
		String[] qparts = inputLine.split(" ");

		// get the data from the array
		String name = qparts[1];
		int quantity = Integer.parseInt(qparts[2]);
		double price = Double.parseDouble(qparts[3]);
		this.isGround = Boolean.parseBoolean(qparts[4]);

		// call super to set the data
		super.setName(name);
		super.setQuantity(quantity);
		super.setPrice(price);
	}

	// initialize the isGround instance data
	public void isGround(boolean ground) {
		this.isGround = ground;
	}

	// return boolean value isGround
	public boolean getIsGround() {
		return isGround;
	}

	// return string value of meat
	@Override
	public String toString() {
		// call the super to attach the ground data in string
		return super.toString() + "Ground: " + isGround;
	}
}
