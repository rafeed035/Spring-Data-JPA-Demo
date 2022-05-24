package com.springjpademo.springdatajpademo;

import com.springjpademo.springdatajpademo.Entity.Customer;
import com.springjpademo.springdatajpademo.Repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CustomerDataTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void addCustomer(){
//        Customer customer = Customer.builder()
//                .firstName("Babara")
//                .lastName("MacCaffrey")
//                .birthDate("1986-03-28")
//                .phone("781-932-9754")
//                .address("0 Sage Terrace")
//                .city("Waltham")
//                .state("MA")
//                .points(2273)
//                .build();
//
//        customerRepository.save(customer);

        Customer customer2 = Customer.builder()
                .firstName("Ines")
                .lastName("Brushfield")
                .birthDate("1986-04-25")
                .phone("781-900-9854")
                .address("0 Sage Trail")
                .city("Waltham")
                .state("MA")
                .points(2573)
                .build();

        customerRepository.save(customer2);

        Customer customer3 = Customer.builder()
                .firstName("Freddi")
                .lastName("Green")
                .birthDate("1996-04-25")
                .phone("791-700-9854")
                .address("10 New Trail")
                .city("Waltham")
                .state("MA")
                .points(2503)
                .build();

        customerRepository.save(customer3);

    }

    @Test
    public void getCustomerByFirstName(){
        List<Customer> customerList = customerRepository.findByFirstName("Babara");
        System.out.println(customerList);
    }

    @Test
    public void getCustomerByCity(){
        Customer customer = customerRepository.getCustomerByCity("Waltham");
        System.out.println(customer);
    }

    @Test
    public void getCustomerFirstNameByCity(){
        String customerFirstName = customerRepository.getCustomerFirstNameByCity("Waltham");
        System.out.println(customerFirstName);
    }

    @Test
    public void getCustomerFirstNameByCityNative(){
        String customer = customerRepository.getCustomerFirstNameByCityNative("Waltham");
        System.out.println(customer);
    }

    @Test
    public void getCustomerFirstNameByCityNativeNamedParam(){
        String customer = customerRepository.getCustomerFirstNameByCityNativeNameParam("Waltham");
        System.out.println(customer);
    }

    @Test
    public void getCustomersByCityAndPoints(){
        List<Customer> customerList = customerRepository.getCustomerByCityAndPoints("Waltham", 2500);
        System.out.println(customerList);
    }
}
