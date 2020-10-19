package com.example.jmusicDemo.models;

import java.lang.Math;
import java.util.Random;

// Employee, Customer, Invoice, InvoiceLine
// Track, Genre, osv

// private strings, getters, setters, constructor

public class Customer {

    private int customerId;
    private String firstName;
    private String lastName;
    private String country;
    private String postalCode;
    private String phone;
    private String email;
    private int supportRepId;

    //Constructor for all elements

    public Customer(int customerId, String firstName,
                    String lastName, String country,
                    String postalCode, String phone,
                    String email, int supportRepId) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.postalCode = postalCode;
        this.phone = phone;
        this.email = email;
        this.supportRepId = supportRepId;
    }

    public Customer(int customerId, String country) {
        this.customerId = customerId;
        this.country = country;
    }


    // Getters and Setters

    public int getCustomerId() { return customerId; }

    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public String getPostalCode() { return postalCode; }

    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public int getSupportRepId() { return supportRepId; }

    public void setSupportRepId(int supportRepId) { this.supportRepId = supportRepId; }

    public int randomGeneratedSupportId(){
        return (int) (1 + Math.random() * 5);
    }
}
