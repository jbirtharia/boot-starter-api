package com.spring.docker.dao;

import com.spring.docker.entity.Customer;

import java.util.List;

public interface CustomerDAO {

	public List<Customer> getAll();
	
	public Customer save(Customer customer);
}
