package com.badboys.ai.flying.service;

import com.badboys.ai.flying.entity.Customer;
import com.badboys.ai.flying.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final EmailService emailService;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, EmailService emailService) {
        this.customerRepository = customerRepository;
        this.emailService = emailService;
    }

    public void registerCustomer(Customer customerDTO) {
        // Create a new Customer entity using the customerDTO data
        Customer customer = new Customer();
        customer.setFullName(customerDTO.getFullName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPassword(customerDTO.getPassword());
        customer.setCreated_at(customerDTO.getCreated_at());

        // Save the customer entity in the database
        customerRepository.save(customer);

        // Send a confirmation email to the customer
        emailService.sendConfirmationEmail(customer.getEmail());
    }
}
