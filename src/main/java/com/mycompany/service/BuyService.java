package com.mycompany.service;

import com.mycompany.exception.ResourceNotFoundException;
import com.mycompany.model.Buy;
import com.mycompany.model.Store;
import com.mycompany.repository.BuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyService {

    @Autowired
    BuyRepository repository;

    public List<Buy> findAll(){
        return repository.findAll();
    }

    public Buy findById(Integer id) throws ResourceNotFoundException {
        Buy buy = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Contact not found:"+ id)
        );
        return buy;
    }

    public void save(Buy buy){
        int i=1;
        while(true){
            if(repository.findById(i).isPresent()){
                i++;
            }else break;
        }
        buy.setId(i);
        repository.save(buy);
    }

    public void deleteById(Integer id) throws ResourceNotFoundException {
        Buy buy = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Contact not found:"+ id)
        );
        repository.delete(buy);
    }



    public void update(Integer id, Buy updateBuy)throws ResourceNotFoundException{
        Buy buy = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Contact not found:"+ id)
        );
        if(updateBuy.getBook()!=null){
            buy.setBook(updateBuy.getBook());
        }
        if(updateBuy.getCount()!=null){
            buy.setCount(updateBuy.getCount());
        }
        if(updateBuy.getCustomer()!=null){
            buy.setCustomer(updateBuy.getCustomer());
        }
        if(updateBuy.getDate()!=null){
            buy.setDate(updateBuy.getDate());
        }
        if(updateBuy.getStore()!=null){
            buy.setStore(updateBuy.getStore());
        }
        if(updateBuy.getTotal()!=null){
            buy.setTotal(updateBuy.getTotal());
        }

        repository.save(buy);
    }

    public void fullUpdate(Integer id, Buy updateBuy)throws ResourceNotFoundException{
        Buy buy = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Contact not found:"+ id)
        );

       buy.setBook(updateBuy.getBook());
       buy.setCount(updateBuy.getCount());
       buy.setCustomer(updateBuy.getCustomer());
       buy.setDate(updateBuy.getDate());
       buy.setStore(updateBuy.getStore());
       buy.setTotal(updateBuy.getTotal());

        repository.save(buy);
    }







}
