package com.addressbook;

public class ContactPerson {
    String firstName,lastName,address,city,state,eMail,phoneNumber;
    int zipCode;

    public ContactPerson (String firstName,String lastName,String address,String city,String state,
                        int zipCode,String eMail, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getAddress() {
        return address;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public int getZipCode() {
        return zipCode;
    }
    public String getMail() {
        return eMail;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
    public void setMail(String eMail) {
        this.eMail = eMail;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void addressBook() {
        System.out.println("First Name: "+firstName);
        System.out.println("Last Name: "+lastName);
        System.out.println("Address: "+address);
        System.out.println("City: "+city);
        System.out.println("State: "+state);
        System.out.println("ZipCode: "+zipCode);
        System.out.println("Email Address: "+eMail);
        System.out.println("Phone Number: "+phoneNumber);
    }
}
