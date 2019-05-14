package com.tc.poc.networkdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tc.poc.networkdb.model.Customer;

@RepositoryRestResource
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
