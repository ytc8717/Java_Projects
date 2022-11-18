/*
 * This is an abstract class that implements Comparable and is used to represent the grocery items
 * 
 * Yun-Ting Chen
 */
public abstract class GroceryItem implements Comparable {

	// instance data
	private String name;
	private int quantity;
	private double price;

	// constructor
	public GroceryItem() {
		// initialize the instance data
		this.name = null;
		this.quantity = 0;
		this.price = 0;
	}

	// constructor that takes in 3 arguments
	public GroceryItem(String name, int quantity, double price) {
		// initialize the instance data from given values
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	// initialize the instance name data
	public void setName(String name) {
		this.name = name;
	}

	// return name
	public String getName() {
		return name;
	}

	// initialize the instance price data
	public void setPrice(double price) {
		this.price = price;
	}

	// return price
	public double getPrice() {
		return price;
	}

	// initialize the instance quantity data
	public void setQuantity(int n) {
		this.quantity = n;
	}

	// return quantity
	public int getQuantity() {
		return quantity;
	}

	// return the info of grocery item as a string
	@Override
	public String toString() {
		// format the string output and return the info
		return String.format("Name: %-16s Price: $%-6.02f Quantity: %-3d ", name, price, quantity);
	}

	// compare two item by its name
	@Override
	public int compareTo(Object o) {
		// check if two object is the same and can be compared
		if (o.getClass() != this.getClass() || o == null) {
			// if not return -2
			return -2;
		}

		// Type-Casting to allow comparison
		GroceryItem other = (GroceryItem) o;

		// If this.name is less then return -1
		// if greater than other.name then return 1
		// else it's equal so return 0
		if (this.name.compareTo(other.name) < 0) {
			return -1;
		} else if (this.name.compareTo(other.name) > 0) {
			return 1;
		} else {
			return 0;
		}
	}

}
