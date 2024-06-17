package org.example.finalexam.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.finalexam.model.Customer;
import org.example.finalexam.model.Product;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto {
    private LocalDate orderDate;
    private Customer customer;
    private List<Product> products;
}
