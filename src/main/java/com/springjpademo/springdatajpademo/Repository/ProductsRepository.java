package com.springjpademo.springdatajpademo.Repository;

import com.springjpademo.springdatajpademo.Entity.Customer;
import com.springjpademo.springdatajpademo.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {

    public List<Products> findByProductId(int id);

    @Query(
            value = "select * from products",
            nativeQuery = true
    )
    public List<Products> getAllProducts();

}
