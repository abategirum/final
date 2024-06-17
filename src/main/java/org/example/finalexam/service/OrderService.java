package org.example.finalexam.service;

import org.example.finalexam.dto.request.OrderRequestDto;
import org.example.finalexam.dto.response.OrderResponseDto;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Optional<List<OrderResponseDto>> addAllOrder(List<OrderRequestDto> orderRequestDtos);

}
