package pointOfSale;

import java.lang.reflect.Array;


public class foodItem extends Catalog {
	public boolean discApplied = false;
	private String itemName = "";
	private String itemDesc = "";
	private double itemPrice = 0.0;
	private String itemId = "";
	private int itemQuantity = 0;
	foodItem(){
		
	}
	//build a new food item, take in the user's choice, the quantity of that choice,
	//and the current catalog of the transaction.
	foodItem(int choice, int quantity, Catalog catalog){
		itemName = catalog.getName(choice);
		itemDesc = catalog.getDesc(choice);
		itemId = catalog.getCode(choice);
		itemQuantity = quantity;
		if(itemQuantity >= 10) {
			itemPrice = catalog.getPrice(choice) - (catalog.getPrice(choice) * 0.1);
			System.out.println("You saved: "+String.format("%,.2f",(catalog.getPrice(choice) * 0.1)) + " on each " + itemName);
			itemPrice = itemPrice * itemQuantity;
			discApplied = true;
		}
		else itemPrice = catalog.getPrice(choice) * itemQuantity;
	}
	//get the name of this foodItem
	public String getName() {
		return itemName;
	}
	//get the description of this foodItem
	public String getDesc() {
		return itemDesc;
	}
	//get the description of this foodItem
	public double getPrice() {
		return itemPrice;
	}
	//get the ID of this foodItem
	public String getID() {
		return itemId;
	}
	//get the Quantity of this foodItem
	public int getQuant() {
		return itemQuantity;
	}
	//set the Price of the item
	public void setPrice(double price) {
		itemPrice = price;
	}
}
