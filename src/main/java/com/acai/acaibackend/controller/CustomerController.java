package com.acai.acaibackend.controller;

import com.acai.acaibackend.model.Customer;
import com.acai.acaibackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService service) {
        this.customerService = service;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping
    public void registerCustomer(@RequestBody Customer newCustomer) {

        customerService.setCustomer(newCustomer);
    }

    @DeleteMapping(path = "{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long id) {
        customerService.deleteCustomer(id);
    }

    @PutMapping(path = "{customerId}")
    public void updateCustomer(
            @PathVariable("customerId") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        customerService.updateCustomerById(id, name, email);
    }
}
