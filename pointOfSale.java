package pointOfSale;

//had some problems accessing the element within an array, so I have used
//this import to help with accessing the values.
import java.lang.reflect.Array; 
import java.util.Scanner;
import java.util.*;


public class pointOfSale {
	public static void main(String[] args) {
		
		final int EXIT = -1;
		
		Scanner input = new Scanner(System.in);
		
		foodItem [] order ={};
		
		
		Catalog catalog = new Catalog();
		
		
		System.out.println("This is the catalog of the items in our store!");
		
		catalog.DisplayCatalog();
		
		//The while & switch structures here will build the order for the customer,
		//as well as take count of the quantity of each item the customer would like to buy
		System.out.println("Please enter the items that you would like to purchase, or enter 0 to end the transaction.");
		System.out.println("Enter the item ID:");
		
		boolean correctInput = false;
		
		while(!correctInput){
			
		  try{
		    int choice = input.nextInt();
		    
		    correctInput = true;
		    
		    choice -= 1;
		    
		    if(choice != -1) {
		    	
		    	System.out.println("How many "+ catalog.getName(choice) + "(s) would you like to buy?");
		    	
		    	int quantity = input.nextInt();
		    	
		    	foodItem newItem = new foodItem(choice,quantity);
		    	
		    	order = addItem(order);
		    	
		    	order[order.length-1] = newItem;
		    	while(choice != -1) {
		    		
		    		catalog.DisplayCatalog();
		    		
		    		System.out.println("Please enter the ID of the next item you would like to buy, or 0 to finish the transaction");
		    		
		    		choice = input.nextInt();
		    		choice -=1; 
		    		if(choice != -1) {
		    			System.out.println("How many "+ catalog.getName(choice) + "(s) would you like to buy?");
				    	
				    	int quantity1 = input.nextInt();
				    	
				    	foodItem newItem1 = new foodItem(choice,quantity1);
				    	
				    	order = addItem(order);
				    	
				    	order[order.length-1] = newItem1;
		    		}
		    		else {
		    			System.out.println("You have chosen to finish the transaction");
		    			Receipt receipt = new Receipt(order);
		    			receipt.DisplayReceipt();
		    		}
		    	}
		    }
		    else {
		    	System.out.println("You have chosen to not buy anything.");
		    }
		    
		  }catch(Exception e){
			 System.out.println("Please enter an integer as your selection");
		     continue;
		  }

		}
		
		
		//determine the method of payment, store in a bool to be used by the receipt method
		
			
		//call the method receipt, which will take in an array of integers, an array of item quantities,
		//and a boolean for the payment plan option
		//the integers correspond to an item within the catalog, the quantities will be used to determine price &
		//discounts, and the payment plan boolean will determine how they pay & if they get the full payment
		// discount.
	}
	

public static foodItem[] addItem(foodItem[] array) {
	   foodItem[] temp = new foodItem[array.length + 1];
	   for (int i = 0; i < array.length; i++){
	      temp[i] = array[i];
	   }
	   return temp;
	}

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
//I have neither given nor received unauthorized aid in
//completing this work, nor have I presented someone else's work as my own. - Xavier Espinoza
