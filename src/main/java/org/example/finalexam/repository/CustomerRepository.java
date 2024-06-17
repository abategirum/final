package org.example.finalexam.repository;

import org.example.finalexam.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> getCustomerByCustomerId(Long customerId);
}
