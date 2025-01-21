package com.example.serviceorder.adapters.messaging.servicebus.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ProductMessage {
    private String productId;
    private Integer amount;
}
