package com.example.serviceorder.adapters.repository.cosmos.model;


import com.azure.spring.data.cosmos.core.mapping.Container;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductCosmosEntity {
    private String productId;
    private Integer amount;
}
