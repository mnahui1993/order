package com.example.serviceorder.adapters.rest.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private String productId;
    private Integer amount;
}
