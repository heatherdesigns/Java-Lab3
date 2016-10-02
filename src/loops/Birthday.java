/*
 * Heather Taylor
 * CIS 2212 Tuesdays Fall 2016
 * Lab 03 - Happy Birthday to You!
 * Due September 13, 2016
 */

/* For your birthday, your grandparents gave you a $500 gift card for Best Buy. You may purchase a maximum of 6 items.
 * You will have a tracker device that computes the number of items you purchase as well as how much money you have spent.
 * After you choose each item, the tracker prompts you for the price, and then displays the amount of money you have spent.
 * Then it displays the number of items you may still choose and how much is left to spend. The program will not terminate
 * until you reach 6 items or $500, whichever comes first. At that point, the tracker will confirm you are finished
 * shopping and will list how much you spent on how many items.
 */

package loops;

import java.text.NumberFormat;
import java.util.Scanner;

public class Birthday {

	public static void main(String[] args) {
		
		// declare variables
		int items = 0; // number of items purchased
		double itemPrice = 0.00; // to hold the price of an item
		double giftCard = 500.00; // amount on gift card
		double purchaseTotal = 0.00; // total cost of items purchased
		
		// Create a scanner object
		Scanner input = new Scanner(System.in);
		
		// Set up currency object
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		
		// Display header
		System.out.println("Happy Birthday to You!");
		System.out.println("\tYou may buy up to 6 items costing no more than $500.00.");
		
		// Start shopping!!
		do{
			// Prompt user to enter price for each item selected
			System.out.print("\nEnter the price for item #" + (items + 1) + ": ");
			itemPrice = input.nextDouble();
			
			// validate the price is at least 1 cent. Not negative or zero!
			while (itemPrice <= 0.00){
				System.out.print("Price must be at least 0.01. Please try again: ");
				itemPrice = input.nextDouble();
			}
			
			// add or reject item purchase
			if (itemPrice > (giftCard - purchaseTotal)){
				System.out.println("This item exceeds your gift card balance. Chose an item costing no more than " + currency.format(giftCard - purchaseTotal) + ".");
			}
			else if (itemPrice <= giftCard && purchaseTotal <= 500.0){
				purchaseTotal += itemPrice; // add price of item to total of purchase
				System.out.printf("You may buy this item. You have spent " + currency.format(purchaseTotal) + " so far.");
				items++; // add an item to the number selected
				
				// display current purchase status
				if (items < 6 && purchaseTotal < 500.00){
				System.out.printf("\nYou may buy up to " + (6 - items) + " more items costing no more than " + currency.format(giftCard - purchaseTotal) + ".\n");
				}
				else if (purchaseTotal >= 500.00){
					break; // max spending cap has been met, exit loop
				}
				else{
				}; // end if else statement to display current purchase status
			}
			else{
				break;
			}; // end if else statement to add or reject purchase
			
		}while (items < 6); // end of do-while loop
		
		// Final statement
		System.out.printf("\n\nYou spent " + currency.format(purchaseTotal) + " on " + items + " items. You are finished shopping for today.");
		
		// Close scanner
		input.close();

	} // end main method

} // end Birthday class
