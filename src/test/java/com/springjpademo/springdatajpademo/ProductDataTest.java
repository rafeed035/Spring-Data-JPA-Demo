package com.springjpademo.springdatajpademo;

import com.springjpademo.springdatajpademo.Entity.Products;
import com.springjpademo.springdatajpademo.Repository.ProductsRepository;
import lombok.Builder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

@SpringBootTest
public class ProductDataTest {

    @Autowired
    private ProductsRepository productsRepository;

    @Test
    public void addProducts(){
        Products product1 = Products.builder()
                .productName("Foam Dinner Plate")
                .quantityInStock(70)
                .unitPrice((float) 1.2)
                .build();

        productsRepository.save(product1);

        Products product2 = Products.builder()
                .productName("Pork - Bacon,back Peameal")
                .quantityInStock(49)
                .unitPrice((float) 4.6)
                .build();
        productsRepository.save(product2);
    }

    @Test
    public void getProductsById(){
        List<Products>productsList = productsRepository.findByProductId(1);
        System.out.println(productsList);
    }

}
