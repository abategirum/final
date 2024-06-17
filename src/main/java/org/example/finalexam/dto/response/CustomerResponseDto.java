package org.example.finalexam.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.finalexam.model.Order;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponseDto {
    private String customerName;
    private List<Order> orders;
}
