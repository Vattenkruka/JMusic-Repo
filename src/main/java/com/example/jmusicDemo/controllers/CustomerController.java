package com.example.jmusicDemo.controllers;

import com.example.jmusicDemo.data_access.CustomerRepository;
import com.example.jmusicDemo.models.Customer;
import com.example.jmusicDemo.models.PopularGenre;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;

@RestController
public class CustomerController {
    CustomerRepository customerRepository = new CustomerRepository();

    // Setup endpoints with @RequestMappings, extract id with @PathVariable
    @RequestMapping(value = "/api/customers", method = RequestMethod.GET)
    public ArrayList<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @RequestMapping(value = "/api/customers/find/{id}", method = RequestMethod.GET)
    public Customer getSpecificCustomer(@PathVariable String id) {
        return customerRepository.getSpecificCustomer(id);
    }

    @RequestMapping(value = "/api/customers/add", method = RequestMethod.POST)
    public Boolean addCustomer(@RequestBody Customer customer) {
        return customerRepository.addCustomer(customer);
    }

    @RequestMapping(value = "/api/customers/country", method = RequestMethod.GET)
    public LinkedHashMap<String, Integer> getCustomersByCountry() {
        return customerRepository.getCustomersByCountry();
    }

    @RequestMapping(value = "/api/customers/update", method = RequestMethod.PUT)
    public Boolean updateCustomer(@RequestBody Customer customer) {
        return customerRepository.updateCustomer(customer);
    }

    @RequestMapping(value = "/api/customers/invoice/total", method = RequestMethod.GET)
    public LinkedHashMap<String, Double> getHighestSpenders() {
        return customerRepository.getHighestSpenders();
    }

    @RequestMapping(value = "/api/customers/{id}/favorite/genre", method = RequestMethod.GET)
    public ArrayList<PopularGenre> getMostPopularGenre(@PathVariable String id) {
        return customerRepository.getMostPopularGenre(id);
    }
}
