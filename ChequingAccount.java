
/**
 * File Name: ChequingAccount.java
 * @author Dante Beltran
 * Assignment: Bank Program
 * Date: March 17,2019
 */



/**
 * The purpose of this class is carry everything in the Bank account abstract class with added variables like fee
 * This class will also calculate and update the balance
 * @author Dante Beltran
 * @version %I% %G%
 * @since 1.8.0_181
 */
public class ChequingAccount extends BankAccount {// chequing account extends Bank account

	private double fee; //create new fee variable
	/**
	 * Default constructor to set default value
	 */
	public ChequingAccount() {
		super();
		this.fee = 0.0;
		
	}
	/**
	 * Initial constructor to initialize new values
	 * @param accountNo
	 * @param accHolder
	 * @param balance
	 * @param fee
	 */
	public ChequingAccount (double balance, long accountNo, double fee, Person accHolder) { // this initializes fee and carries over the super variables
		super(balance, accountNo, accHolder);//carrying over of balance and account number

		this.fee = fee;// initialize fee
	}
	/**
	 * the purpose of the method is to continue from abstract class that gather information like fee
	 * @return whether true (valid input) or false (invalid input)
	 */
	public boolean addBankAccount() {
		boolean isTrue = super.addBankAccount();
		
		if (isTrue) {

		do {
			System.out.println ("Enter the monthly fee: ");
			
			while (!input.hasNextDouble()) {
				
				System.err.println("That is not a valid value");
				
				System.out.println ("Enter the monthly fee: ");
				
				input.next();
			}
			
			this.fee = input.nextDouble();
			
		} while (this.fee <= 0); 
		
		return true;
		
	
		} else {
		return false;
	
	}
		
	}
	/**
	 * the purpose of the method is to calculate and update the current balance.
	 * @return balance after being updated
	 */
	@Override
	public double monthlyAccountUpdate() { //overide method that does the calculation for chequing account fee and updates the amount

		if (balance >= this.fee)
		{
		return balance - this.fee;
		}
		else
		{
			System.err.println ("Error the balance has to be more than the monthly fee.");
		}
		return balance;
	}
	/**
	 * toString method that display the information
	 * @return value from the abstract class and the fee
	 */
	public String toString()
	{
		return super.toString() + " Fee: " +fee+"\n";

	}// end of method



}//end of class
