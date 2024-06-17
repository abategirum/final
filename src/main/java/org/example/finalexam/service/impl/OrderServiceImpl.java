package org.example.finalexam.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.finalexam.dto.request.OrderRequestDto;
import org.example.finalexam.dto.response.OrderResponseDto;
import org.example.finalexam.model.Order;
import org.example.finalexam.repository.OrderRepository;
import org.example.finalexam.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;


    @Override
    public Optional<List<OrderResponseDto>> addAllOrder(List<OrderRequestDto> orderRequestDtos) {
        List<Order> orderList = modelMapper.map(orderRequestDtos, new TypeToken<List<Order>>(){} .getType());

        List<Order> savedOrderList = orderRepository.saveAll(orderList);

        List<OrderResponseDto> orderResponseDtos = modelMapper.map(savedOrderList, new TypeToken<List<OrderResponseDto>>(){}.getType());

        return Optional.of(orderResponseDtos);

    }
}
