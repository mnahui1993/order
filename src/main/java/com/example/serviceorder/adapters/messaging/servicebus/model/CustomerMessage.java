package com.example.serviceorder.adapters.messaging.servicebus.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CustomerMessage {
    private String name;
    private String address;
    private String phone;
}
