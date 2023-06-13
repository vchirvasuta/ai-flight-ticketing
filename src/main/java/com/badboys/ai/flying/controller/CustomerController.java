package com.badboys.ai.flying.controller;

import com.badboys.ai.flying.entity.Customer;
import com.badboys.ai.flying.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestParam("fullName") String fullName,
                                         @RequestParam("email") String email,
                                         @RequestParam("password") String password) {
        try {
            Customer customerDTO = new Customer();
            customerDTO.setFullName(fullName);
            customerDTO.setEmail(email);
            customerDTO.setPassword(password);
            customerDTO.setCreated_at(LocalDateTime.now());
            customerService.registerCustomer(customerDTO);
            return ResponseEntity.ok("Customer registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error registering customer: " + e.getMessage());
        }
    }
}
