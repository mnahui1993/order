package com.example.serviceorder.application.usercase;

import com.example.serviceorder.application.ports.input.OrderInputPort;
import com.example.serviceorder.application.ports.output.OrderMessagingPort;
import com.example.serviceorder.application.ports.output.OrderRepositoryPort;
import com.example.serviceorder.domain.errors.OrderServiceException;
import com.example.serviceorder.domain.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService implements OrderInputPort {

    private final OrderRepositoryPort orderRepositoryPort;
    private final OrderMessagingPort orderMessagingPort;
    @Override
    public Mono<Void> save(Order order) {

        return orderRepositoryPort.save(order)
                .flatMap(orderMessagingPort::sendOrderConfirmationMessage)
                .onErrorMap(e -> {
                    // Manejo específico de excepciones de adaptación si es necesario
                    // Puede lanzar una excepción más orientada a la lógica de negocio
                    return new OrderServiceException("Error al grabar el pedido", e);
                })
                .doOnError(e -> log.error("Error en la capa de servicio", e));


    }
}
