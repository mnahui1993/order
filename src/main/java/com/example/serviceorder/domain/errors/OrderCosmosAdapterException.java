package com.example.serviceorder.domain.errors;

public class OrderCosmosAdapterException extends RuntimeException {
    public OrderCosmosAdapterException(String message, Throwable cause) {
        super(message, cause);
    }
}
