package com.springjpademo.springdatajpademo;

import com.springjpademo.springdatajpademo.Entity.Customer;
import com.springjpademo.springdatajpademo.Entity.Orders;
import com.springjpademo.springdatajpademo.Entity.Products;
import com.springjpademo.springdatajpademo.Repository.CustomerRepository;
import com.springjpademo.springdatajpademo.Repository.OrderRepository;
import com.springjpademo.springdatajpademo.Repository.ProductsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class OrderDataTest {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void addToOrders(){
        Products products = productsRepository.findByProductId(7);
        Customer customer = products.getCustomer();
        System.out.println(customer.getFirstName());

        Orders orders = Orders.builder()
                .orderDate("2022-08-24")
                .customer(customer)
                .products(products)
                .build();

        orderRepository.save(orders);

        Products products2 = productsRepository.findByProductId(6);
        Customer customer2 = products2.getCustomer();

        Orders orders2 = Orders.builder()
                .orderDate("2022-04-24")
                .products(products2)
                .customer(customer2)
                .build();

        orderRepository.save(orders2);
    }

}
