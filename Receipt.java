package pointOfSale;
import java.util.Scanner;
public class Receipt extends Catalog {
	private foodItem[] itemList;
	String custName = "";
	private double total = 0.0;
	private Scanner input = new Scanner(System.in);
	private boolean paymentPlan;
	private Catalog catalog = new Catalog();
	
	Receipt(){
		
	}
	
	//build the receipt, take in the list of food Items & the user's name
	//then find the total sum of the items. It will then ask if the user
	//would like to pay with a payment plan or not.
	Receipt(foodItem[] order, String name){
		itemList = new foodItem[order.length];
		for(int i = 0; i < order.length; i++) {
			itemList[i] = order[i];
			total += itemList[i].getPrice();
		}
		
		
		custName = name;
		System.out.println("Would you like to pay for this with installments? 1 for Yes, 2 for No");
		int choice = 0;
		String payPlan = input.next();
		choice = catalog.ValidityEnforcement(payPlan);
		switch(choice) {
		case 1:
			paymentPlan = true;
			System.out.println("You have chosen to pay with a payment plan");
			System.out.println("You saved " + String.format("%,.2f", (total*0.05)));
			total -= (total * 0.05);
			break;
		case 2:
			System.out.println("You have chosen to pay now");
			total += (total * 0.05);
			paymentPlan = false;
			break;
		}
			
		}
			
	//display the receipt. It'll show the user's name, the ID of the items, the names of
	//the items, the quantity of the items, the prices of the items, the
	//items with a 10% discount, and the total.
	public void DisplayReceipt() {
		
		System.out.print(custName+", ");
		System.out.println("this is your receipt");
		System.out.println("ID\tNAME\tQUANT\tPRICE");
		for(int i = 0; i < itemList.length; i++) {
			System.out.println(itemList[i].getID() + '\t' + itemList[i].getName() +'\t'+ itemList[i].getQuant() +"\t\t"+ String.format("%,.2f", itemList[i].getPrice()));
		}
		//show which items have a 10% discount
		System.out.println("You got a 10% discount for buying 10 or more of these items: ");
		for(int i = 0; i < itemList.length; i++) {
			if(itemList[i].discApplied == true) {
				System.out.println(itemList[i].getName());
			}
		}
		if(paymentPlan == true) {
			System.out.println("A 5% discount has been applied to your order for choosing a payment plan");
		}
		System.out.println("Your total is: " + String.format("%,.2f", total));
		
	}
	//lengthen a foodItem array
	public static foodItem[] addItem(foodItem[]array) {
		   foodItem[] temp = new foodItem[array.length + 1];
		   for (int i = 0; i < array.length; i++){
		      temp[i] = array[i];
		   }
		   return temp;
		}
//check if a string is a number
	public static boolean isNumeric(String string) {
	    int intValue;
			
	    if(string == null || string.equals("")) {
	        return false;
	    }
	    try {
	        intValue = Integer.parseInt(string);
	        return true;
	    } catch (NumberFormatException e) {
	        System.out.println("Please enter an integer");
	    }
	    return false;
	}
	
}
