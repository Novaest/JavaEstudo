package mobilePhone;

import java.util.ArrayList;

public class MobilePhone {
	private String myNumber;
	ArrayList<Contact> myContact;
	
	public MobilePhone(String myNumber) {
		this.myNumber = myNumber;
		this.myContact = new ArrayList<Contact>();
		
	}
	
	public boolean addNewContact(Contact contact) {
		
		if( findContact(contact.getName()) >=0) {
			System.out.println("Contato já está na lista!");
			return false;
		}
		myContact.add(contact);
		return true;
		
	}
	public boolean updateContact(Contact oldContact, Contact newContact) {
		int foundPosition = findContact(oldContact); // return of the method, in integer.
		if(foundPosition < 0) {
			System.out.println(oldContact.getName() + " Contato não encontrado.");
			return false;
		}
		// if exist replace  old contact, the position it's already find
		this.myContact.set(foundPosition, newContact);
		System.out.println(oldContact.getName() +" foi substituido por :" + newContact.getName());
		return true;
	}

	public boolean removeContact(Contact contact) {
		int foundPosition = findContact(contact); // return of the method, in integer.
		if(foundPosition < 0) {
			System.out.println(contact.getName() + " Contato não encontrado.");
			return false;
		}
		this.myContact.remove(foundPosition);
		System.out.println(contact.getName() +" Foi removido com sucesso!");
		return true;
	}
	
	//Method for find the index of the array
	private int findContact(Contact contact) {
		
		return this.myContact.indexOf(contact);
	}
	//overwrite for find the contact
	private int findContact (String contactName) {
		for( int i = 0; i < myContact.size() ; i++) {
			Contact contact = myContact.get(i);
			if(contact.getName().equals(contactName)) {
				return i;
				}
		}
		return -1;
	}
	
	public String querryContact (Contact contact ) {
		
		if(findContact(contact) >= 0) {
			return contact.getName();
			}
		return null;
		
	}
	public Contact queryContact(String name) {
		int position = findContact(name);
		if(position >= 0) {
			return this.myContact.get(position);
		}
		return null;
	}
	public void printContact() {
		System.out.println("Contact List");
		for(int i = 0 ; i < this.myContact.size(); i++) {
			System.out.println( (i+1) + "." +
								this.myContact.get(i).getName() + " -> " +
								this.myContact.get(i).getPhoneNumber());
		}
	}
	
	
	
	
	
}
