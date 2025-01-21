package com.example.serviceorder.domain.errors;

public class OrderServiceException extends  RuntimeException{
    public OrderServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
