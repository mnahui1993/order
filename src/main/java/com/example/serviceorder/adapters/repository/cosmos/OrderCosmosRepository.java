package com.example.serviceorder.adapters.repository.cosmos;

import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import com.example.serviceorder.adapters.repository.cosmos.model.OrdersCosmosEntity;

public interface OrderCosmosRepository extends ReactiveCosmosRepository<OrdersCosmosEntity, String> {
}
