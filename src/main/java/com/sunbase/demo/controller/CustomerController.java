package com.sunbase.demo.controller;

import com.sunbase.demo.models.Customer;
import com.sunbase.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping("/list")
    public List<Customer> getCustomerList() {
        return customerService.getCustomerList();
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity<String> deleteCustomer(@PathVariable UUID uuid) {
        return customerService.deleteCustomer(uuid);
    }

    @PutMapping("/update/{uuid}")
    public ResponseEntity<String> updateCustomer(@PathVariable UUID uuid, @RequestBody Customer customer) {
        return customerService.updateCustomer(uuid, customer);
    }
}
