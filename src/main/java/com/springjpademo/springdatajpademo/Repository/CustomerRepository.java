package com.springjpademo.springdatajpademo.Repository;

import com.springjpademo.springdatajpademo.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    //jpa methods
    List<Customer> findByFirstName(String firstName);

    List<Customer>findByFirstNameContaining(String name);

    Customer getCustomerByCustomerId(int id);

    //JPQL --> based on the class that we create not the table of the db
    @Query("select c from Customer c where c.city = ?1")
    Customer getCustomerByCity(String city);

    @Query("select c.firstName from Customer c where c.city = ?1")
    String getCustomerFirstNameByCity(String city);

    //Native query --> using the SQL query directly instead of the JPQL query
    @Query(
            value = "select first_name from customer where city = ?1",
            nativeQuery = true
    )
    String getCustomerFirstNameByCityNative(String city);

    //Native named parameter
    @Query(
            value = "select first_name from customer where city >= :city",
            nativeQuery = true
    )
    String getCustomerFirstNameByCityNativeNameParam(
            @Param("city") String city
    );

    @Query(
            value = "select * from customer where city = :city and points > :points",
            nativeQuery = true
    )
    List<Customer> getCustomerByCityAndPoints(@Param("city") String city, @Param("points") int points);

    @Modifying
    @Transactional
    @Query(
            value = "update customer set last_name = :lastName where birth_date = :birthDate",
            nativeQuery = true
    )
    void updateCustomerLastNameByBirthDate(@Param("lastName") String nameToUpdate, @Param("birthDate") String birthDate);

}
