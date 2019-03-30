/**
 * File Name: Assign1.java
 * @author Dante Beltran
 * Assignment: Bank Program
 * Date: March 17,2019
 */

/**
 * This class is the main method of the program where it contains the menu and lets you run all the options of the program. 
 * @version %I% %G%
 * @see import java.util.*
 * @since 1.8.0_181
 */
import java.util.*;

public class Assign1 {
	
	/**
	 * The purpose of this method is to execute the program because it is the main method
	 * Note: using try and catch NullPointerException for most options except a to catch errors when a user tries to run options with no created accounts.
	 * @param args
	 */
	static Bank bank = new Bank(1000);
	 static Scanner input = new Scanner(System.in);//creating the scanner
	 static String choice;//creating String variables
	static String formattedChoice;
	public static void main(String[] args) {
		do {// do loop that will run the different options for the user until the decide to exit the program
			System.out.println("a: Add an account");
			System.out.println("u: Update an account");//prints "Welcome to the online bank: "
			System.out.println("d: Display an account");
			System.out.println("p: Print all accounts");//prints "p: Print All Acounts"
			System.out.println("m: Run monthly update");//prints "Run monthly update"
			System.out.println("q: Quit");//"press Q or q to quit"
			System.out.print("Select the option you would like to run: "); //prints "Select the option you would like to run: ""
			
	            choice = input.nextLine(); //user inputs there choice
	            formattedChoice = choice.toUpperCase();// converts users
	            System.out.printf("\n======================================\n ");
	            switch (formattedChoice) //switch statement 
	            {
	            
	            case "A": //if P is clicked runs print method
	                bank.addAccount();//calls print accounts method
	                break;

	            case "U":
	            	
	            	try {
	            		bank.updateAccount();
		            	} catch (NullPointerException e) {
		            		
		            		System.err.println("Error: no accounts have been created");
		            	}
		            	break;
	            
	            case "D": //if W is clicked runs case withdraw method
	            	try {
		            	System.out.println(bank.displayAccount());
		            	} catch (NullPointerException e) {
		            		
		            		System.err.println("Error no accounts have been created");
		            	}
		            	break;
	            
	            case "P": //if W is clicked runs case withdraw method
	            	try {
	            	bank.printAccountDetails();
	            	} catch (NullPointerException e) {
	            		
	            	}
	            	
	            	
	            	break;
	            	
	            case "M": //if W is clicked runs case withdraw method
	            	try {
	            	bank.monthlyUpdate();
	            	} catch (NullPointerException e) {
	            		
	            		
	            	}
	            	break;

	            case "Q": //if q is pressed stop the main method 
	            	
	            	return;
	            	
	            	
	            	
	            default: formattedChoice = "Invalid key"; //if one of the specific options is not pressed, prompt the user again
	            System.err.println("invalid output, please try agian");
	            	break;
	            	
	            }
	        }while(!choice.equals("Q")); // while statement that states that it will keep asking for an option until q is pressed
	        
	           
	               
			
			
		}


	}



