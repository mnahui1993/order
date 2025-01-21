package com.example.serviceorder.adapters.rest;


import com.example.serviceorder.adapters.rest.model.ErrorResponse;
import com.example.serviceorder.domain.errors.OrderCosmosAdapterException;
import com.example.serviceorder.domain.errors.OrderMessageAdapterException;
import com.example.serviceorder.domain.errors.OrderServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestControllerAdvice
@RequiredArgsConstructor
public class ErrorHandlingController {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({WebExchangeBindException.class})
    public ErrorResponse handlerErrorNotValidException(WebExchangeBindException e){
        String message=e.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(","));

        return ErrorResponse.builder().notification(List.of(ErrorResponse.Notification.builder()
                .code(HttpStatus.BAD_REQUEST.name())
                .message(message)
                .timestamp(LocalDate.now().toString())
                .uuid(UUID.randomUUID().toString())
                .build())).build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({OrderServiceException.class})
    public ErrorResponse handleExceptionNotFound(OrderServiceException e){
        return ErrorResponse.builder().notification(List.of(ErrorResponse.Notification.builder()
                .code(HttpStatus.NOT_FOUND.name())
                .message(e.getMessage())
                .timestamp(LocalDate.now().toString())
                .uuid(UUID.randomUUID().toString())
                .build())).build();
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({OrderCosmosAdapterException.class, OrderMessageAdapterException.class})
    public ErrorResponse handleExceptionInternalServerError(RuntimeException  e){
        return ErrorResponse.builder().notification(List.of(ErrorResponse.Notification.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .message(e.getMessage())
                .timestamp(LocalDate.now().toString())
                .uuid(UUID.randomUUID().toString())
                .build())).build();
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    public ErrorResponse handleGenericException(Exception e){
        return ErrorResponse.builder().notification(List.of(ErrorResponse.Notification.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .message(e.getMessage())
                .timestamp(LocalDate.now().toString())
                .uuid(UUID.randomUUID().toString())
                .build())).build();
    }



}
