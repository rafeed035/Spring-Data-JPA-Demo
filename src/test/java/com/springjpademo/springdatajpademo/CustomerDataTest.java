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
        Customer customer1 = Customer.builder()
                .firstName("Shahed")
                .lastName("Rafeed")
                .birthDate("1997-10-20")
                .phone("01725344591")
                .address("TTE More Fulbari")
                .city("Fulbari")
                .state("Dinajpur")
                .points(2273)
                .build();

        customerRepository.save(customer1);

        Customer customer2 = Customer.builder()
                .firstName("Jannatul")
                .lastName("Ferdous")
                .birthDate("1996-10-30")
                .phone("01751464770")
                .address("Thikadarpara")
                .city("Rangpur")
                .state("Rangpur")
                .points(2573)
                .build();

        customerRepository.save(customer2);

        Customer customer3 = Customer.builder()
                .firstName("Ahsan")
                .lastName("SHakil")
                .birthDate("1997-04-25")
                .phone("01710112233")
                .address("Jatrabari")
                .city("Dhaka")
                .state("Dhaka")
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

    @Test
    public void updateCustomerLastNameByBirthDate(){
        customerRepository.updateCustomerLastNameByBirthDate("Whitemore", "1996-04-25");
    }
}
