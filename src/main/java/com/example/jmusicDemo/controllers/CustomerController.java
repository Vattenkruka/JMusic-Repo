package com.example.jmusicDemo.controllers;

import com.example.jmusicDemo.data_access.CustomerRepository;
import com.example.jmusicDemo.models.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
public class CustomerController {
    CustomerRepository customerRepository = new CustomerRepository();

    // Setup endpoints with @RequestMappings, extract id with @PathVariable
    @RequestMapping(value = "/api/customers", method = RequestMethod.GET)
    public ArrayList<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }

    @RequestMapping(value = "/api/customers/{id}", method = RequestMethod.GET)
    public Customer getSpecificCustomer(@PathVariable String id){
        return customerRepository.getSpecificCustomer(id);
    }
    @RequestMapping(value = "/api/customers", method = RequestMethod.POST)
    public Boolean addCustomer(@RequestBody Customer customer){
        return customerRepository.addCustomer(customer);
    }

    @RequestMapping(value = "/api/popular/country", method = RequestMethod.GET)
    public LinkedHashMap<String, Integer> getCustomersByCountry(){
        return customerRepository.getCustomersByCountry();
    }

    @RequestMapping(value = "/api/customers", method = RequestMethod.PUT)
    public Boolean updateCustomer(@RequestBody Customer customer){
        return customerRepository.updateCustomer(customer);
    }

    @RequestMapping(value = "/api/invoice/total", method = RequestMethod.GET)
    public LinkedHashMap<String, Double> getHighestSpenders(){
        return customerRepository.getHighestSpenders();
    }
}
