package com.springjpademo.springdatajpademo;

import com.springjpademo.springdatajpademo.Entity.Customer;
import com.springjpademo.springdatajpademo.Entity.Products;
import com.springjpademo.springdatajpademo.Repository.CustomerRepository;
import com.springjpademo.springdatajpademo.Repository.ProductsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductDataTest {

    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void addProducts(){
        Products product1 = Products.builder()
                .productName("iPhone")
                .unitPrice((float) 100000.0)
                .build();

        productsRepository.save(product1);

        Customer customer1 = customerRepository.getCustomerByCustomerId(1);
        Products product2 = Products.builder()
                .productName("Macbook Pro 16 inch")
                .unitPrice((float) 248000.0)
                .customer(customer1)
                .build();
        productsRepository.save(product2);

        Customer customer2 = customerRepository.getCustomerByCustomerId(3);
        Products product3 = Products.builder()
                .productName("Mac mini m1")
                .unitPrice((float) 114000.0)
                .customer(customer2)
                .build();
        productsRepository.save(product3);
    }

    @Test
    public void getProductsById(){
        Products products = productsRepository.findByProductId(1);
        System.out.println(products);
    }

    @Test
    public void getAllProducts(){
        List<Products> products = productsRepository.getAllProducts();
        System.out.println(products);
    }

}
