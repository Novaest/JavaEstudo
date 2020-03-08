package mobilePhone;

import java.util.ArrayList;

public class MobilePhone {
	private String myPhoneNumber;
	ArrayList<Contact> myContact;
	public MobilePhone(String myPhoneNumber) {
		super();
		this.myPhoneNumber = myPhoneNumber;
		this.myContact = new ArrayList<Contact>();
		
	}
	
	public boolean addNewContact(Contact contact) {
		
		if(findContact(contact.getName())>=0) {
			System.out.println("Contato já está na lista!");
			return false;
		}
		myContact.add(contact);
		return true;
		
	}
	
	private boolean updateContact(Contact oldContact, Contact newContact) {
		int foundPosition = findContact(oldContact); // retorno do metodo em int, para saber se existe
		if(foundPosition < 0) {
			System.out.println(oldContact.getName() + " Contato não encontrado.");
			return false;
		}
		//caso ele exista sua posição já foi encontrada e é então colocado o novo a ser atualizado.
		this.myContact.set(foundPosition, newContact);
		System.out.println(oldContact.getName() +" foi substituido por :" + newContact.getName());
		return true;
	}
	
	//Metodo para achar o Contato pela arraylist
	private int findContact(Contact contact) {
		
		return this.myContact.indexOf(contact);
	}
	//sobrescrita de metodo para achar pelo nome
	private int findContact (String contactName) {
		for( int i = 0; i < myContact.size() ; i++) {
			Contact contact = myContact.get(i);
			if(contact.getName().equals(contactName)) {
				return (i);
				}
		}
		return -1;
	}
	
	
}
