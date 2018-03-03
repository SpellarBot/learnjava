package com.rightkarma.learnspring.service;

import com.rightkarma.learnspring.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
}
