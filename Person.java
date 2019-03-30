
/**
 * File Name: Person.java
 * @author Dante Beltran
 * Assignment: Bank Program
 * Date: March 17,2019
 */

/**
 * The purpose of this class is to create a person object that contains first name, last name, phone number and email address
 * @author Dante Beltran
 * @version %I% %G%
 * @since 1.8.0_181
 */
public class Person {
	private String firstName;
	private String lastName;
	private long phoneNum;
	private String emailAddress;
	
	/**
	 * Default constructor thats sets all values to default
	 */
	public Person () {
		this.firstName = "";
		this.lastName = "";
		this.phoneNum = 0;
		this.emailAddress = "";
	}
	
	/**
	 * Initial constructor and initialize the new values
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 * @param emailAddress
	 */
	public Person(String firstName, String lastName,long phoneNum, String emailAddress) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.emailAddress = emailAddress;
	}
	/**
	 * the purpose of this method is  to achieve the full name
	 * @return first name and last name with a space in between (full name)
	 */
	public String getName() {
		
		return firstName + " " + lastName;
	}
	
	/**
	 * the purpose of this method is to get the phone number of the person
	 * @return the phone number
	 */
	public long getPhoneNum() {
		
		return phoneNum;
	}
	/**
	 * the purpose of this method is to get the email address of the person
	 * @return the email address
	 */
	public String getEmailAddress() {
		
		return emailAddress;
	}
	
	
}
