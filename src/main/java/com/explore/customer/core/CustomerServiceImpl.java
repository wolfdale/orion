package com.explore.customer.core;

import com.explore.customer.dao.CustomerRepository;
import com.explore.customer.dto.CustomerDTO;
import com.explore.customer.model.Customer;
import com.explore.customer.translator.CustomerTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerServiceImpl {
    @Autowired
    public CustomerRepository customerDAO;

    @Autowired
    public CustomerTranslator customerTranslator;

    public CustomerDTO persistCustomer(CustomerDTO customerDTO) {
        Customer customer = customerTranslator.translate(customerDTO);
        return customerTranslator.translate(customerDAO.save(customer));
    }

    public CustomerDTO getCustomer(String uuid) {
        Optional<Customer> customer = customerDAO.findById(uuid);
        if (customer.isPresent()) {
            return customerTranslator.translate(customer.get());
        } else {
            return null;
        }
    }

    /**
     * Assuming uuid is not null
     *
     * @param uuid - customer ID
     * @return void
     */
    public void deleteCustomer(String uuid) {
        customerDAO.deleteById(uuid);
    }

    public CustomerDTO updateCustomer(CustomerDTO customerDTO, String uuid) {
        Optional<Customer> container = findCustomerById(uuid);
        if (container.isPresent()) {
            Customer customer = container.get();
            customer = customerTranslator.populate(customerDTO, customer);
            return customerTranslator.translate(customerDAO.save(customer));
        } else {
            return null;
        }
    }

    private Optional<Customer> findCustomerById(String uuid) {
        return customerDAO.findById(uuid);
    }

}
