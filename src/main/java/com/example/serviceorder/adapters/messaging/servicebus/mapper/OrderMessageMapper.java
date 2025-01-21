package com.example.serviceorder.adapters.messaging.servicebus.mapper;

import com.example.serviceorder.adapters.messaging.servicebus.model.OrderMessage;
import com.example.serviceorder.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMessageMapper {
    @Mapping(source = "idOrder",target = "idOrder")
    @Mapping(source = "date",target = "date")
    @Mapping(source = "customerId",target = "customerId")
    @Mapping(source = "products",target = "products")
    OrderMessage toOrderMessage(Order order);

}
