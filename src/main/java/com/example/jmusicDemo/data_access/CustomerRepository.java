
package com.example.jmusicDemo.data_access;


import com.example.jmusicDemo.models.Customer;
import com.example.jmusicDemo.models.Genre;
import com.example.jmusicDemo.models.PopularGenre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class CustomerRepository {
    // Setting up the connection object we need.
    private Connection conn = null;

    //A function which Reads all customers
    public ArrayList<Customer> getAllCustomers(){

        ArrayList<Customer> customers = new ArrayList<>();
        String customerQuery = "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email, SupportRepId FROM Customer";


        try{

            conn = ConnectionHelper.getConnection();
            PreparedStatement prep =
                    conn.prepareStatement(customerQuery);
            ResultSet set = prep.executeQuery();
            while(set.next()){
                customers.add( new Customer(
                        set.getInt("CustomerId"),
                        set.getString("FirstName"),
                        set.getString("LastName"),
                        set.getString("Country"),
                        set.getString("PostalCode"),
                        set.getString("Phone"),
                        set.getString("Email"),
                        set.getInt("SupportRepId")
                ));
            }
            System.out.println("Get all went well!");
            set.close();
            prep.close();
        }catch(Exception exception){
            System.out.println(exception.toString());
        }
        finally {
            try{
                ConnectionHelper.close(conn);
            } catch (Exception exception){
                System.out.println(exception.toString());
            }
        }

        return customers;
    }
     public Customer getSpecificCustomer(String id){
        Customer customer = null;
        String specificCustomerQuery = "SELECT CustomerId, FirstName, LastName, Country, " +
                "PostalCode, Phone, Email, SupportRepId FROM Customer WHERE CustomerId=?";


        try{

            conn = ConnectionHelper.getConnection();
            PreparedStatement prep =
                    conn.prepareStatement(specificCustomerQuery);
            prep.setString(1,id);
            ResultSet set = prep.executeQuery();
            while(set.next()){
                customer = new Customer(
                        set.getInt("CustomerId"),
                        set.getString("FirstName"),
                        set.getString("LastName"),
                        set.getString("Country"),
                        set.getString("PostalCode"),
                        set.getString("Phone"),
                        set.getString("Email"),
                        set.getInt("SupportRepId")
                );
            }
            System.out.println("Get specific went well!");

        }catch(Exception exception){
            System.out.println(exception.toString());
        }
        finally {
            try{
                ConnectionHelper.close(conn);
            } catch (Exception exception){
                System.out.println(exception.toString());
            }
        }


        return customer;
    }
    public Boolean addCustomer(Customer customer){
        Boolean success = false;
        String addCustomerQuery = "INSERT INTO customer(FirstName, LastName, Country, PostalCode, Phone, Email, SupportRepId) " +
                "VALUES(?,?,?,?,?,?,?)";

        try{

            conn = ConnectionHelper.getConnection();
            PreparedStatement prep =
                    conn.prepareStatement(addCustomerQuery);
            prep.setString(1,customer.getFirstName());
            prep.setString(2,customer.getLastName());
            prep.setString(3,customer.getCountry());
            prep.setString(4,customer.getPostalCode());
            prep.setString(5,customer.getPhone());
            prep.setString(6,customer.getEmail());
            prep.setInt(7,customer.randomGeneratedSupportId());

            int result = prep.executeUpdate();
            success = (result != 0); // if res = 1; true

            System.out.println("Add went well!");

        }catch(Exception exception){
            System.out.println(exception.toString());
        }
        finally {
            try{
                ConnectionHelper.close(conn);
            } catch (Exception exception){
                System.out.println(exception.toString());
            }
        }

        return success;
    }

    public LinkedHashMap<String, Integer> getCustomersByCountry(){

        LinkedHashMap<String,Integer> customerCountry = new LinkedHashMap<>();
        String customerCountryQuery = "SELECT DISTINCT Country, Count(*) FROM Customer GROUP BY Country ORDER BY count(CustomerId) DESC";

        // ---
        try{
            // connect
            conn = ConnectionHelper.getConnection();
            PreparedStatement prep =
                    conn.prepareStatement(customerCountryQuery);
            ResultSet set = prep.executeQuery();
            while(set.next()){
                customerCountry.put(
                        set.getString("Country"),
                        set.getInt("Count(*)")
                );
            }
            System.out.println("Get all went well!");
            set.close();
            prep.close();
        }catch(Exception exception){
            System.out.println(exception.toString());
        }
        finally {
            try{
                ConnectionHelper.close(conn);
            } catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
        // ---
        return customerCountry;
    }

    public Boolean updateCustomer(Customer customer){
        Boolean success = false;
        try{

            conn = ConnectionHelper.getConnection();
            PreparedStatement prep =
                    conn.prepareStatement("UPDATE customer SET FirstName=?, LastName=?,Country=?, PostalCode=?, Phone=?, Email=?, SupportRepId=?" +
                            " WHERE CustomerId=?");
            prep.setString(1,customer.getFirstName()); //Maybe refactor this duplication of code
            prep.setString(2,customer.getLastName());
            prep.setString(3,customer.getCountry());
            prep.setString(4, customer.getPostalCode());
            prep.setString(5,customer.getPhone());
            prep.setString(6,customer.getEmail());
            prep.setInt(7,customer.getSupportRepId());
            prep.setInt(8,customer.getCustomerId());


            int result = prep.executeUpdate();
            success = (result != 0); // if result = 1; true

            System.out.println("Update went well!");

        }catch(Exception exception){
            System.out.println(exception.toString());
        }
        finally {
            try{
                ConnectionHelper.close(conn);
            } catch (Exception exception){
                System.out.println(exception.toString());
            }
        }

        return success;
    }

    public LinkedHashMap<String, Double> getHighestSpenders(){

        LinkedHashMap<String, Double> highestSpenders = new LinkedHashMap<>();
        String invoiceTotalQuery =
                "SELECT  customer.Firstname, customer.LastName, round( SUM(invoice.Total),2)" +
                "AS total FROM Customer customer" +
                "JOIN Invoice invoice ON customer.CustomerId = invoice.CustomerId" +
                "GROUP BY customer.customerId" +
                "ORDER BY total DESC;";

        // ---
        try{
            // connect
            conn = ConnectionHelper.getConnection();
            PreparedStatement prep =
                    conn.prepareStatement(invoiceTotalQuery);
            ResultSet set = prep.executeQuery();
            while(set.next()){
                String customerName = set.getString("FirstName") + " " + set.getString("LastName");

                highestSpenders.put(customerName,set.getDouble("total"));
            }
            System.out.println("Get all went well!");
            set.close();
            prep.close();
        }catch(Exception exception){
            System.out.println(exception.toString());
        }
        finally {
            try{
                ConnectionHelper.close(conn);
            } catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
        // ---
        return highestSpenders;
    }

    public ArrayList<PopularGenre> getMostPopularGenre(String id) {

        ArrayList<PopularGenre> popularGenre = new ArrayList<>();
        String popularGenreQuery =
                "SELECT Customer.FirstName, Customer.LastName, Genre.Name, count(Track.GenreId) mostPopular " +
                        "FROM Customer " +
                        "JOIN Invoice " +
                        "ON Customer.CustomerId = Invoice.CustomerId " +
                        "JOIN InvoiceLine " +
                        "ON Invoice.InvoiceId = InvoiceLine.InvoiceId " +
                        "JOIN Track " +
                        "ON InvoiceLine.TrackId = Track.TrackId " +
                        "JOIN Genre " +
                        "ON Track.GenreId = Genre.GenreId " +
                        "WHERE Customer.CustomerId=? " +
                        "GROUP BY Genre.GenreId " +
                        "ORDER BY mostPopular DESC;";

        try {
            conn = ConnectionHelper.getConnection();
            PreparedStatement prep =
                    conn.prepareStatement(popularGenreQuery);
            prep.setString(1,id);
            ResultSet set = prep.executeQuery();
            while (set.next()) {
                popularGenre.add(new PopularGenre(
                        set.getString("FirstName"),
                        set.getString("LastName"),
                        set.getString("Name"),
                        set.getInt("mostPopular")));
            }

            System.out.println("Get all went well!");
            popularGenre = PopularGenre.compareGenre(popularGenre);
            
            set.close();
            prep.close();
        }catch(Exception exception){
            System.out.println(exception.toString());
        }
        finally {
            try{
                ConnectionHelper.close(conn);
            } catch (Exception exception){
                System.out.println(exception.toString());
            }
        }

        return popularGenre;
    }



}

