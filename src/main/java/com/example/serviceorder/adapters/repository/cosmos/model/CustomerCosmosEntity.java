package com.example.serviceorder.adapters.repository.cosmos.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerCosmosEntity {
    private String name;
    private String address;
    private String phone;
}
