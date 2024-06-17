package org.example.finalexam.service;

import org.example.finalexam.dto.request.CustomerRequestDto;
import org.example.finalexam.dto.response.CustomerResponseDto;
import org.example.finalexam.model.Customer;

import java.util.Optional;

public interface CustomerService {
    Optional<CustomerResponseDto> getCustomerByCustomerId(Long customerId);
    Optional<CustomerResponseDto> addCustomer(CustomerRequestDto customerRequestDto);

}
