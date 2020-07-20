package com.spring.docker;

import com.spring.docker.entity.Customer;
import com.spring.docker.service.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class BootStarterApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootStarterApiApplication.class, args);
	}


	@Bean
	public List<Customer> populateInitialData(CustomerService service){
		service.saveCustomer(new Customer(1,"Ram","Tiwari","ram@gmail.com"));
		service.saveCustomer(new Customer(2,"Pankaj","Jain","pankaj@gmail.com"));
		service.saveCustomer(new Customer(3,"Nand","Kumar","nand@gmail.com"));
		return service.getCustomers();
	}


}
