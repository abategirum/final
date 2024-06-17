package org.example.finalexam.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.finalexam.dto.request.ProductRequestDto;
import org.example.finalexam.dto.response.ProductResponseDto;
import org.example.finalexam.model.Product;
import org.example.finalexam.repository.ProductRepository;
import org.example.finalexam.service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<ProductResponseDto> getProductByProductId(Long productId) {
        Optional<Product>  productFound = productRepository.getProductByProductId(productId);
        if(productFound.isPresent()){
            ProductResponseDto productResponseDto = modelMapper.map(productFound.get(), ProductResponseDto.class);
            return Optional.of(productResponseDto);
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<ProductResponseDto>> addAllProducts(List<ProductRequestDto> requestDtos) {
        List<Product> productList = modelMapper.map(requestDtos, new TypeToken<List<Product>>(){}.getType());

        List<Product> savedProductList = productRepository.saveAll(productList);

        List<ProductResponseDto> productResponseDtos = modelMapper.map(savedProductList, new TypeToken<List<ProductResponseDto>>(){}.getType());

        return Optional.of(productResponseDtos);
    }
}
