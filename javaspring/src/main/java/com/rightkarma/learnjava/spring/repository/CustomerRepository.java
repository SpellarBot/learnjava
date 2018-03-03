package com.rightkarma.learnjava.spring.repository;

import com.rightkarma.learnjava.spring.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
}
