package com.spring.docker.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.spring.docker.entity.Customer;
import com.spring.docker.exception.CustomerNotFoundException;
import com.spring.docker.service.CustomerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.util.List;

@RestController
/*Versioning the API*/
@RequestMapping("/v1")
@Api(value = "Customer", description = "V1 Rest API", tags = {"Customer V1"})
public class MainControllerV1 {
	
	@Autowired
	CustomerService customerService;


    @GetMapping("/customers")
	public List<Customer> showCustomers() {
        return customerService.getCustomers();
	}



	@GetMapping("/customers/{id}")
	public EntityModel<Customer> getCustomer(@PathVariable Integer id){
    	Customer customer = customerService.getCustomer(id);
    	if(customer==null)
    		throw new CustomerNotFoundException("Id "+id);

    	/*To create link of All customers API in get Customer API*/
		return EntityModel.of(customer,
				linkTo(methodOn(MainControllerV1.class).getCustomer(id)).withSelfRel(),
				linkTo(methodOn(MainControllerV1.class).showCustomers()).withRel("customers")
		);
	}
	

	@PostMapping("/customers")
	public ResponseEntity<Object> insertCustomer(@Valid @RequestBody Customer customer) {

    	Customer newCustomer = customerService.saveCustomer(customer);

		return ResponseEntity.created(
				ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newCustomer.getId()).toUri()
		).build();
	}

	@DeleteMapping("customers/{id}")
	public void deleteCustomer(@PathVariable Integer id){
    	customerService.removeCustomer(id);
	}

}
