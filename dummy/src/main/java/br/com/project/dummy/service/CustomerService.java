package br.com.project.dummy.service;

import br.com.project.dummy.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer getByCustomerId(Long id);

    Customer create(Customer customerRequest);

    Customer update(Long id, Customer customerRequest);

    void delete(Long id);
}
