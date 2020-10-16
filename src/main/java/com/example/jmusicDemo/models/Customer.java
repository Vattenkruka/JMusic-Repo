package com.example.jmusicDemo.models;

// Employee, Customer, Invoice, InvoiceLine
// Track, Genre, osv

// private strings, getters, setters, constructor

public class Customer {
    private String CustomerId;
    private String FirstName;
    private String LastName;
    private String Company;
    private String Address;
    private String City;
    private String State;
    private String Country;
    private String PostalCode;
    private String Phone;
    private String Fax;
    private String Email;
    //private String SupportRepId;
    public Customer() {
    }

    //Constructor for all elements
    public Customer(String customerId, String firstName,
                    String lastName, String company,
                    String address, String city,
                    String state, String country,
                    String postalCode, String phone,
                    String fax, String email) {
        CustomerId = customerId;
        FirstName = firstName;
        LastName = lastName;
        Company = company;
        Address = address;
        City = city;
        State = state;
        Country = country;
        PostalCode = postalCode;
        Phone = phone;
        Fax = fax;
        Email = email;
    }

    // Getters and Setters

    public String getCustomerId() { return CustomerId; }

    public void setCustomerId(String customerId) { CustomerId = customerId; }

    public String getFirstName() { return FirstName; }

    public void setFirstName(String firstName) { FirstName = firstName; }

    public String getLastName() { return LastName; }

    public void setLastName(String lastName) { LastName = lastName; }

    public String getCompany() { return Company; }

    public void setCompany(String company) { Company = company; }

    public String getAddress() { return Address; }

    public void setAddress(String address) { Address = address; }

    public String getCity() { return City; }

    public void setCity(String city) { City = city; }

    public String getState() { return State; }

    public void setState(String state) { State = state; }

    public String getCountry() { return Country; }

    public void setCountry(String country) { Country = country; }

    public String getPostalCode() { return PostalCode; }

    public void setPostalCode(String postalCode) { PostalCode = postalCode; }

    public String getPhone() { return Phone; }

    public void setPhone(String phone) { Phone = phone; }

    public String getFax() { return Fax; }

    public void setFax(String fax) { Fax = fax; }

    public String getEmail() { return Email; }

    public void setEmail(String email) { Email = email; }
}
