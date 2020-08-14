package com.explore.customer.controller;

import com.explore.customer.core.CustomerServiceImpl;
import com.explore.customer.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerService {
    @Autowired
    public CustomerServiceImpl customerServiceImpl;

    @PostMapping("customer")
    public ResponseEntity<CustomerDTO> addCustomerDetails(@RequestBody CustomerDTO customer) {
        CustomerDTO persistedConsumer = customerServiceImpl.persistCustomer(customer);
        return ResponseEntity.ok().body(persistedConsumer);
    }

    @GetMapping("customer/{uuid}")
    public ResponseEntity<CustomerDTO> getCustomerDetails(@PathVariable String uuid) {
        CustomerDTO customer = customerServiceImpl.getCustomer(uuid);
        if (customer != null) {
            return ResponseEntity.ok().body(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("customer/{uuid}")
    public ResponseEntity<CustomerDTO> deleteCustomerDetails(@PathVariable String uuid) {
        customerServiceImpl.deleteCustomer(uuid);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("customer/{uuid}")
    public ResponseEntity<CustomerDTO> updateCustomerDetails(@RequestBody CustomerDTO customer,
        @PathVariable String uuid) {
        CustomerDTO updatedCustomerDTO = customerServiceImpl.updateCustomer(customer, uuid);
        if (updatedCustomerDTO != null) {
            return ResponseEntity.accepted().body(updatedCustomerDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
