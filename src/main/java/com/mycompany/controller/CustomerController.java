package com.mycompany.controller;

import com.mycompany.exception.ResourceNotFoundException;
import com.mycompany.model.Customer;
import com.mycompany.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class CustomerController {

    @Autowired
    CustomerRepository repository;

    @GetMapping("/customer")
    public List<Customer> getAllCustomer(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> addCustomer(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        Customer customer  = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Contact not found:"+ id)
        );

        return ResponseEntity.ok().body(customer);

    }
    @PostMapping("/create")
    public Customer createCustomer(@RequestBody Customer customer){
        return repository.save(customer);
    }

    @DeleteMapping("/{id}")
    public HashMap<String, Boolean> deleteCustomer(@PathVariable(value = "id") Integer id)throws ResourceNotFoundException{
        Customer customer  = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Contact not found:"+ id)
        );

        repository.delete(customer);

        HashMap<String,Boolean> responce=new HashMap<>();
        responce.put("Deleted", true);
        return responce;

    }


}
