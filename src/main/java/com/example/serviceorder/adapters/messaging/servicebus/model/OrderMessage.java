package com.example.serviceorder.adapters.messaging.servicebus.model;

import com.example.serviceorder.domain.model.Customer;
import com.example.serviceorder.domain.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class OrderMessage {
    private String idOrder;
    private String date;
    private CustomerMessage customerId;
    private List<ProductMessage> products;
}
