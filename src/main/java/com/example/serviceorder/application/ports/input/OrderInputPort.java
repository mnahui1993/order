package com.example.serviceorder.application.ports.input;

import com.example.serviceorder.domain.model.Order;
import reactor.core.publisher.Mono;

public interface OrderInputPort {

    Mono<Void> save(Order order);


}
