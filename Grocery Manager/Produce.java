/*
 * This class is used to represent the Produce item in grocery
 * 
 * Yun-Ting Chen
 */
public class Produce extends GroceryItem {

	// instance data
	private boolean isOrganic;

	// constructor
	public Produce(String name, int quantity, double price, boolean isOrganic) {
		// call the super constructor to initialize the data
		super(name, quantity, price);
		// initialize instance data
		this.isOrganic = isOrganic;
	}

	// constructor
	public Produce(String name, int quantity) {
		// call the super constructor to initialize the data
		super(name, quantity, 0);
		// initialize instance data
		this.isOrganic = false;
	}

	// constructor that takes the inputLine from txt file
	public Produce(String inputLine) {
		// split the string into parts
		String[] qparts = inputLine.split(" ");

		// get each data from the array
		String name = qparts[1];
		int quantity = Integer.parseInt(qparts[2]);
		double price = Double.parseDouble(qparts[3]);
		this.isOrganic = Boolean.parseBoolean(qparts[4]);

		// call super to set each data value
		super.setName(name);
		super.setQuantity(quantity);
		super.setPrice(price);
	}

	// initialize the boolean organic value
	public void isOrganic(boolean organic) {
		this.isOrganic = organic;
	}

	// return isOrganic
	public boolean getIsOrganic() {
		return isOrganic;
	}

	// return string value of produce
	@Override
	public String toString() {
		// call the super to attach the organic data in string
		return super.toString() + "organic: " + isOrganic;
	}
}
