package com.example.serviceorder.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Order {
    private String idOrder;
    private String date;
    private Customer customerId;
    private List<Product> products;
}
