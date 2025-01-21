package com.example.serviceorder.adapters.rest.mapper;

import com.example.serviceorder.adapters.rest.model.CustomerRequest;
import com.example.serviceorder.adapters.rest.model.OrderRequest;
import com.example.serviceorder.adapters.rest.model.OrderResponse;
import com.example.serviceorder.adapters.rest.model.ProductRequest;
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
public class OrderRestMapperImpl implements OrderRestMapper {

    @Override
    public Order toOrder(OrderRequest orderRequest) {
        if ( orderRequest == null ) {
            return null;
        }

        String idOrder = null;
        String date = null;
        Customer customerId = null;
        List<Product> products = null;

        idOrder = orderRequest.getIdOrder();
        date = orderRequest.getDate();
        customerId = customerRequestToCustomer( orderRequest.getCustomerId() );
        products = productRequestListToProductList( orderRequest.getProducts() );

        Order order = new Order( idOrder, date, customerId, products );

        return order;
    }

    @Override
    public OrderResponse toOrderResponse(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderResponse orderResponse = new OrderResponse();

        orderResponse.setIdOrder( order.getIdOrder() );
        orderResponse.setDate( order.getDate() );
        orderResponse.setCustomerId( customerToCustomerRequest( order.getCustomerId() ) );
        orderResponse.setProducts( productListToProductRequestList( order.getProducts() ) );

        return orderResponse;
    }

    protected Customer customerRequestToCustomer(CustomerRequest customerRequest) {
        if ( customerRequest == null ) {
            return null;
        }

        String name = null;
        String address = null;
        String phone = null;

        name = customerRequest.getName();
        address = customerRequest.getAddress();
        phone = customerRequest.getPhone();

        Customer customer = new Customer( name, address, phone );

        return customer;
    }

    protected Product productRequestToProduct(ProductRequest productRequest) {
        if ( productRequest == null ) {
            return null;
        }

        String productId = null;
        Integer amount = null;

        productId = productRequest.getProductId();
        amount = productRequest.getAmount();

        Product product = new Product( productId, amount );

        return product;
    }

    protected List<Product> productRequestListToProductList(List<ProductRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<Product> list1 = new ArrayList<Product>( list.size() );
        for ( ProductRequest productRequest : list ) {
            list1.add( productRequestToProduct( productRequest ) );
        }

        return list1;
    }

    protected CustomerRequest customerToCustomerRequest(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerRequest customerRequest = new CustomerRequest();

        customerRequest.setName( customer.getName() );
        customerRequest.setAddress( customer.getAddress() );
        customerRequest.setPhone( customer.getPhone() );

        return customerRequest;
    }

    protected ProductRequest productToProductRequest(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductRequest productRequest = new ProductRequest();

        productRequest.setProductId( product.getProductId() );
        productRequest.setAmount( product.getAmount() );

        return productRequest;
    }

    protected List<ProductRequest> productListToProductRequestList(List<Product> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductRequest> list1 = new ArrayList<ProductRequest>( list.size() );
        for ( Product product : list ) {
            list1.add( productToProductRequest( product ) );
        }

        return list1;
    }
}
