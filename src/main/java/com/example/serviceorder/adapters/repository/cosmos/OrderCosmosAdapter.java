package com.example.serviceorder.adapters.repository.cosmos;

import com.example.serviceorder.adapters.repository.cosmos.mapper.OrderCosmosMapper;
import com.example.serviceorder.application.ports.output.OrderRepositoryPort;
import com.example.serviceorder.domain.errors.OrderCosmosAdapterException;
import com.example.serviceorder.domain.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderCosmosAdapter implements OrderRepositoryPort {

    private final OrderCosmosRepository orderCosmosRepository;
    private final OrderCosmosMapper orderCosmosMapper;
    @Override
    public Mono<Order> save(Order order) {
        return orderCosmosRepository.save(orderCosmosMapper.toOrdersCosmosEntity(order))
                .map(orderCosmosMapper::toOrder)
                .doOnSuccess(res -> log.info("Pedido con ID: {} guardado en CosmosDB", res.getIdOrder()))
                .doOnError(e -> log.error("Error Al grabar Pedido en  CosmosDB", e))
                .onErrorMap(e -> new OrderCosmosAdapterException("Error al guardar el pedido en el repositorio CosmosDB", e));
    }
}
