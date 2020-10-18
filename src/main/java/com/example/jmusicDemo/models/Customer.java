package com.example.jmusicDemo.models;

// Employee, Customer, Invoice, InvoiceLine
// Track, Genre, osv

// private strings, getters, setters, constructor

public class Customer {

    private int CustomerId;
    private String FirstName;
    private String LastName;
    private String Country;
    private String PostalCode;
    private String Phone;
    private int SupportRepId;

    //Constructor for all elements

    public Customer(int customerId, String firstName,
                    String lastName, String country,
                    String postalCode, String phone, int supportRepId) {
        this.CustomerId = customerId;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Country = country;
        this.PostalCode = postalCode;
        this.Phone = phone;
        this.SupportRepId = supportRepId;
    }

    // Getters and Setters


    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public int getSupportRepId() {
        return SupportRepId;
    }

    public void setSupportRepId(int supportRepId) {
        SupportRepId = supportRepId;
    }
}
