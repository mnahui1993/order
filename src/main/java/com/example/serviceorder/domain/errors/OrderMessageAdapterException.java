package com.example.serviceorder.domain.errors;

public class OrderMessageAdapterException extends  RuntimeException{
    public OrderMessageAdapterException(String message, Throwable cause) {
        super(message, cause);
    }
}
