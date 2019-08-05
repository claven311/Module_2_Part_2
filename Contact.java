package contactBookCreator;

public class Contact implements Comparable<Contact> {
	 
	  private String firstName;
	  private String lastName;
	  private String address;
	  private String phoneNumber;
	 

	  /*
	   * Parameterized constructor
	   * @param firstName String to store in firstName
	   * @param lastName String to store in lastName
	   * @param address String to store in address
	   * @param phoneNumber String to store in phoneNumber
	   */
	 
	  public Contact(String firstName, String lastName, String address, String phoneNumber) {
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.address = address;
	    this.phoneNumber = phoneNumber;
	  }
	 
	  /*
	   * Default constructor
	   * Calls parameterized constructor and sets all fields to "empty"
	   */
	 
	  public Contact() {
	    this("empty", "empty", "empty", "empty");
	  }
	
	  /*
	   * Method compareTo is used to compare two Contact objects.
	   * Contact objects are compared by first name, then last name,
	   * then address, then phone number.
	   * @override Overrides the default compareTo() method for an object
	   * @param other A second Contact object to be compared to the calling object
	   * @return result An integer.  Returns a negative integer for less than, a positive
	   * integer for greater than, and zero for identical Contact objects
	   */
	  
	  
	  @Override
	  public int compareTo(Contact other) {
	  
	    int result = this.firstName.compareTo(other.firstName);
	   
	    if (result == 0) {
	      result = this.lastName.compareTo(other.lastName);
	    }
	    if (result == 0) {
	      result = this.address.compareTo(other.address);
	    }
	    if (result == 0) {
	      result = this.phoneNumber.compareTo(other.phoneNumber);
	    }
	    return result;
	  
	  }
	  
	  /*
	   * Method toString 
	   * @override Overrides the default toString method
	   * @return String Returns a string listing a Contact objects
	   * first name, last name, address, and phone number fields
	   */
	  
	  @Override
	  public String toString() 
	  {
		  
		  return ("Contact:\n" + "First Name: " + firstName + "\nLast Name: " + lastName + 
				  "\nAddress: " + address + "\nPhone Number: " + phoneNumber + "\n\n");
	  }
	  
	 
	  /*
	   *Method setFirstName assigns a value to the firstName field
	   *@param firstName The value to store in firstName
	   */
	  public void setFirstName(String firstName) {
	    this.firstName = firstName;
	  }
	 
	  /*
	   *Method setLastName assigns a value to the lastName field
	   *@param lastName The value to store in lastName
	   */
	  public void setLastName(String lastName) {
	    this.lastName = lastName;
	  }
	 
	  /*
	   *Method setAddress assigns a value to the address field
	   *@param address The value to store in address
	   */
	  public void setAddress(String address) {
	    this.address = address;
	  }
	  
	  /*
	   *Method setPhoneNumber assigns a value to the phoneNumber field
	   *@param phoneNumber The value to store in phoneNumber
	   */
	  public void setPhoneNumber(String phoneNumber) {
	    this.phoneNumber = phoneNumber;
	  }
	 
	  /*
	   *Method getFirstName retrieves a Contact object's firstName field
	   *return firstName A string of the Contact's firstName field
	   */ 
	  public String getFirstName() {
	    return firstName;
	  }
	  
	  /*
	   *Method getLastName retrieves a Contact object's lastName field
	   *return lastName A string of the Contact's lastName field
	   */
	  public String getLastName() {
	    return lastName;
	  }
	  
	  /*
	   *Method getAddress retrieves a Contact object's address field
	   *return address A string of the Contact's address field
	   */
	  public String getAddress() {
	    return address;
	  }
	 
	  /*
	   *Method getPhoneNumber retrieves a Contact object's phoneNumber field
	   *return phoneNumber A string of the Contact's phoneNumber field
	   */
	  public String getPhoneNumber() {
	    return phoneNumber;
	  }
	  
	}
