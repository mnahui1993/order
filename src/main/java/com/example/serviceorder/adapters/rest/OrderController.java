package com.example.serviceorder.adapters.rest;

import com.example.serviceorder.adapters.rest.mapper.OrderRestMapper;
import com.example.serviceorder.adapters.rest.model.OrderRequest;
import com.example.serviceorder.adapters.rest.model.OrderResponse;
import com.example.serviceorder.application.ports.input.OrderInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class OrderController {

    private final OrderInputPort orderInputPort;
    private final OrderRestMapper orderRestMapper;




    @PostMapping("/order")
    public Mono<Void> saveOrder(@Valid  @RequestBody  OrderRequest orderRequest){
        return orderInputPort.save(orderRestMapper.toOrder(orderRequest));
                //.map(orderRestMapper::toOrderResponse);


    }
}
