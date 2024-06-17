package org.example.finalexam.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.finalexam.model.Customer;
import org.example.finalexam.model.Product;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {
    private LocalDate orderDate;
    private Customer customer;
    private List<Product> products;
}
