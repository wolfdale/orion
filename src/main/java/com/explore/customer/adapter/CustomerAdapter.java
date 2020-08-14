package com.explore.customer.adapter;

import com.explore.customer.dto.CustomerDTO;
import com.explore.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CustomerAdapter {
    @Autowired
    CustomerDTO dto;

    @Autowired
    Customer consumer;

    public CustomerDTO translate(Customer customer) {
        if (customer != null) {
            dto.setUuid(customer.getUuid());
            dto.setFirstName(customer.getFirstName());
            dto.setLastName(customer.getLastName());
            dto.setCreditCard(customer.getFirstName());
            dto.setCreditCardType(customer.getCreditCardType());
            dto.setEmail(customer.getCreditCardType());
            dto.setGender(customer.getGender());
            return dto;
        } else {
            return null;
        }
    }

    public Customer translate(CustomerDTO dto) {
        consumer.setUuid(UUID.randomUUID().toString());
        consumer.setFirstName(dto.getFirstName());
        consumer.setLastName(dto.getLastName());
        consumer.setGender(dto.getGender());
        consumer.setEmail(dto.getEmail());
        consumer.setCreditCard(dto.getCreditCard());
        consumer.setCreditCardType(dto.getCreditCardType());
        return consumer;
    }

    public Customer adaptToEntity(CustomerDTO customerDTO, Customer customer) {
        if (customerDTO.getEmail() != null) {
            customer.setEmail(customerDTO.getEmail());
        }

        if (customerDTO.getCreditCard() != null) {
            customer.setCreditCard(customerDTO.getCreditCard());
        }

        if (customerDTO.getCreditCardType() != null) {
            customer.setCreditCardType(customerDTO.getCreditCardType());
        }

        if (customerDTO.getFirstName() != null) {
            customer.setFirstName(customerDTO.getFirstName());
        }

        if (customerDTO.getLastName() != null) {
            customer.setLastName(customerDTO.getLastName());
        }

        if (customerDTO.getGender() != null) {
            customer.setGender(customerDTO.getGender());
        }

        customer.setUuid(customer.getUuid());
        return customer;
    }
}
