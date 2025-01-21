package com.example.serviceorder.adapters.repository.cosmos.model;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Container(containerName = "Order")
@Builder
public class OrdersCosmosEntity {
    @Id
    @GeneratedValue
    private String id;
    private String idOrder;
    private String date;
    private CustomerCosmosEntity customerId;
    private List<ProductCosmosEntity> products;
    private String status;
    private List<String> observation;
}
