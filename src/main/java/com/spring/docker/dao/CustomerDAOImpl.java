package com.spring.docker.dao;

import com.spring.docker.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Slf4j
public class CustomerDAOImpl implements CustomerDAO{

	@Autowired
    SessionFactory factory;
	

	public List<Customer> getAll() {
		return factory.getCurrentSession().
				createCriteria(Customer.class).list();
	}


	public Customer save(Customer customer) {
		if(customer.getFirstName() == null)
			throw new RuntimeException("Exception occurred during save..");
		factory.getCurrentSession().save(customer);
		return customer;
	}


	public Customer findOne(Integer id) {
		return
				factory.getCurrentSession()
						.get(Customer.class, id);
	}

	@Override
	public void delete(Customer customer) {
		factory.getCurrentSession().delete(customer);
	}
}
