package org.example.finalexam.repository;

import org.example.finalexam.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> getProductByProductId(long productId);
}
