package org.example.finalexam.controller;


import lombok.RequiredArgsConstructor;
import org.example.finalexam.dto.request.OrderRequestDto;
import org.example.finalexam.dto.response.OrderResponseDto;
import org.example.finalexam.repository.OrderRepository;
import org.example.finalexam.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;
    private final OrderService orderService;


    @PostMapping
    public ResponseEntity<List<OrderResponseDto>> addOrders(@RequestBody List<OrderRequestDto> orderRequestDtos){
        Optional<List<OrderResponseDto>> orderResponseDtoOptional = orderService.addAllOrder(orderRequestDtos);

        return orderResponseDtoOptional.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.CONFLICT));

    }



}
