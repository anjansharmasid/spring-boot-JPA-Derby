package com.tc.poc.networkdb.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tc.poc.networkdb.model.Customer;
import com.tc.poc.networkdb.repository.CustomerRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RestController
public class CustomerController {
	
	   @Autowired
	   private CustomerRepository repository;
	   
	   public CustomerController(CustomerRepository repository) {
	        this.repository = repository;
	    }

	   @GetMapping("/customers")
	   
	   public List<Customer> retrieveAllCustomers() {
		   populateAgain();
	   	return repository.findAll();
	   }
	   
	   
	   @GetMapping("/customers/{id}")
	   public Optional<Customer> retrieveAllCustomers(@PathVariable("id") Long id) {
	   	return repository.findById(id);
	   }
	   
	   @GetMapping("/good-customers")
	   public Collection<Customer> goodCustomer() {

	        return repository.findAll().stream()
	                .filter(this::isGreat)
	                .collect(Collectors.toList());
	    }

	    private boolean isGreat(Customer customer) {
	        return !customer.getName().equals("Budweiser") &&
	                !customer.getName().equals("Coors Light") &&
	                !customer.getName().equals("PBR");
	    }
	    
	    @PostMapping("/customer/post")
	    public Optional<Customer> createStudent(@RequestBody Customer customer) {
	    	Customer customerSaved = repository.save(customer);
	    	return repository.findById(customerSaved.getId());
	    }
	    
	    private void populateAgain() {
	    	try {
	    	Stream.of("Kent Brunch", "GoodDay", "Hazy", "Julius",
	                "Budwei", "Coor", "PBRMOR").forEach(name ->
	                repository.saveAndFlush(new Customer(name)));
	    	}
	    	catch(Exception e) {
	    		System.out.println(e.getCause().getMessage());
	    	}
	    }
}
