package pointOfSale;

import java.lang.reflect.Array;


public class foodItem {
	private Catalog catalog = new Catalog();
	public boolean discApplied = false;
	private String itemName = "";
	private String itemDesc = "";
	private double itemPrice = 0.0;
	private String itemId = "";
	private int itemQuantity = 0;
	
	foodItem(int choice, int quantity){
		itemName = catalog.getName(choice);
		itemDesc = catalog.getDesc(choice);
		itemId = catalog.getCode(choice);
		itemQuantity = quantity;
		if(itemQuantity >= 10) {
			itemPrice = catalog.getPrice(choice) - (catalog.getPrice(choice) * 0.1);
			discApplied = true;
		}
		else itemPrice = catalog.getPrice(choice);
	}
	public String getName() {
		return itemName;
	}
	public String getDesc() {
		return itemDesc;
	}
	public double getPrice() {
		return itemPrice;
	}
	public String getID() {
		return itemId;
	}
	public int getQuant() {
		return itemQuantity;
	}
	
}
