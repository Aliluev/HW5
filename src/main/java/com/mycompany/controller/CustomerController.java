package com.mycompany.controller;

import com.mycompany.exception.ResourceNotFoundException;
import com.mycompany.model.Customer;
import com.mycompany.repository.CustomerRepository;

import com.mycompany.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController

public class CustomerController {

    @Autowired
    CustomerService service;

    @GetMapping("/customer")
    public List<Customer> getAllCustomer(){
        return service.findAll();
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> addCustomer(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        Customer customer  = service.findById(id);
        return ResponseEntity.ok().body(customer);
    }
    @PostMapping("/customer")
    public void createCustomer(@RequestBody Customer customer){
        service.save(customer);
    }

    @DeleteMapping("/customer/{id}")
    public HashMap<String, Boolean> deleteCustomer(@PathVariable(value = "id") Integer id)throws ResourceNotFoundException{

        service.deleteById(id);
        HashMap<String,Boolean> responce=new HashMap<>();
        responce.put("Deleted", true);
        return responce;

    }

    @PatchMapping("/customer/{id}")
    public HashMap<String, Boolean> updateCustomer(@PathVariable(value = "id") Integer id, @RequestBody Customer customer)throws ResourceNotFoundException{
        service.update(id,customer);
        HashMap<String,Boolean> responce=new HashMap<>();
        responce.put("Update", true);
        return responce;
    }


    @PutMapping("/customer/{id}")
    public HashMap<String, Boolean> fullUpdateCustomer(@PathVariable(value = "id") Integer id, @RequestBody Customer customer)throws ResourceNotFoundException{
        service.fullUpdate(id, customer);
        HashMap<String,Boolean> responce=new HashMap<>();
        responce.put("FullUpdate", true);
        return responce;
    }


}
