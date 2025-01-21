package com.example.serviceorder.application.ports.output;

import com.example.serviceorder.domain.model.Order;
import reactor.core.publisher.Mono;

public interface OrderRepositoryPort {

    Mono<Order> save(Order order);


}
