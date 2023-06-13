package com.badboys.ai.flying.repository;

import com.badboys.ai.flying.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Additional methods specific to Customer entity can be defined here

    Customer findByEmail(String email);
}
