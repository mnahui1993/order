package com.example.serviceorder.adapters.rest.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderResponse {
    private String idOrder;
    private String date;
    private CustomerRequest customerId;
    private List<ProductRequest> products;
}
