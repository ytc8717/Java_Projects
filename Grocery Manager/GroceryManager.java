
/*
* CSS 143 Final Assignment: Grocery Manager
* Instructor: Lesley Kalmin
*
*
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/*
 * This class is used to represent the manager of grocery store
 * 
 * Yun-Ting Chen
 */
public class GroceryManager {

	// two private collections
	// this list stores the store¡¦s current inventory
	private ArrayList<GroceryItem> inventory = new ArrayList<>();
	// this list stores the names of items that need to be reordered.
	private HashSet<String> reorderList = new HashSet<>();

	/*
	 * process order by Subtracting the items and quantities in the order from the
	 * inventory. If 0 inventory hit, add to reorder list. If the quantity ordered
	 * is greater than the quantity in inventory, throw an error with message ¡§out
	 * of xxxx¡¨, but keep on going. If an item in the order is not in inventory,
	 * also throw an error but keep going.
	 */
	public void processOrder(GroceryOrder order) {
		// create dairy item and get the data from order at index 0(dairy)
		GroceryItem dairy = (GroceryItem) order.get(0);

		// get the name and quantity from dairy
		String dName = dairy.getName();
		int dQuantity = dairy.getQuantity();

		// loop through the inventory
		for (int i = 0; i < inventory.size(); i++) {

			// find the item in the inventory by calling the findItemByName method
			if (inventory.get(i).equals(findItemByName(dName))) {
				// get the current quantity of that item
				int orginalQuantity = inventory.get(i).getQuantity();

				// If the quantity ordered is greater than the quantity in inventory, throw an
				// error with message ¡§out of (the item)¡¨, but keep on going.
				if (orginalQuantity < dQuantity) {
					findItemByName(dName).setQuantity(0);
					try {
						throw new GroceryException("Out of " + dName);
					} catch (GroceryException e) {
						System.out.println(e);
						// add to reorder list
						reorderList.add(dName);
					}
					// if the quantity ordered is less than the quantity in inventory, subtract the
					// order quantity from current quantity
				} else if (orginalQuantity >= dQuantity) {
					inventory.get(i).setQuantity(orginalQuantity - dQuantity);
				}

			}
		}

		// create produce item and get the data from order at index 1(produce)
		GroceryItem produce = (GroceryItem) order.get(1);

		// get the name and quantity from produce
		String pName = produce.getName();
		int pQuantity = produce.getQuantity();

		// loop through the inventory
		for (int i = 0; i < inventory.size(); i++) {

			// find the item in the inventory by calling the findItemByName method
			if (inventory.get(i).equals(findItemByName(pName))) {
				// get the current quantity of that item
				int orginalQuantity = inventory.get(i).getQuantity();

				// If the quantity ordered is greater than the quantity in inventory, throw an
				// error with message ¡§out of (the item)¡¨, but keep on going.
				if (orginalQuantity < pQuantity) {
					findItemByName(pName).setQuantity(0);
					try {
						throw new GroceryException("Out of " + pName);
					} catch (GroceryException e) {
						System.out.println(e);
						// add to reorder list
						reorderList.add(pName);
					}
					// if the quantity ordered is less than the quantity in inventory, subtract the
					// order quantity from current quantity
				} else if (orginalQuantity >= pQuantity) {
					inventory.get(i).setQuantity(orginalQuantity - pQuantity);
				}
			}
		}

		// create meat item and get the data from order at index 1(meat)
		GroceryItem meat = (GroceryItem) order.get(2);

		// get the name and quantity from meat
		String mName = meat.getName();
		int mQuantity = meat.getQuantity();

		// loop through the inventory
		for (int i = 0; i < inventory.size(); i++) {

			// find the item in the inventory by calling the findItemByName method
			if (inventory.get(i).equals(findItemByName(mName))) {
				// get the current quantity of that item
				int orginalQuantity = inventory.get(i).getQuantity();

				// If the quantity ordered is greater than the quantity in inventory, throw an
				// error with message ¡§out of (the item)¡¨, but keep on going.
				if (orginalQuantity < mQuantity) {

					findItemByName(mName).setQuantity(0);
					try {
						throw new GroceryException("Out of " + mName);
					} catch (GroceryException e) {
						System.out.println(e);
						// add to reorder list
						reorderList.add(mName);
					}
					// if the quantity ordered is less than the quantity in inventory, subtract the
					// order quantity from current quantity
				} else if (orginalQuantity >= mQuantity) {
					inventory.get(i).setQuantity(orginalQuantity - mQuantity);
				}
			}
		}

	}

	// this method will find the item in inventory by given name
	public GroceryItem findItemByName(String name) {
		// set initial index to -1
		int index = -1;

		// loop through the inventory
		for (int i = 0; i < inventory.size(); i++) {
			// if the name of item in inventory matches the given
			if (inventory.get(i).getName().equals(name)) {
				// set index to i
				index = i;
				break;
			}
		}

		// if index is -1 which indicates not found
		if (index == -1) {
			try {
				// throw a exception with error message
				throw new GroceryException("Item not found: " + name);
			} catch (GroceryException e) {
				System.out.println(e);
			}
			// return null
			return null;
		}

		// else return inventory at that index
		return inventory.get(index);
	}

	// sort the item by name
	public void sortByName() {
		// Use SelectionSort

		// One by one move boundary of unsorted subarray
		for (int i = 0; i < inventory.size() - 1; i++) {
			// Find the minimum element in unsorted array
			int minIndex = i;
			for (int j = i + 1; j < inventory.size(); j++) {
				if (inventory.get(j).getName().compareTo(inventory.get(minIndex).getName()) < 0) {
					minIndex = j;
				}
			}

			// Swap the found minimum element with the first element
			GroceryItem temp = inventory.get(i);
			inventory.set(i, inventory.get(minIndex));
			inventory.set(minIndex, temp);
		}
	}

	// sort the items by price
	public void sortByPrice() {
		// Use BubbleSort
		for (int i = 0; i < inventory.size() - 1; i++) {
			for (int j = 0; j < inventory.size() - i - 1; j++) {
				if (inventory.get(j).getPrice() > inventory.get(j + 1).getPrice()) {
					GroceryItem temp = inventory.get(j);
					inventory.set(j, inventory.get(j + 1));
					inventory.set(j + 1, temp);
				}
			}
		}
	}

	// print out the info of each item in inventory
	public void displayInventory() {
		for (int i = 0; i < inventory.size(); i++) {
			System.out.println(inventory.get(i));
		}
	}

	// print out the item that needed to reorder
	public String getReorderList() {
		String str = "";
		for (String reOrder : reorderList) {
			str += reOrder + "\n";
		}
		return str;
	}

	// read the data from the txt file to stock the inventory
	public void readInventory() throws FileNotFoundException {
		Scanner input = null;
		try {
			input = new Scanner(new FileInputStream("groceryInventory.txt"));
			String qline = input.nextLine();
			String[] qparts = qline.split(" ");
			int nDairy = Integer.parseInt(qparts[0]);
			int nProduce = Integer.parseInt(qparts[1]);

			int i = 0;

			while (input.hasNext()) {
				String line = input.nextLine();

				if (i++ < nDairy) {
					inventory.add(new Dairy(line));
				} else if (i++ < nProduce + nDairy) {
					inventory.add(new Produce(line));
				} else {
					inventory.add(new Meat(line));
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			input.close();
		}
	}

}
