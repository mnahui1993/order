package com.example.serviceorder.adapters.repository.cosmos.mapper;

import com.example.serviceorder.adapters.repository.cosmos.model.CustomerCosmosEntity;
import com.example.serviceorder.adapters.repository.cosmos.model.CustomerCosmosEntity.CustomerCosmosEntityBuilder;
import com.example.serviceorder.adapters.repository.cosmos.model.OrdersCosmosEntity;
import com.example.serviceorder.adapters.repository.cosmos.model.OrdersCosmosEntity.OrdersCosmosEntityBuilder;
import com.example.serviceorder.adapters.repository.cosmos.model.ProductCosmosEntity;
import com.example.serviceorder.adapters.repository.cosmos.model.ProductCosmosEntity.ProductCosmosEntityBuilder;
import com.example.serviceorder.domain.model.Customer;
import com.example.serviceorder.domain.model.Order;
import com.example.serviceorder.domain.model.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-17T02:06:34-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class OrderCosmosMapperImpl implements OrderCosmosMapper {

    @Override
    public OrdersCosmosEntity toOrdersCosmosEntity(Order order) {
        if ( order == null ) {
            return null;
        }

        OrdersCosmosEntityBuilder ordersCosmosEntity = OrdersCosmosEntity.builder();

        ordersCosmosEntity.idOrder( order.getIdOrder() );
        ordersCosmosEntity.date( order.getDate() );
        ordersCosmosEntity.customerId( customerToCustomerCosmosEntity( order.getCustomerId() ) );
        ordersCosmosEntity.products( productListToProductCosmosEntityList( order.getProducts() ) );

        return ordersCosmosEntity.build();
    }

    @Override
    public Order toOrder(OrdersCosmosEntity ordersCosmosEntity) {
        if ( ordersCosmosEntity == null ) {
            return null;
        }

        String idOrder = null;
        String date = null;
        Customer customerId = null;
        List<Product> products = null;

        idOrder = ordersCosmosEntity.getIdOrder();
        date = ordersCosmosEntity.getDate();
        customerId = customerCosmosEntityToCustomer( ordersCosmosEntity.getCustomerId() );
        products = productCosmosEntityListToProductList( ordersCosmosEntity.getProducts() );

        Order order = new Order( idOrder, date, customerId, products );

        return order;
    }

    protected CustomerCosmosEntity customerToCustomerCosmosEntity(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerCosmosEntityBuilder customerCosmosEntity = CustomerCosmosEntity.builder();

        customerCosmosEntity.name( customer.getName() );
        customerCosmosEntity.address( customer.getAddress() );
        customerCosmosEntity.phone( customer.getPhone() );

        return customerCosmosEntity.build();
    }

    protected ProductCosmosEntity productToProductCosmosEntity(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductCosmosEntityBuilder productCosmosEntity = ProductCosmosEntity.builder();

        productCosmosEntity.productId( product.getProductId() );
        productCosmosEntity.amount( product.getAmount() );

        return productCosmosEntity.build();
    }

    protected List<ProductCosmosEntity> productListToProductCosmosEntityList(List<Product> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductCosmosEntity> list1 = new ArrayList<ProductCosmosEntity>( list.size() );
        for ( Product product : list ) {
            list1.add( productToProductCosmosEntity( product ) );
        }

        return list1;
    }

    protected Customer customerCosmosEntityToCustomer(CustomerCosmosEntity customerCosmosEntity) {
        if ( customerCosmosEntity == null ) {
            return null;
        }

        String name = null;
        String address = null;
        String phone = null;

        name = customerCosmosEntity.getName();
        address = customerCosmosEntity.getAddress();
        phone = customerCosmosEntity.getPhone();

        Customer customer = new Customer( name, address, phone );

        return customer;
    }

    protected Product productCosmosEntityToProduct(ProductCosmosEntity productCosmosEntity) {
        if ( productCosmosEntity == null ) {
            return null;
        }

        String productId = null;
        Integer amount = null;

        productId = productCosmosEntity.getProductId();
        amount = productCosmosEntity.getAmount();

        Product product = new Product( productId, amount );

        return product;
    }

    protected List<Product> productCosmosEntityListToProductList(List<ProductCosmosEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Product> list1 = new ArrayList<Product>( list.size() );
        for ( ProductCosmosEntity productCosmosEntity : list ) {
            list1.add( productCosmosEntityToProduct( productCosmosEntity ) );
        }

        return list1;
    }
}
