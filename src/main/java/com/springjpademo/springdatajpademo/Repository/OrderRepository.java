package com.springjpademo.springdatajpademo.Repository;

import com.springjpademo.springdatajpademo.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {
    public List<Orders> getOrdersByOrderID(int id);
}
