package mobilePhone;

import java.util.Scanner;

public class Main {
	
	private static Scanner scanner = new Scanner(System.in);
	private static MobilePhone mobilePhone = new MobilePhone("000 333 444 555");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		boolean quit = false;
		startPhone();
		printActions();
		while(!quit) {
			System.out.println("\nEnter a action: (6 to show available actions)");
			int action = scanner.nextInt();
			scanner.nextLine();
			
			switch( action) {
			case 0:
				System.out.println("\nShutting Down");
				quit = true;
				break;
			case 1: 
				mobilePhone.printContact();
				break;
				
			case 2:
				addNewContact();
				break;
			case 3:
				updateContact();
				break;
			case 4:
				removeContact();
				break;
			case 5:
				queryContact();
				break;
			case 6:
				printActions();
				break;
			}
		}
	}
	
    private static void addNewContact() {
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phone = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phone);
        if(mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added: name = " + name + ", phone = "+ phone);
        } else {
            System.out.println("Cannot add, " + name + " already on file");
        }
    }
		private static void updateContact() {
			System.out.println("Enter existing contact name: ");
			String name = scanner.nextLine();
			Contact existingContactRecord = mobilePhone.queryContact(name);
			if(existingContactRecord == null) {
				System.out.println("Contact not found");
				return;
			}
			System.out.println("Enter new contact name: ");
			String newName = scanner.nextLine();
			System.out.println("New contact phone number :");
			String newNumber = scanner.nextLine();
			Contact newContact = Contact.createContact(newName, newNumber);
			
				if(mobilePhone.updateContact(existingContactRecord, newContact)) {
					System.out.println("Sucessfully update record");
				}else {
					System.out.println("Error updating record");
				}
			
		}
		private static void removeContact() {
			System.out.println("Enter existing contact name: ");
			String name = scanner.nextLine();
			Contact existingContactRecord = mobilePhone.queryContact(name);
			if(existingContactRecord == null) {
				System.out.println("Contact not found");
				return;
			}
			if(mobilePhone.removeContact(existingContactRecord)) {
				System.out.println("Sucessfully deletead");
				
			}
			else {
				System.out.println("Error in deleating contact");
			}
			
		}
		private static void queryContact() {
			System.out.println("Enter existing contact name: ");
			String name = scanner.nextLine();
			Contact existingContactRecord = mobilePhone.queryContact(name);
			if(existingContactRecord == null) {
				System.out.println("Contact not found");
				return;
			}
			System.out.println("Name  "+ existingContactRecord.getName() + "phone number is " + existingContactRecord.getPhoneNumber());
		}
		
		

		private static void startPhone() {
			System.out.println("Starting phone...");
		}
		private static void printActions() {
			System.out.println("\nAvailable actions:\nPress");
			System.out.println("9 - to shutdown\n" +
								"1 - to print contacts\n" +
								"2 - to add a new contact\n" +
								"3 - to update an existing contact\n" +
								"4 - to remove an existing contact\n" +	
								"5 - to query if an existing contact existis\n" + 
								"6 - to print a list of available actions\n");
			System.out.println("Chooose your action: ");
			
			
		}

	
	
}
