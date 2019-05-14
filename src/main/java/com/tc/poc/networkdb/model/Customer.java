package com.tc.poc.networkdb.model;

import javax.persistence.Table;
import javax.persistence.Column;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@EntityScan
@Entity

@Table(name = "CUSTOMER") 
public class Customer {
    
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="Id", unique=true, updatable=true, nullable=false)
	private Long Id;

	@Column(name="name", unique=true, updatable=true, nullable=false)
	private String name;
	
	public Customer() {
	}

	public Customer(String name) {
		this.name = name;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long Id) {
		this.Id = Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                '}';
	}
	
	
}
