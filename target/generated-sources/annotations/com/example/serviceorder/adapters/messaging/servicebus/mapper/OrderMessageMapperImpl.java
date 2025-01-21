package com.example.serviceorder.adapters.messaging.servicebus.mapper;

import com.example.serviceorder.adapters.messaging.servicebus.model.CustomerMessage;
import com.example.serviceorder.adapters.messaging.servicebus.model.CustomerMessage.CustomerMessageBuilder;
import com.example.serviceorder.adapters.messaging.servicebus.model.OrderMessage;
import com.example.serviceorder.adapters.messaging.servicebus.model.OrderMessage.OrderMessageBuilder;
import com.example.serviceorder.adapters.messaging.servicebus.model.ProductMessage;
import com.example.serviceorder.adapters.messaging.servicebus.model.ProductMessage.ProductMessageBuilder;
import com.example.serviceorder.domain.model.Customer;
import com.example.serviceorder.domain.model.Order;
import com.example.serviceorder.domain.model.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-20T23:38:07-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class OrderMessageMapperImpl implements OrderMessageMapper {

    @Override
    public OrderMessage toOrderMessage(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderMessageBuilder orderMessage = OrderMessage.builder();

        orderMessage.idOrder( order.getIdOrder() );
        orderMessage.date( order.getDate() );
        orderMessage.customerId( customerToCustomerMessage( order.getCustomerId() ) );
        orderMessage.products( productListToProductMessageList( order.getProducts() ) );

        return orderMessage.build();
    }

    protected CustomerMessage customerToCustomerMessage(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerMessageBuilder customerMessage = CustomerMessage.builder();

        customerMessage.name( customer.getName() );
        customerMessage.address( customer.getAddress() );
        customerMessage.phone( customer.getPhone() );

        return customerMessage.build();
    }

    protected ProductMessage productToProductMessage(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductMessageBuilder productMessage = ProductMessage.builder();

        productMessage.productId( product.getProductId() );
        productMessage.amount( product.getAmount() );

        return productMessage.build();
    }

    protected List<ProductMessage> productListToProductMessageList(List<Product> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductMessage> list1 = new ArrayList<ProductMessage>( list.size() );
        for ( Product product : list ) {
            list1.add( productToProductMessage( product ) );
        }

        return list1;
    }
}
