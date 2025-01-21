package com.example.serviceorder.adapters.rest.model;

import com.example.serviceorder.domain.model.Customer;
import com.example.serviceorder.domain.model.Product;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequest {
    @NotEmpty(message = "id order not empty")
    private String idOrder;
    private String date;
    private CustomerRequest customerId;
    @NotEmpty(message = "product not empty")
    private List<ProductRequest> products;
}
