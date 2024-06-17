package org.example.finalexam.controller;


import lombok.RequiredArgsConstructor;
import org.example.finalexam.dto.request.ProductRequestDto;
import org.example.finalexam.dto.response.ProductResponseDto;
import org.example.finalexam.repository.ProductRepository;
import org.example.finalexam.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor

public class ProductController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<List<ProductResponseDto>> addProducts(List<ProductRequestDto> productRequestDtos){
        Optional<List<ProductResponseDto>> productResponseList = productService.addAllProducts(productRequestDtos);
        return productResponseList.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable Long productId){
        Optional<ProductResponseDto> responseDto = productService.getProductByProductId(productId);
        return responseDto.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
