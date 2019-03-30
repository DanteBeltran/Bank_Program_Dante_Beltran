/**
 * File Name: BankAccount.java
 * @author Dante Beltran
 * Assignment: Bank Program
 * Date: March 17,2019
 */


/**
 * This class cotains all the basic data needed for adding a bank account
 * The purpose is to getting all the information from the user and store it in accHolder object of Person
 * This class will also handling basic scanner input errors
 * @author Dante Beltran
 * @version %I% %G%
 * @see import java.util.*
 * @see import java.util.regex.Pattern;
 * @since 1.8.0_181
 */
import java.util.*;
import java.util.regex.Pattern;


public abstract class BankAccount { // abstract class

	protected double balance; // creating local variable balance

	protected long accountNo; // creating local variable accountNo

	protected Person accHolder;

	Scanner input = new Scanner(System.in);

	private static long accNo[] = new long [9999];

	private static String email[] = new String [9999];

	private static long phoneNumb[] = new long [9999];

	private int index1 = 0;

	private int index2 = 0;

	private int index3 = 0;

	/**
	 * Default constructor that initialize default value
	 */
	public BankAccount() {
		this.accountNo = 0;
		this.accHolder = new Person();
		this.balance = 0.0;
	}
	/**
	 * Initial constructor that initialize the new value
	 * @param accountNo
	 * @param accHolder
	 * @param balance
	 */
	public BankAccount(double balance, long accountNo, Person accHolder) { 
		this.balance = balance;
		this.accHolder = accHolder;
		this.accountNo = accountNo;

	}
	/**
	 * The purpose of this method is to prompt user for information and handling errors
	 * @return  whether the account is added successfully or not
	 */
	public boolean addBankAccount()  {
		String firstName, lastName, emailAddress, stringPhoneNum;
		long phoneNum;
		boolean isValidAccNo, checkDuplAccNo, isValidEmail, checkDuplPhone, checkDuplEmail, isValidPhone;







		do {
			System.out.println("Please enter the account number: ");
			
			while (!input.hasNextLong()) {
				
				System.err.println("That is not a valid value");
				
				System.out.println("Please enter the account number: ");
				
				input.next();
			}
			this.accountNo = input.nextLong();
			
		} while (this.accountNo <= 0); 

		isValidAccNo = isValidAccNo (this.accountNo);
		
		while (isValidAccNo == false) {
			
			System.err.println("The account number should a positive number and up to 8 digits long.");
			
			System.out.println("Enter the account number: ");
			
			this.accountNo = input.nextLong();
			
			isValidAccNo = isValidAccNo (this.accountNo);
		}
		checkDuplAccNo = checkDuplicatesAccNo (this.accountNo);
		
		if (checkDuplAccNo == false) {
			return false;
		}
		System.out.println("Enter first name of account holder: ");
		
		firstName = input.next();
		while(!firstName.matches("^[a-zA-Z]*$") ) {
	        System.err.println("Not valid! Try again: ");
	        firstName = input.next();
	    }
		
		System.out.println("Enter last name of account holder: ");
		
		lastName = input.next();
		while(!lastName.matches("^[a-zA-Z]*$") ) {
	        System.err.println("Not valid! Try again: ");
	       lastName = input.next();
	    }
		
		System.out.println("Please enter the phone number: ");
		
		stringPhoneNum = input.next();
		
		isValidPhone = validatePhoneNumber(stringPhoneNum);
		
		while (isValidPhone == false) {
			
			System.err.println("Invalid phone number");
			
			System.out.println("Please enter the phone number: ");
			
			stringPhoneNum = input.next();
			
			isValidPhone = validatePhoneNumber(stringPhoneNum);
			
		}
		
		phoneNum= Long.parseLong(stringPhoneNum);
		
		checkDuplPhone = checkDuplicatesPhone (phoneNum);
		
		if (checkDuplPhone == false) {
			
			return false;
		}

		System.out.println("Enter email address: ");
		
		emailAddress = input.next();
		
		isValidEmail = isValidEmail (emailAddress);
		
		while (isValidEmail == false) {
			
			System.err.println("Invalid email");
			
			System.out.println("Enter email address: ");
			
			emailAddress = input.next();
			
			isValidEmail = isValidEmail (emailAddress);
			
		}
		
		checkDuplEmail = checkDuplicatesEmail (emailAddress);
		
		if (checkDuplEmail== false) {
			
			return false;
			
		}
		this.accHolder = new Person (firstName, lastName, phoneNum, emailAddress);
		

		do {
			
			System.out.println("Enter opening balance: "); 
			
			while (!input.hasNextDouble()) {
				
				System.err.println("That is not a valid value");
				
				System.out.println("Enter opening balance: ");
				
				input.next();
				
			}
			this.balance = input.nextDouble();
			
		} while (this.balance <= 0); 
		

		return true;
		
	}
	/**
	 * The purpose of this method is to update balance of the bank account whether that is withdraw or deposit.
	 * @param amount
	 */
	public void updateBalance(double amount) {
		
		if (amount > 0) {
			
			balance = balance + amount;
			
		} else if (amount < 0) {
			
			if ((-amount) <= balance) {
				
				balance = balance + amount;
				
			}

		} else {
			
			System.err.println("The amount you would like to deposit/withdraw cannot be 0. ");
			
		}
	}
	
	/**
	 * The purpose of this method is to return the information of the bank account.
	 * @return account number, full name, phone number and email address and the balance
	 */
	public String toString() { // this method prints the balance to the console

		return "\nAccount Number: " + accountNo + " Name: " + accHolder.getName() + " Phone Number: "
		+ accHolder.getPhoneNum() + " Email Address : " + accHolder.getEmailAddress() + " Balance :" + balance; 

	}
	/** 
	 * The purpose of this method is to create an abstract method.
	 */
	public abstract double monthlyAccountUpdate();

	/**
	 * The purpose of this method is to return the account number.
	 * @return the account number of the bank account
	 */
	public long getAccountNumber() {
		return this.accountNo;
	}
	/**
	 * The purpose of this method is to set the balance to the bank account
	 * @param amount
	 */
	public void setBalance(double amount) {
		this.balance = amount;
	}

	/**
	 * The purpose of this method is to ensure the account number is positive and only up to 8 digits long.
	 * @param accNo
	 * @return either true (valid account number) or false (invalid account number)
	 */
	public boolean isValidAccNo (long accNo)
	{
		if (accNo < 0 || accNo > 99999999){
			return false;
		}
		else {
			return true;
		}
	}
	/**
	 * The purpose of this method is to check if there are any duplicates of account number 
	 * @param accNumb
	 * @return either true (no duplicates) or false (duplicates found)
	 */
	public boolean checkDuplicatesAccNo (long accNumb) {
		accNo[index1] = accNumb;
		
		for (int j = 1; j < accNo.length; j ++) {
			
			if (accNo[index1] == accNo [j]) {
				
				System.err.println("Account number has been taken");
				
				return false;
			}
		}
		index1 ++;
		
		if (index1 < accNo.length) {
			
			if (accNo[index1] == 0) {
				
				accNo[index1] = accNumb;
				
			}
			
			else {
				
				accNo[index1 + 1] = accNumb;
				
			}
		}
		return true;
	}
	
	/**
	 * The purpose of this method is to check if there are any duplicates of phone number. 
	 * @param phone
	 * @return  either true (no duplicates) or false (duplicates found)
	 */
	public boolean checkDuplicatesPhone (long phone) {
		
		phoneNumb[index2] = phone;
		
		for (int j = 1; j < phoneNumb.length; j ++) {
			
			if (phoneNumb[index2] == phoneNumb [j]) {
				
				System.err.println("Phone number has been taken");
				
				return false;
				
			}
		}
		index2++;
		if (index2 < phoneNumb.length) {
			
			if (phoneNumb[index2] == 0) {
				
				phoneNumb[index2] = phone;
				
			}
			
			else {
				phoneNumb[index2 + 1] = phone;
				
			}
		}
		return true;
	}
	/**
	 * The purpose of this method is to check if there are any duplicates of email address.
	 * @param emailAddress
	 * @return  either true (no duplicates) or false (duplicates found)
	 */
	public boolean checkDuplicatesEmail (String emailAddress) {
		
		email[index3] = emailAddress;
		
		for (int j = 1; j < email.length; j ++) {
			
			if (email[index3].equals(email[j])) {
				
				System.err.println("Email address has been taken");
				
				return false;
				
			}
		}
		index3++;
		
		if (index3 < email.length) {
			
			if (email[index3] == null) {
				
				email[index3] = emailAddress;
				
			}
			
			else {
				
				email[index3 + 1] = emailAddress;
				
			}
		}
		return true;
	}
	/**
	 * The purpose of this method is to ensure the valid form of the email address.
	 * @param email
	 * @return either true (valid email address) or false (invalid email address)
	 */
	public boolean isValidEmail (String email) {
		
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
		
				"[a-zA-Z0-9_+&*-]+)*@" + 
				
				"(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
				
				"A-Z]{2,7}$"; 
		
		Pattern pattern = Pattern.compile (emailRegex);
		
		if (email.equals(null)) {
			
			return false;
		}
		return pattern.matcher(email).matches();
	}

	/**
	 * The purpose of this method is to ensure the valid phone number.
	 * @param phoneNo
	 * @return either true (valid phone number) or false (invalid phone number)
	 */
	public boolean validatePhoneNumber(String phoneNo) {
		
		if (phoneNo.matches("\\d{10}")) {return true;}
		
		else if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")){return true;}
		
		else if(phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) {return true;}
		
		else if(phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) {return true;}
		
		else {return false;}

	}
}// end of class
