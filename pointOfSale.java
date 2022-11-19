package pointOfSale;

//I have neither given nor received unauthorized aid in
//completing this work, nor have I presented someone else's work as my own. - Xavier Espinoza

import java.util.Scanner;
import java.util.*;


public class pointOfSale {
	public static void main(String[] args) {
		
		final int EXIT = -1;
		int choiceInt = 0;
		Scanner input = new Scanner(System.in);
		
		foodItem [] order ={};
		int selection = 0;
		Catalog catalog = new Catalog();
		

		boolean correctInput = false;
		
		//get the name of the user
		System.out.println("What is your name?");
		String name = input.next();
		
		//main menu, allows user to choose to add an item,
		//an admin to enter an item to the catalog
		//or exit the terminal & get their receipt.
		System.out.println("1. Enter which item you would like to purchase ");
		System.out.println("2. Admin-supervised addition to the catalog");
		System.out.println("3. Finish Transaction");
		String choice = input.next();
		
		while(choiceInt != 3) {
			//Any time ValidityEnforcement is written, it is validating the user's input, 
			//making sure it is an int. Then it returns that int. 
			choiceInt = ValidityEnforcement(choice);
			switch(choiceInt) {//8
			case 1:
				catalog.DisplayCatalog();
				
				//allow user to select an item
				System.out.println("Please enter the ID of the item you would like to purchase, ");
				System.out.println("or enter 0 to finish your transaction: ");
				String UInput = input.next();
				int item = ValidityEnforcement(UInput);
				if(item!= 0) {
					item-=1;//subtract by 1 to correctly index the right item in the catalog array
					
					//collect quantity of this item
					System.out.println("Please enter how many " + catalog.getName(item)+ "(s)");
					UInput = input.next();
					int quant = ValidityEnforcement(UInput);
					//create a new food item, then add it to the order
					foodItem newItem = new foodItem(item,quant,catalog);
					order = addItem(order);
					order[order.length-1] = newItem;
					System.out.println("Item(s) purchased.");
					
					//re-enter the main menu
					System.out.println("1. Enter which item you would like to purchase ");
					System.out.println("2. Admin-supervised addition to the catalog");
					System.out.println("3. Finish Transaction");
					choice = input.next();
					
				}
				else {//if selection is 0, exit to main menu
					System.out.println("Exiting to main menu");
					System.out.println("1. Enter which item you would like to purchase ");
					System.out.println("2. Admin-supervised addition to the catalog");
					System.out.println("3. Finish Transaction");
					choice = input.next();
				}
				break;
			case 2:
				//admin entering an item
				//collect the password
				System.out.println("Please enter the passcode: ");
				String passCode = input.next();
				//call AddItem, and when they're finished adding items, return to the main menu
				catalog.AddItem(passCode);
				System.out.println("1. Enter which item you would like to purchase ");
				System.out.println("2. Admin-supervised addition to the catalog");
				System.out.println("3. Finish Transaction");
				choice = input.next();
				break;
			case 3:
				//create a new receipt, use the constructor to take in the order
				//and the name of the user.
				Receipt receipt2 = new Receipt(order,name);
				//display the receipt
				receipt2.DisplayReceipt();
				break;
			default:
				//if choice is not 1, 2, or 3, give the user another chance to enter a correct
				//input.
				System.out.println("Please enter 1,2, or 3");
				System.out.println("1. Enter which item you would like to purchase ");
				System.out.println("2. Admin-supervised addition to the catalog");
				System.out.println("3. Finish Transaction");
				choice = input.next();
				break;
			}
					
		}
		

}

//this function checks if a string is an int and returns that int
//if it is not an int, keep prompting for input until input is an int
public static int ValidityEnforcement(String choice) {
	Scanner input = new Scanner(System.in);
	int temp = 0;
	boolean correctInput = false;
	while(!correctInput) {//1
		correctInput = true;
		correctInput = isNumeric(choice);
		if(!correctInput) {//2
			System.out.println("Please enter a valid action");
			choice = input.next();
			}
		else {
			correctInput = true;
			temp = Integer.parseInt(choice);
		}
	}
	return temp;
	}
//increase the size of a foodItem list
public static foodItem[] addItem(foodItem[] array) {
	   foodItem[] temp = new foodItem[array.length + 1];
	   for (int i = 0; i < array.length; i++){
	      temp[i] = array[i];
	   }
	   return temp;
	}
//check if a string is an int
public static boolean isNumeric(String string) {
    int intValue;
	
    if(string == null || string.equals("")) {
        return false;
    }
    try {
        intValue = Integer.parseInt(string);
        return true;
    } catch (NumberFormatException e) {
    }
    return false;
}
}

