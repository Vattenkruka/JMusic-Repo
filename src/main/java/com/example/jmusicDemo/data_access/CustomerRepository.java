
package com.example.jmusicDemo.data_access;


import com.example.jmusicDemo.models.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerRepository {
    // Setting up the connection object we need.
    private String URL = "jdbc:sqlite::resource:Chinook_Sqlite.sqlite";
    private Connection conn = null;

    /*
     Setup methods to manipulate database, using conn = DriverManager.getConnection(URL);
     and prepared statements.
    */

    //CRUD

    public ArrayList<Customer> getAllCustomers(){
        ArrayList<Customer> customers = new ArrayList<>();
        // ---
        try{
            // connect
            conn = DriverManager.getConnection(URL);
            PreparedStatement prep =
                    conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, SupportRepId FROM Customer");
            ResultSet set = prep.executeQuery();
            while(set.next()){
                customers.add( new Customer(
                        set.getInt("CustomerId"),
                        set.getString("FirstName"),
                        set.getString("LastName"),
                        set.getString("Country"),
                        set.getString("PostalCode"),
                        set.getString("Phone"),
                        set.getInt("SupportRepId")
                ));
            }
            System.out.println("Get all went well!");

        }catch(Exception exception){
            System.out.println(exception.toString());
        }
        finally {
            try{
                conn.close();
            } catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
        // ---
        return customers;
    }/*
     public Customer getSpecificCustomer(String id){
        Customer customer = null;
        // ---
        try{
            // connect
            conn = DriverManager.getConnection(URL);
            PreparedStatement prep =
                    conn.prepareStatement("SELECT CustomerID, Company, FirstName, Phone " +
                            "FROM customer WHERE Id=?");
            prep.setString(1,id);
            ResultSet set = prep.executeQuery();
            while(set.next()){
                customer = new Customer(
                        set.getString("CustomerID"),
                        set.getString("Company"),
                        set.getString("FirstName"),
                        set.getString("Phone")
                );
            }
            System.out.println("Get specific went well!");

        }catch(Exception exception){
            System.out.println(exception.toString());
        }
        finally {
            try{
                conn.close();
            } catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
        // ---

        return customer;
    }

    public Boolean addCustomer(Customer customer){
        Boolean success = false;
        try{
            // connect
            conn = DriverManager.getConnection(URL);
            PreparedStatement prep =
                    conn.prepareStatement("INSERT INTO customer(Id,CompanyName,ContactName,Phone)" +
                            " VALUES(?,?,?,?)");
            prep.setString(1,customer.getCustomerId());
            prep.setString(2,customer.getCompanyName());
            prep.setString(3,customer.getContactName());
            prep.setString(4,customer.getPhone());

            int result = prep.executeUpdate();
            success = (result != 0); // if res = 1; true

            System.out.println("Add went well!");

        }catch(Exception exception){
            System.out.println(exception.toString());
        }
        finally {
            try{
                conn.close();
            } catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
        // ---
        return success;
    }

    public Boolean updateCustomer(Customer customer){
        Boolean success = false;
        try{
            // connect
            conn = DriverManager.getConnection(URL);
            PreparedStatement prep =
                    conn.prepareStatement("UPDATE customer SET Id=?, CompanyName=?, ContactName=?,Phone=?" +
                            " WHERE Id=?");
            prep.setString(1,customer.getCustomerId());
            prep.setString(2,customer.getCompanyName());
            prep.setString(3,customer.getContactName());
            prep.setString(4,customer.getPhone());
            prep.setString(5,customer.getCustomerId());

            int result = prep.executeUpdate();
            success = (result != 0); // if res = 1; true

            System.out.println("Update went well!");

        }catch(Exception exception){
            System.out.println(exception.toString());
        }
        finally {
            try{
                conn.close();
            } catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
        // ---
        return success;
    }

 */
}

