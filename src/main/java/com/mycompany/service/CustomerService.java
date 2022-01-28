package com.mycompany.service;

import com.mycompany.exception.ResourceNotFoundException;
import com.mycompany.model.Customer;
import com.mycompany.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    public List<Customer> findAll(){
        return repository.findAll();
    }

    public Customer findById(Integer id) throws ResourceNotFoundException{
        Customer customer  = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Contact not found:"+ id)
        );
        return customer;
    }

    public void save(Customer customer){
        int i=1;
        while(true){
            if(repository.findById(i).isPresent()){
                i++;
            }else break;
        }
        customer.setId(i);
        repository.save(customer);
    }

    public void deleteById(Integer id) throws ResourceNotFoundException {
        Customer customer = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Contact not found:" + id)
        );
        repository.delete(customer);
    }

    public void update(Integer id, Customer updateCustomer)throws ResourceNotFoundException{
        Customer customer = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Contact not found:" + id)
        );
        if(updateCustomer.getSurname()!=null){
            customer.setSurname(updateCustomer.getSurname());
        }

        if(updateCustomer.getDistrict()!=null){
            customer.setDistrict(updateCustomer.getDistrict());
        }

        if(updateCustomer.getDiscount()!=null){
            customer.setDiscount(updateCustomer.getDiscount());
        }
         repository.save(customer);
    }

    public void fullUpdate(Integer id, Customer updateCustomer)throws ResourceNotFoundException{
        Customer customer = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Contact not found:" + id)
        );

        customer.setSurname(updateCustomer.getSurname());
        customer.setDistrict(updateCustomer.getDistrict());
        customer.setDiscount(updateCustomer.getDiscount());

        repository.save(customer);
    }

    public List<String> districtWhereCustomerLive(){
        return repository.districtWhereCustomerLive();
    }

    public List<String> surnameDiscountNizhegorodskiy(){
        return repository.surnameDiscountNizhegorodskiy();
    }


}
