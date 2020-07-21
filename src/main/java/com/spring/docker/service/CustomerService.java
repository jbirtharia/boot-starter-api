package com.spring.docker.service;

import com.spring.docker.dao.CustomerDAO;
import com.spring.docker.entity.Customer;
import com.spring.docker.exception.CustomerNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerService {

	@Autowired
	CustomerDAO dao;


	@Transactional
	public List<Customer> getCustomers() {
		return
				dao.getAll().stream()
						.sorted(Comparator.comparingInt(Customer::getId))
						.collect(Collectors.toList());
	}


	@Transactional
	public Customer saveCustomer(Customer customer) {
		return dao.save(customer);
	}


	@Transactional
	public Customer getCustomer(Integer id){
		return dao.findOne(id);
	}


	@Transactional(rollbackFor = CustomerNotFoundException.class)
	public void removeCustomer(Integer id) {
		Customer oldCustomer = dao.findOne(id);
		if(oldCustomer == null)
			throw new CustomerNotFoundException("Id "+id);
		dao.delete(oldCustomer);
	}
}
