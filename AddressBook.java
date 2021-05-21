package com.addressbook;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Create Class for Defining the Address Book
 */
public class AddressBook {
    public static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<ContactPerson> person = new ArrayList<>();
    private static HashMap<String, ArrayList<ContactPerson>> addressBookSystem = new HashMap<>();

    /**
     * Create Method to Add the Contact List.
     */
    void addContactDetails () {
        System.out.println("How Many Contacts Do You Want to Enter In Address Book");
        int numberOfContacts = sc.nextInt();
        for (int i=1; i<=numberOfContacts; i++ ) {
            Scanner sc = new Scanner(System.in);
            System.out.println("enter the First Name");
            String firstName = sc.nextLine();
            System.out.println("enter the Last Name");
            String lastName = sc.nextLine();
            System.out.println("enter the Address");
            String address = sc.nextLine();
            System.out.println("enter the City");
            String city = sc.nextLine();
            System.out.println("enter the State");
            String state = sc.nextLine();
            System.out.println("enter the Zip Code");
            int zipCode = sc.nextInt();
            sc.nextLine();
            System.out.println("enter the Email address");
            String eMail = sc.nextLine();
            System.out.println("enter the Phone Number");
            String phoneNumber = sc.nextLine();

            ContactPerson contacts = new ContactPerson(firstName, lastName, address, city, state, zipCode, eMail, phoneNumber);
            contacts.addressBook();  // Printing the Contact list
            String pName = firstName + lastName;
            for (Iterator<ContactPerson> iterator = person.iterator(); iterator.hasNext();) {
                ContactPerson temp = iterator.next();
                String contactName =  temp.getFirstName() + temp.getLastName();
                if(contactName.equals(pName)) {
                    System.out.println("Sorry this contact already exists.");
                    return; // the name exists, so we exit the method.
                }
            }
            // Otherwise... you've checked all the elements, and have not found a duplicate
            person.add(contacts);    //Adding Contact list to ArrayList
        }

    }

    /**
     * Create Method to Edit the Contact using First Name.
     */
    public static void editContactDetailsByFirstName() {
        System.out.println("Enter First Name to verify and edit the Contact list");
        Scanner sc = new Scanner(System.in);
        String firstName = sc.nextLine();
        for (Iterator<ContactPerson> iterator = person.iterator(); iterator.hasNext();) {
            ContactPerson temp = iterator.next();
            if (temp.getFirstName().equalsIgnoreCase(firstName)) {
                System.out.println("1.First Name\n,2.Second Name\n,3.Address\n,4.City\n,5.State\n,6.Zip Code\n,7.Email Address\n,8.Phone Number\n");
                System.out.println("Enter the choice What you want to Edit");
                int choice = sc.nextInt();
                switch (choice) {       // choosing which option as to edit
                    case 1 -> {
                        System.out.println("Enter the New First Name");
                        Scanner sc1 = new Scanner(System.in);
                        firstName = sc1.nextLine();
                        temp.setFirstName(firstName);
                    }
                    case 2 -> {
                        System.out.println("Enter the New Last Name");
                        Scanner sc2 = new Scanner(System.in);
                        String lastName = sc2.nextLine();
                        temp.setLastName(lastName);
                    }
                    case 3 -> {
                        System.out.println("Enter the Address");
                        Scanner sc3 = new Scanner(System.in);
                        String address = sc3.nextLine();
                        temp.setAddress(address);
                    }
                    case 4 -> {
                        System.out.println("Enter the New City");
                        Scanner sc4 = new Scanner(System.in);
                        String city = sc4.nextLine();
                        temp.setCity(city);
                    }
                    case 5 -> {
                        System.out.println("Enter the New State");
                        Scanner sc5 = new Scanner(System.in);
                        String state = sc5.nextLine();
                        temp.setState(state);
                    }
                    case 6 -> {
                        System.out.println("Enter the New Zip Code");
                        Scanner sc6 = new Scanner(System.in);
                        int zipCode = sc6.nextInt();
                        temp.setZipCode(zipCode);
                    }
                    case 7 -> {
                        System.out.println("Enter the New Email Address");
                        Scanner sc7 = new Scanner(System.in);
                        String eMail = sc7.nextLine();
                        temp.setMail(eMail);
                    }
                    case 8 -> {
                        System.out.println("Enter the New Phone Number");
                        Scanner sc8 = new Scanner(System.in);
                        String phoneNumber = sc8.nextLine();
                        temp.setPhoneNumber(phoneNumber);
                    }
                }
                System.out.println("Contacts are Updated");
                for (int i = 1; i<=person.size(); i++) {     //Printing the Updated Contact
                    System.out.println("FirstName: " + person.get(i).firstName + "\nLastName: " + person.get(i).lastName + "\nAddress: " + person.get(i).address +
                            "\nCity: " + person.get(i).city + "\nState: " + person.get(i).state + "\nZipCode: " + person.get(i).zipCode + "\nEmailAddress: " + person.get(i).eMail +
                            "\nPhoneNumber: " + person.get(i).phoneNumber);
                return;
                }
            }
        }
        System.out.println("No Contact Found To Edit");
    }

    /**
     * Create Method to Delete the Contact. Will work  as there is no  contacts with  first name.
     */
        public static void deleteContactByFirstName() {
        System.out.println("Enter the First Name to verify and delete the contact");
        Scanner sc = new Scanner(System.in);
        String firstName = sc.nextLine();
        int flag = 0;
        for (Iterator<ContactPerson> iterator = person.iterator(); iterator.hasNext();) {
            ContactPerson temp = iterator.next();
            if (temp.getFirstName().equalsIgnoreCase(firstName)){
                iterator.remove();
                System.out.println("The Contact with First Name " +firstName+ " Deleted Successfully");
                return;
            }
        }
        System.out.println("No contact With First Name " +firstName+ " will found" );
    }

    /**
     * Create Method to Search the Contact By Using City Name
     */
    public void searchPersonByCity() {
        System.out.println("Enter the City");
        Scanner sc = new Scanner(System.in);
        String city = sc.nextLine();
        List<ContactPerson> search = person.stream().filter(first -> first.getCity().equals(city)).collect(Collectors.toList());
            for (ContactPerson contacts : search ) {
                System.out.println("FirstName: " +contacts.getFirstName());
                System.out.println("LastName: " +contacts.getLastName());
            }
    }

    /**
     * Create Method to Search the Contact By Using State Name
     */
    public void searchPersonByState() {
        System.out.println("Enter the State");
        Scanner sc = new Scanner(System.in);
        String state = sc.nextLine();
        List<ContactPerson> search = person.stream().filter(first -> first.getState().equals(state)).collect(Collectors.toList());
        for (ContactPerson contacts : search ) {
            System.out.println("FirstName: " +contacts.getFirstName());
            System.out.println("LastName: " +contacts.getLastName());
        }
    }

    // Explaining the Method How We Implement
    public static void addressBook() {
        boolean option = false;
        while (true) {
            System.out.println("1.Add the Contact\n, 2.Edit the Contact list\n, 3.Delete the Contact\n, 4.SearchContactByCity\n, 5.SearchContactByState\n, 6.Exit the loop");
            System.out.println("Enter the choice What you want do");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    AddressBook addContact = new AddressBook();
                    addContact.addContactDetails();     //calling AddContact Method
                    option = true;
                }
                case 2 -> {
                    AddressBook editContact = new AddressBook();
                    editContact.editContactDetailsByFirstName();   // Calling Edit Contact method
                    option = true;
                }
                case 3 -> {
                    AddressBook deleteContact = new AddressBook();
                    deleteContact.deleteContactByFirstName();       //Calling Delete Contact Method
                    option = true;
                }
                case 4 -> {
                    AddressBook searchContact = new AddressBook();
                    searchContact.searchPersonByCity();
                }
                case 5 -> {
                    AddressBook searchContact = new AddressBook();
                    searchContact.searchPersonByState();
                }
                case 6 -> {
                    System.exit(0);
                }
                default -> {
                    System.out.println("Choice is incorrect");
                }
            }
        }
    }

    public static void main (String[] args) {
        System.out.println("Welcome to Address Book Program in AddressBook in Main Class");
        System.out.println("Enter the Name of the Address Book");
        sc.nextLine();
        String addressBookName = sc.nextLine();
        if (addressBookSystem.containsKey(addressBookName)) {
            System.out.println("This Address Book System Already Exists");
        } else {
            AddressBook addAddressBook = new AddressBook();
            addressBookSystem.put(addressBookName, person);
            addAddressBook.addressBook();
        }
    }
}
