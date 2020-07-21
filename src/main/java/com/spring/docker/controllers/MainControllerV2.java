package com.spring.docker.controllers;

import com.spring.docker.entity.Customer;
import com.spring.docker.service.CustomerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
/*Versioning the API*/
@RequestMapping("/v2")
@Api(value = "Customer", description = "V2 Rest API", tags = {"Customer V2"})
public class MainControllerV2 {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> showCustomersV2() {
        return customerService.getCustomers().stream()
                .map(Customer::toUpperCaseLastName)
                .collect(Collectors.toList());
    }
}
