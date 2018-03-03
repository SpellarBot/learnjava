package com.rightkarma.learnspring.repository;

import com.rightkarma.learnspring.model.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("customerRepository")
public class HibernateCustomerRepositoryImpl implements CustomerRepository {

    @Value("${dbUsername}")
    private String user;

    @Override
    public List<Customer> findAll() {
        System.out.println("User value :" +user);
        List<Customer> customers
                = new ArrayList<>();
        Customer customer = new Customer();
        customer.setFirsname("Tom");
        customer.setLastname("Dick");
        customers.add(customer);
        return customers;
    }
}
