package org.example.finalexam.controller;


import lombok.RequiredArgsConstructor;
import org.example.finalexam.dto.request.CustomerRequestDto;
import org.example.finalexam.dto.response.CustomerResponseDto;
import org.example.finalexam.exception.customer.CustomerNotFoundException;
import org.example.finalexam.repository.CustomerRepository;
import org.example.finalexam.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerRepository customerRepository;



    @PostMapping
    public ResponseEntity<CustomerResponseDto> addCustomer(@RequestBody CustomerRequestDto customerRequestDto){

        Optional<CustomerResponseDto> responseDtoOptional = customerService.addCustomer(customerRequestDto);
        return responseDtoOptional.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponseDto> getCustomer(@PathVariable Long customerId){
        Optional<CustomerResponseDto> responseDto = customerService.getCustomerByCustomerId(customerId);
        return responseDto.map(ResponseEntity::ok)
                .orElseThrow(() -> new CustomerNotFoundException(customerId + "not found"));
    }
}
