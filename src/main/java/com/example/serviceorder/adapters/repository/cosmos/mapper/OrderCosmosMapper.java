package com.example.serviceorder.adapters.repository.cosmos.mapper;

import com.example.serviceorder.adapters.repository.cosmos.model.OrdersCosmosEntity;
import com.example.serviceorder.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import reactor.core.publisher.Mono;

@Mapper(componentModel = "spring")
public interface OrderCosmosMapper {


    @Mapping(source = "idOrder",target = "idOrder")
    @Mapping(source = "date",target = "date")
    @Mapping(source = "customerId",target = "customerId")
    @Mapping(source = "products",target = "products")
    OrdersCosmosEntity toOrdersCosmosEntity(Order order);
    @Mapping(source = "idOrder",target = "idOrder")
    @Mapping(source = "date",target = "date")
    @Mapping(source = "customerId",target = "customerId")
    @Mapping(source = "products",target = "products")
    Order toOrder(OrdersCosmosEntity ordersCosmosEntity);


}
