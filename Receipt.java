package pointOfSale;
import java.util.Scanner;
public class Receipt {
	private foodItem[] itemList;
	private double total = 0.0;
	private Scanner input = new Scanner(System.in);
	private boolean paymentPlan;
	
	Receipt(foodItem[] order){
		itemList = new foodItem[order.length];
		for(int i = 0; i < order.length; i++) {
			itemList[i] = order[i];
			total += order[i].getPrice();
		}
		System.out.println("Would you like to pay for this with installments? 1 for Yes, 2 for No");
		boolean isNum = false;
		String payPlan = input.next();
		while(isNum == false) {
			isNum = isNumeric(payPlan);
			if(isNum == true) {
				int plan = Integer.parseInt(payPlan);
				if(plan == 1 || plan ==2) {
					switch(plan) {
					case 1:
						paymentPlan = true;
						total -= (total * 0.05);
						System.out.println("You have chosen to pay with a payment plan");
						break;
					case 2:
						System.out.println("You have chosen to pay now");
						paymentPlan = false;
						break;
					}
				}
				else {
					while(plan != 1 || plan != 2) {
						System.out.println("Please enter 1 or 2");
						payPlan = input.next();
						try {
					        plan = Integer.parseInt(payPlan);
					        if(plan ==1) {
					        	total -= (total * 0.05);
					        	paymentPlan = true;
					        	System.out.println("You have chosen to pay with a payment plan");
					        }
					        else if (plan == 2) {
					        	paymentPlan = false;
					        	System.out.println("You have chosen to pay now");
					        }
					    } 
						catch (NumberFormatException e) {
					        System.out.println("Please enter an integer");
					    }
					}
				}
			}
		}
			
	}
	public void DisplayReceipt() {
		
		System.out.println("This is your receipt");
		System.out.println("ID\tNAME\tQuantity\tPRICE");
		for(int i = 0; i < itemList.length; i++) {
			System.out.println(itemList[i].getID() + '\t' + itemList[i].getName() +'\t'+ itemList[i].getQuant() +'\t'+ itemList[i].getPrice());
		}
		System.out.println("You got a 10% discount for buying 10 or more of these items: ");
		for(int i = 0; i < itemList.length; i++) {
			if(itemList[i].discApplied == true) {
				System.out.println(itemList[i].getName());
			}
		}
		if(paymentPlan == true) {
			System.out.println("A 5% discount has been applied to your order for choosing a payment plan");
		}
		System.out.println("Your total is: " + total);
		
	}
	
	private static boolean isNumeric(String string) {
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
