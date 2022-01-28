package com.mycompany.service;

import com.mycompany.exception.ResourceNotFoundException;
import com.mycompany.model.Book;
import com.mycompany.model.Store;
import com.mycompany.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    @Autowired
    StoreRepository repository;


    public List<Store> findAll(){
        return repository.findAll();
    }

    public Store findById(Integer id) throws ResourceNotFoundException {
        Store store  = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Contact not found:"+ id)
        );
        return store;
    }

    public void save(Store store){
        int i=1;
        while(true){
            if(repository.findById(i).isPresent()){
                i++;
            }else break;
        }
        store.setId(i);
        repository.save(store);
    }

    public void deleteById(Integer id) throws ResourceNotFoundException {
        Store store  = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Contact not found:"+ id)
        );
        repository.delete(store);
    }



    public void update(Integer id, Store updateStore)throws ResourceNotFoundException{
        Store store  = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Contact not found:"+ id)
        );
        if(updateStore.getName()!=null){
            store.setName(updateStore.getName());
        }
        if(updateStore.getCommission()!=null){
            store.setCommission(updateStore.getCommission());
        }

        if(updateStore.getDistrict()!=null){
            store.setDistrict(updateStore.getDistrict());
        }
        repository.save(store);
    }

    public void fullUpdate(Integer id, Store updateStore)throws ResourceNotFoundException{
        Store store  = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Contact not found:"+ id)
        );

       store.setName(updateStore.getName());
       store.setDistrict(updateStore.getDistrict());
       store.setCommission(updateStore.getCommission());

        repository.save(store);
    }






}
