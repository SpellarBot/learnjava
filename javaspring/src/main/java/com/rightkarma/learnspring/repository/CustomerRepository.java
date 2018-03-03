package com.rightkarma.learnspring.repository;

import com.rightkarma.learnspring.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
}
