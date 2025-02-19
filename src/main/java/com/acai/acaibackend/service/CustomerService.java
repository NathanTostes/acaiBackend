package com.acai.acaibackend.service;

import com.acai.acaibackend.model.Customer;
import com.acai.acaibackend.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    CustomerService(CustomerRepository repository) {
        this.customerRepository = repository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public void setCustomer(Customer newCustomer) {
        Optional<Customer> optionalCustomer = customerRepository.findCustomerByEmail(newCustomer.getEmail());
        if(optionalCustomer.isPresent()) {
            throw new IllegalStateException("this email is already in use");
        }
        customerRepository.save(newCustomer);
    }

    public void deleteCustomer(Long id) {
        if(!customerRepository.existsById(id)) {
            throw new IllegalStateException("there's no customers with id equals to " + id);
        }
        customerRepository.deleteById(id);
    }

    @Transactional
    public void updateCustomerById(Long id, String newName, String newEmail) {
        Customer customer = customerRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("there's no customers with id equals to " + id));

        if(newName == null || newName.length() <= 0) {
            throw new IllegalStateException("new name is invalid");
        }
        customer.setName(newName);

        if(newEmail == null || newEmail.length() <= 0) {
            throw new IllegalStateException("new email is invalid");
        };

        Optional<Customer> optionalCustomer = customerRepository.findCustomerByEmail(newEmail);
        if(optionalCustomer.isPresent() && !Objects.equals(customer.getEmail(), newEmail)) {
            throw new IllegalStateException("this email is already in use");
        };

        customer.setEmail(newEmail);
    }
}
