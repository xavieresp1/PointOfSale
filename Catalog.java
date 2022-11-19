package pointOfSale;

import java.util.Scanner;
import java.util.*;

public class Catalog {
	private Scanner input = new Scanner(System.in);
	
	private String[] prodCodes;

	String[] prodNames = new String[] {"Cheese","Milk","Eggs",
			  "Bread","Juice","Cookies",
			  "Coffee","Chips","Pizza", "Candy"};

	String[] prodDescs;
	private String passCode = "MCS3603";
	
	double[] prodPrices = new double[]{1.0,1.99, 3.29,3.59,2.49,4.69,1.79,2.69,5.99,3.19};
	//create the catalog with no additions
	Catalog(){
		prodCodes = new String[]{"1","2","3","4","5","6","7","8","9","10"};
		prodDescs = new String[] {"Cheesy goodness!",
				  "Great for your bone health!",
				  "Can't make a delicious omelette without crackin' some of our eggs!",
				  "The essential part of every sandwich!",
				  "Packed with delicious apples and essential vitamins!",
				  "What could be better than some cookies dipped in milk?",
				  "Perfect for late-night coding!",
				  "Perfect for your BBQ!",
				  "It's not delivery, it's a frozen pizza",
				  "So sweet!"};

	}
	
	
	//display the ID,Name,Price, and Description of each item
	public void DisplayCatalog() {
		System.out.println("ID\tNAME\tPRICE\tDESC");
		for(int i = 0; i < prodCodes.length; i++) {
			System.out.print(prodCodes[i]);
			System.out.print('\t'+prodNames[i]);
			System.out.printf("\t"+ (String.format("%,.2f",prodPrices[i])));
			System.out.println('\t'+prodDescs[i]);
		}
	}
	//increase the length of a string array
 	private String[] increaseLen(String[] array) {
		String []temp = new String[array.length + 1];
		for(int i = 0; i < array.length; i++) {
			temp[i] = array[i];
		}
		temp[temp.length-1] = "";
		return temp;
	}
 	//increase the length of a double array
	public double[] increaseLen(double[] array) {
		double []temp = new double[array.length + 1];
		for(int i = 0; i < array.length; i++) {
			temp[i] = array[i];
		}
		temp[temp.length-1] = 0.0;
		return temp;
	}

	//get the code of one of the items
	public String getCode(int orderItem) {
		return prodCodes[orderItem];
	}
	//get the name of one of the items
	public String getName(int orderItem) {
		return prodNames[orderItem];
	}
	//get the description of one of the items
	public String getDesc(int orderItem) {
		return prodDescs[orderItem];
	}
	//get the price of one of the items
	public double getPrice(int orderItem) {
		return prodPrices[orderItem];
	}
	//check to make sure the string is an int, and if it's not,
	//keep prompting for input until it is. Then return that int
	public static int ValidityEnforcement(String choice) {
		Scanner input = new Scanner(System.in);
		int temp = 0;
		boolean correctInput = false;
		while(!correctInput) {//1
			correctInput = isNumeric(choice);
			if(!correctInput) {//2
				System.out.println("Please enter an integer");
				choice = input.next();
				}
			else {
				correctInput = true;
				temp = Integer.parseInt(choice);
			}
		}
		return temp;
		}
	//check to make sure the string is a double, and if it's not,
	//keep prompting for input until it is. Then return that double
	public static double ValidityEnforcementDouble(String choice) {
		Scanner input = new Scanner(System.in);
		double temp = 0;
		boolean correctInput = false;
		while(!correctInput) {//1
			correctInput = isNumeric(choice);
			if(!correctInput) {//2
				System.out.println("Please enter a decimal-point value");
				choice = input.next();
				}
			else {
				correctInput = true;
				temp = Double.valueOf(choice);
			}
		}
		return temp;
		}
	//check whether or not the string is numeric, this function can check
	//doubles and integers
	public static boolean isNumeric(String string) {
	    int intValue;
		double doubleValue;
		
	    if(string == null || string.equals("")) {
	    	System.out.println("null detected");
	        return false;
	    }
	    try {
	        intValue = Integer.parseInt(string);
	        return true;
	    } catch (NumberFormatException e) {
	    	try {
	    		doubleValue = Double.valueOf(string);
	    		return true;
	    	}
	    	catch(NumberFormatException ex) {
	    	}
	    }
	    return false;
	}
	//add an item to the catalog. Only allow the user to add an item if the password is correct.
	//Then enter the name, description, and price of the item.
	public void AddItem(String passAtmpt) {
		int choice = 0;
		if(passAtmpt.equals(passCode)) {
			System.out.println("Hello admin, which action would you like to perform? Enter one of the numbers below");
			System.out.println("1. Add an item to the catalog");
			System.out.println("2. Change the passcode");
			System.out.println("3. Exit");
			String action = input.next();
			while(choice != 3) {//while the user does not want to exit
				choice = ValidityEnforcement(action);
					switch(choice) {
					case 1:
						//enter the item
						System.out.println("Please enter the name of the item:");
						String itemName = input.next();
						System.out.println("Please enter the item description:");
						String itemDesc = input.next();
						System.out.println("Please enter the price of the item:");
						String SitemPrice = input.next();
						double itemPrice = ValidityEnforcementDouble(SitemPrice);
						
						//increase the size of each of the arrays
						prodCodes = increaseLen(prodCodes);
						Integer prodCodesLen = prodCodes.length;
						String itemCode = prodCodesLen.toString();
						prodCodes[prodCodes.length -1] = itemCode;
						
						prodNames = increaseLen(prodNames);
						prodNames[prodNames.length - 1] = itemName;
						
						prodDescs = increaseLen(prodDescs);
						prodDescs[prodDescs.length - 1] = itemDesc;
						
						prodPrices = increaseLen(prodPrices);
						prodPrices[prodPrices.length - 1] = itemPrice;
						
						System.out.println("The item has been added to the catalog, here is the new catalog: ");
						this.DisplayCatalog();
						
						//send back to the admin menu
						System.out.println("Which action would you like to perform?");
						System.out.println("1. Add an item to the catalog");
						System.out.println("2. Change the passcode");
						System.out.println("3. Exit");
						action = input.next();
						choice = ValidityEnforcement(action);
						break;
					case 2:
						//reset the password
						System.out.println("Enter the new passcode that you would like to use");
						String newPass = input.next();
						System.out.println("your new passcode is " + newPass);
						passCode = newPass;
						
						//send back to the admin menu
						System.out.println("Which action would you like to perform?");
						System.out.println("1. Add an item to the catalog");
						System.out.println("2. Change the passcode");
						System.out.println("3. Exit");
						action = input.next();
						break;
					case 3:
						//exit the admin menu
						System.out.println("Exiting");
						choice = 3;
						break;
					default:
						//validate that the input is 1, 2, or 3
						System.out.println("Choose 1,2, or 3");
						action = input.next();
						choice = ValidityEnforcement(action);
						break;
				}//switch
				}//while choice is not to exit
					
			}
		//if the password is wrong, exit back to the main menu
		else System.out.println("Incorrect Password");
	}

}
