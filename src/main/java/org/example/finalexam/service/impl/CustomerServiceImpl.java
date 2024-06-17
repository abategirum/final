package org.example.finalexam.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.finalexam.dto.request.CustomerRequestDto;
import org.example.finalexam.dto.response.CustomerResponseDto;
import org.example.finalexam.model.Customer;
import org.example.finalexam.repository.CustomerRepository;
import org.example.finalexam.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<CustomerResponseDto> getCustomerByCustomerId(Long customerId) {
        Optional<Customer> customerFound = customerRepository.getCustomerByCustomerId(customerId);
        if(customerFound.isPresent()){
            CustomerResponseDto customerResponseDto = modelMapper.map(customerFound.get(), CustomerResponseDto.class);
            return Optional.of(customerResponseDto);
        }
        return Optional.empty();
    }

    @Override
    public Optional<CustomerResponseDto> addCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = modelMapper.map(customerRequestDto, Customer.class);
        Customer savedCustomer = customerRepository.save(customer);
        CustomerResponseDto customerResponseDto = modelMapper.map(savedCustomer, CustomerResponseDto.class);
        return Optional.of(customerResponseDto);
    }
}
