package com.example.jmusicDemo.models;

// Employee, Customer, Invoice, InvoiceLine
// Track, Genre, osv

//

public class Customer {
    private String customerId;
    private String companyName;
    private String contactName;
    private String phone;
    public Customer() {
    }

    public Customer(String customerId, String companyName, String contactName, String phone) {
        this.customerId = customerId;
        this.companyName = companyName;
        this.contactName = contactName;
        this.phone = phone;
    }

    // Getters and setters

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
