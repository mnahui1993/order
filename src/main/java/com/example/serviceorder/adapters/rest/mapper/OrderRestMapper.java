package com.example.serviceorder.adapters.rest.mapper;

import com.example.serviceorder.adapters.repository.cosmos.model.OrdersCosmosEntity;
import com.example.serviceorder.adapters.rest.model.OrderRequest;
import com.example.serviceorder.adapters.rest.model.OrderResponse;
import com.example.serviceorder.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderRestMapper {

    @Mapping(source = "idOrder",target = "idOrder")
    @Mapping(source = "date",target = "date")
    @Mapping(source = "customerId",target = "customerId")
    @Mapping(source = "products",target = "products")
    Order toOrder(OrderRequest orderRequest);

    @Mapping(source = "idOrder",target = "idOrder")
    @Mapping(source = "date",target = "date")
    @Mapping(source = "customerId",target = "customerId")
    @Mapping(source = "products",target = "products")
    OrderResponse toOrderResponse(Order order);
}
