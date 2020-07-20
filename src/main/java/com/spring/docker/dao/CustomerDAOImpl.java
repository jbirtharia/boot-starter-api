package com.spring.docker.dao;

import com.spring.docker.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class CustomerDAOImpl implements CustomerDAO{

	@Autowired
    SessionFactory factory;
	

	public List<Customer> getAll() {

		return
				(List<Customer>)
						factory.getCurrentSession().
								createCriteria(Customer.class).list()
								.stream().sorted(Comparator.comparingInt(Customer::getId)).
								collect(Collectors.toList());
	}

	public Customer save(Customer customer) {

		if(customer.getFirstName() == null)
			throw new RuntimeException("Exception occurred during save..");
		factory.getCurrentSession().save(customer);
		return customer;
	}
}
