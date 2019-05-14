package com.tc.poc.networkdb.runner;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tc.poc.networkdb.model.Customer;
import com.tc.poc.networkdb.repository.CustomerRepository;

@Component
public class CustomerCommandLineRunner implements CommandLineRunner {
	
    @Autowired
	private final CustomerRepository repository=null;

	@Override
	public void run(String... args) throws Exception {
		Stream.of("Kentucky Brunch Brand Stout", "Good Morning", "Very Hazy", "King Julius",
                "Budweiser", "Coors Light", "PBR").forEach(name ->
                repository.save(new Customer(name))
        );
		repository.findAll().forEach(System.out::println);
	}

}
