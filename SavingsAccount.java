
/**
 * File Name: SavingsAccount.java
 * @author Dante Beltran
 * Assignment: Bank Program
 * Date: March 17,2019
 */
/**
 * The purpose of this class is carry everything in the abstract class with added variables like interestRate and minBalance
 * This class will also calculate and update the balance
 * @author Dante Beltran
 * @version %I% %G%
 * @since 1.8.0_181
 */
public class SavingsAccount extends BankAccount { //savings account extends bank account class

	private double interestRate;//creating interest rate public variable
	private double minBalance;

	/**
	 * Default constructor to set default value
	 */
	public SavingsAccount() {
		super();
		this.interestRate = 0.0;
		this.minBalance = 0.0;
	}
	
	/**
	 * Initial constructor to initialize new values
	 * @param accountNo
	 * @param accHolder
	 * @param balance
	 * @param interestRate
	 * @param minBalance
	 */
	public SavingsAccount (long accountNo, Person accHolder, double balance,  double interestRate, double minBalance) { //method that carries the super variables over and initializes InterestRate

		super(interestRate, accountNo, accHolder);
		this.interestRate = interestRate; //initializing interest rate
		this.minBalance = minBalance;
	}
	/**
	 *The purpose of this method is to continue from abstract class that gather information like minimum balance and the interest rate
	 * @return whether true (valid input) or false (invalid input)
	 */
	public boolean addBankAccount() {
		boolean isTrue = super.addBankAccount();
		
		if (isTrue) {
		
		
			do {
				System.out.println("Enter the minimum balance: ");
				while (!input.hasNextDouble())
				{
					System.err.println("That is not a valid value");
					
					System.out.println("Enter the minimum balance: ");
					
					input.next();
				}
				this.minBalance = input.nextDouble();
				
			} while (this.minBalance <= 0 || this.minBalance >= balance); 
			
			do {
				System.out.println("Enter the interest rate: (should be a number in (0,1))");
				while (!input.hasNextDouble()){
					System.err.println("That is not a valid value");
					System.out.println("Enter the interest rate: (should be a number in (0,1))");
					input.next();
				}
				this.interestRate = input.nextDouble();
				
			} while (this.interestRate <= 0 || this.interestRate >= 1); 
			
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * the purpose of this method is to calculate and update the current balance
	 * @return the current balance after being updated
	 */
	@Override
	public double monthlyAccountUpdate() { //method that does the calculation for adding the interest rate
		
			if (balance >= this.minBalance)
			{
			return balance*this.interestRate + balance;
			}
			else
			{
				System.err.println ("Error the balance has to be more than the minimum balance.");
			}
			return balance;
		
	}


	/**
	 * the purpose of this method is to continue the toString method that display the information
	 * @return value from the abstract class and minimum balance and the interest rate
	 */
	public String toString()  {// this toString method creates a new deciaml format and applies it to the new interest rate


		return super.toString() + " Minimum balance: " +minBalance+ " Interest Rate: " + interestRate+"\n";

	}// end of method

}// end of class
