package com.explore.customer.translator;

import com.explore.customer.dto.CustomerDTO;
import com.explore.customer.model.Customer;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CustomerTranslator {
    public CustomerDTO translate(Customer customer) {
        if (customer != null) {
            CustomerDTO dto = new CustomerDTO();
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
        Customer customer = new Customer();
        customer.setUuid(UUID.randomUUID().toString());
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setGender(dto.getGender());
        customer.setEmail(dto.getEmail());
        customer.setCreditCard(dto.getCreditCard());
        customer.setCreditCardType(dto.getCreditCardType());
        return customer;
    }

    public Customer populate(CustomerDTO customerDTO, Customer customer) {
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
