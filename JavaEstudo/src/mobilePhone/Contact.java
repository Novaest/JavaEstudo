package mobilePhone;



public class Contact {

	private String name;
	private String phoneNumber;
	
	//Constructor
	public Contact(String name, String phoneNumber) {
		this.name=name;
		this.phoneNumber = phoneNumber;
	}
	//Getters And Setters
	public String getName() {
		return name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public static Contact createContact(String name, String phoneNumber) {
		
		return new Contact(name, phoneNumber);
	}
	
	

	
	
	
	
}
