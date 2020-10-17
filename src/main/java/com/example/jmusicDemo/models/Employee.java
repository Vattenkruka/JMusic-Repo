package com.example.jmusicDemo.models;

public class Employee {

    private int EmployeeID;
    private String LastName;
    private String FirstName;
    private String Title;
    private String ReportsTo;
    private String BirthDate;
    private String HireDate;
    private String Address;
    private String City;
    private String State;
    private String Country;
    private String PostalCode;
    private String Phone;
    private String Fax;
    private String Email;

    // Constructor

    public Employee(int employeeID, String lastName,
                    String firstName, String title,
                    String reportsTo, String birthDate,
                    String hireDate, String address,
                    String city, String state,
                    String country, String postalCode,
                    String phone, String fax, String email) {
        EmployeeID = employeeID;
        LastName = lastName;
        FirstName = firstName;
        Title = title;
        ReportsTo = reportsTo;
        BirthDate = birthDate;
        HireDate = hireDate;
        Address = address;
        City = city;
        State = state;
        Country = country;
        PostalCode = postalCode;
        Phone = phone;
        Fax = fax;
        Email = email;
    }

    // Getters and setters

    public int getEmployeeID() { return EmployeeID; }

    public void setEmployeeID(int employeeID) { EmployeeID = employeeID; }

    public String getLastName() { return LastName; }

    public void setLastName(String lastName) { LastName = lastName; }

    public String getFirstName() { return FirstName; }

    public void setFirstName(String firstName) { FirstName = firstName; }

    public String getTitle() { return Title; }

    public void setTitle(String title) { Title = title; }

    public String getReportsTo() { return ReportsTo; }

    public void setReportsTo(String reportsTo) { ReportsTo = reportsTo; }

    public String getBirthDate() { return BirthDate; }

    public void setBirthDate(String birthDate) { BirthDate = birthDate; }

    public String getHireDate() { return HireDate; }

    public void setHireDate(String hireDate) { HireDate = hireDate; }

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
