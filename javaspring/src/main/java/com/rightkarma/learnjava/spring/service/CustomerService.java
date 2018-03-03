package com.rightkarma.learnjava.spring.service;

import com.rightkarma.learnjava.spring.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
}
