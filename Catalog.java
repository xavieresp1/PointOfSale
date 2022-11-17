package pointOfSale;

import java.util.Scanner;
import java.util.*;

public class Catalog {
	private Scanner input = new Scanner(System.in);
	
	private String[] prodCodes = new String[]{"1","2","3","4","5","6","7","8","9","10"};

	String[] prodNames = new String[] {"Cheese","Milk","Eggs",
			  "Bread","Juice","Cookies",
			  "Crackers","Chips","Pizza", "Twinkies"};

	String[] prodDescs = new String[] {"Cheesy goodness!",
			  "Great for your bone health!",
			  "Can't make a delicious omelette without crackin' some of our eggs!",
			  "The essential part of every sandwich!",
			  "Packed with delicious apples and essential vitamins!",
			  "What could be better than some cookies dipped in milk?",
			  "The best crackers for dipping in soup!",
			  "Perfect for your BBQ!",
			  "It's not delivery, it's a frozen pizza",
			  "An american delicacy"};
	private String passCode = "MCS3603";
	
	double[] prodPrices = new double[]{1.0,1.99, 3.29,3.59,2.49,4.69,1.79,2.69,5.99,3.19};
	
	
	Catalog(){
	}
	
	
	
	public void DisplayCatalog() {
		System.out.println("ID\tNAME\tPRICE\tDESC");
		for(int i = 0; i < prodCodes.length; i++) {
			System.out.print(prodCodes[i]);
			System.out.print('\t'+prodNames[i]);
			System.out.printf("\t%4.2f",prodPrices[i] + '\t');
			System.out.println('\t'+prodDescs[i]);
		}
	}
	
 	private String[] increaseLen(String[] array) {
		String []temp = new String[array.length + 1];
		for(int i = 0; i < array.length; i++) {
			temp[i] = array[i];
		}
		temp[temp.length-1] = "";
		return temp;
	}
	private double[] increaseLen(double[] array) {
		double []temp = new double[array.length + 1];
		for(int i = 0; i < array.length; i++) {
			temp[i] = array[i];
		}
		temp[temp.length-1] = 0.0;
		return temp;
	}

	
	public String getCode(int orderItem) {
		return prodCodes[orderItem];
	}
	public String getName(int orderItem) {
		return prodNames[orderItem];
	}
	public String getDesc(int orderItem) {
		return prodDescs[orderItem];
	}
	public double getPrice(int orderItem) {
		return prodPrices[orderItem];
	}
	public boolean AddItem(String passAtmpt) {
		boolean crrctPswrd = false;
		if(passAtmpt == passCode) {
			crrctPswrd = true;
			System.out.println("Hello admin, which action would you like to perform? Enter one of the numbers below");
			System.out.println("1. Add an item to the catalog");
			System.out.println("2. Change the passcode");
			System.out.println("3. Exit");
			int choice = input.nextInt();
			while(choice != 3) {
				if(choice == 1 || choice == 2) {
					switch(choice) {
					case 1:
						System.out.println("Please enter the name of the item:");
						String itemName = input.next();
						System.out.println("Please enter the item description:");
						String itemDesc = input.next();
						System.out.println("Please enter the price of the item:");
						double itemPrice = input.nextDouble();
						
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
						
						break;
					case 2:
						System.out.println("Enter the new passcode that you would like to use");
						String newPass = input.next();
						System.out.println("your new passcode is " + newPass);
						passCode = newPass;
						break;
				}//switch
				}//if the choice is not to exit
				else if(choice == 3) {
					System.out.println("Exiting admin menu");
				}
				else {
					System.out.println("Please enter 1, 2, or 3");
					choice = input.nextInt();
					while(choice != 1 || choice != 2 || choice != 3) {
						System.out.println("Please enter 1, 2, or 3");
						choice = input.nextInt();
					}
				}
					
			}//while choice is not to exit

			}//if password is correct
		else crrctPswrd = false;
		return crrctPswrd;
	}
}
