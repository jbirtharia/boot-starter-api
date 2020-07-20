package com.spring.docker.service;

import com.spring.docker.dao.CustomerDAO;
import com.spring.docker.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Comparator;
import java.util.List;

@Service
@Slf4j
public class CustomerService {

	@Autowired
	CustomerDAO dao;

	//@Autowired
	//List<Customer> customers;


	@Transactional
	public List<Customer> getCustomers() {

		//return customers;
		return dao.getAll();
	}

	@Transactional
	public Customer saveCustomer(Customer customer) {
		//customer.setId(this.generateNewId());
		//customers.add(customer);
		//return customer;
		return dao.save(customer);
	}

	/*private Integer generateNewId(){
		return
				customers.stream().
						max(Comparator.comparingInt(Customer::getId))
						.orElse(null).getId()+1;
	}*/
}
