package org.example.finalexam.service;

import org.example.finalexam.dto.request.ProductRequestDto;
import org.example.finalexam.dto.response.ProductResponseDto;

import java.util.List;
import java.util.Optional;
public interface ProductService {
    Optional<ProductResponseDto> getProductByProductId(Long productId);
    Optional<List<ProductResponseDto>> addAllProducts(List<ProductRequestDto> productRequestDtos);
}
