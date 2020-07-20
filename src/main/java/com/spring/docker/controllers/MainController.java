package com.spring.docker.controllers;

import com.spring.docker.entity.Customer;
import com.spring.docker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class MainController {
	
	@Autowired
	CustomerService customerService;

    @GetMapping("/getCustomers")
	public List showCustomers() {
        return customerService.getCustomers();
	}
	
	@PostMapping("/insertCustomer")
	public Customer insertCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}

}
