/**
 * File Name: Bank.java
 * @author Dante Beltran
 * Assignment: Bank Program
 * Date: March 17,2019
 */

/**
 * This class will add BankAccount object to the array and will  print, update and find accounts as well as running monthly update.
 * @version %I% %G%
 * @see import java.util.*
 * @since 1.8.0_181
 */

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;



public class Bank {

	private List<BankAccount> list = new ArrayList<BankAccount>();
	private int numAccounts = 0;
	private int sizeBank = 100;
	
	Scanner input = new Scanner(System.in);
	
	/**
	 * Default constructor that sets the maximum size of the bank to 1000.
	 */
	public Bank() {
		List<BankAccount> list = new ArrayList<BankAccount>(1000);
	}
	/**
	 * Initial constructor that initializes the new size of the bank.
	 * @param sizeBank
	 */
	public Bank(int sizeBank) {
		this.sizeBank = sizeBank;
		List<BankAccount> list = new ArrayList<BankAccount>(this.sizeBank);
		
	}
	
	/**
	 * the purpose of this method is adding a bank account  through the bankAccount method from the bankAccount class.
	 * @return true if added successfully or false if added unsuccessfully.
	 */
	public boolean addAccount( ) {
	
		String type;
		boolean isTrue;
	
		if (numAccounts >= sizeBank)
		{
			System.err.println("the number of accounts can not be greater than the size of the bank");
			return false;
		}
		else
		{
				System.out.printf("\nEnter account type (s for savings, c for chequing): ");
				type = input.nextLine();
				if (type.equals("s"))
				{
					list.add(numAccounts, new SavingsAccount());
					isTrue = list.get(numAccounts).addBankAccount();
					do
					{
						if (isTrue)
						{
							numAccounts++;
						}
						else
						{
							list.remove(numAccounts);
							System.err.println("Account has not been succesfully added. Please try again.");
						}
					} while (isTrue = false);
				}
				else if (type.equals("c"))
				{
					list.add(numAccounts, new ChequingAccount());
					isTrue = list.get(numAccounts).addBankAccount();
					do
					{
						if (isTrue)
						{
							numAccounts++;
						}
						else
						{
							list.remove(numAccounts);
							System.err.println("Account has not been succesfully added. Please try again.");
						}
					} while (isTrue = false);
				}
				else
				{
					System.err.println ("Error. Please try again");
					
				}
			return true;
			
		}
	}
	
	/**
	 * the purpose of this method is to locate the index of which account is chosen.
	 * @return either i(the correct accounts index) or -1(invalid index, no accounts available).
	 */
	public int findAccount() {
	long accountNo;
	System.out.printf("\nPlease enter the account number that you wish to see: ");
	accountNo = input.nextLong();
	for( int i = 0; i < list.size(); i++) {
		if (list.get(i).accountNo == accountNo) {
			return i;
		}
	}
	return -1;
}
	
	/**
	 * the purpose of this method is to display the information from the specified account.
	 * @return toString method from BankAccount abstract class.
	 */
	public String displayAccount() {
		int index = findAccount();
		return list.get(index).toString();
		
	}
	/**
	 * the purpose of this method is to display all available accounts
	 */
	public void printAccountDetails() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		
		
	}
	
	/**
	 * the purpose of this method is to update the account (withdraw or deposit) using updateBalance method from BankAccount.
	 */
	public void updateAccount() {
		int index = findAccount();
		System.out.println("Please enter the amount you would like to add: (positive to deposit and negative to withdraw)");
		double amount = input.nextDouble();
		list.get(index).updateBalance(amount);
		}
	/**
	 * the purpose of this method is to perform the monthly update to all accounts available in the bank.
	 */
	public void monthlyUpdate() {
		double amount;
		for(int i = 0; i < list.size(); i++) {
			amount = list.get(i).monthlyAccountUpdate();
			list.get(i).setBalance(amount);
		}
	}
}
