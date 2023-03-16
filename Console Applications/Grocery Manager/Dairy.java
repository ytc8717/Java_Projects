/*
 * This class is used to represent the Dairy item in grocery
 * 
 * Yun-Ting Chen
 */
public class Dairy extends GroceryItem {

	// instance data
	private int refrigerationTemperature;

	// constructor
	public Dairy(String name, int quantity, double price, int refrigerationTemperature) {
		// call the super constructor to initialize the data
		super(name, quantity, price);
		// initialize the instance data
		this.refrigerationTemperature = refrigerationTemperature;
	}

	// constructor
	public Dairy(String name, int quantity) {
		// call the super constructor to initialize the data
		super(name, quantity, 0);
		// initialize the instance data
		this.refrigerationTemperature = 0;
	}

	// constructor that takes the inputLine from the txt data
	public Dairy(String inputLine) {
		// split the string into parts
		String[] qparts = inputLine.split(" ");

		// get each data from the array
		String name = qparts[1];
		int quantity = Integer.parseInt(qparts[2]);
		double price = Double.parseDouble(qparts[3]);
		this.refrigerationTemperature = Integer.parseInt(qparts[4]);

		// call the super to set each data
		super.setName(name);
		super.setQuantity(quantity);
		super.setPrice(price);
	}

	// initialize the refrigerationTemperature from given value
	public void setRefrigerationTemperature(int temp) {
		this.refrigerationTemperature = temp;
	}

	// return refrigerationTemperature
	public int getRefrigerationTemperature() {
		return refrigerationTemperature;
	}

	// // return string value of dairy
	@Override
	public String toString() {
		// // call the super to attach the Temperature data in string
		return super.toString() + "Temperature: " + refrigerationTemperature;
	}
}
