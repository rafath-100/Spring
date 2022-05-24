package com.rafath.CRM.service;

import com.rafath.CRM.entity.Customer;

import java.util.List;

public interface CustomerService {
    void saveCustomer(Customer theCustomer);

    List<Customer> getCustomers();

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);
}