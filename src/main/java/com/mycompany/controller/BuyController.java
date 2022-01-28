package com.mycompany.controller;

import com.mycompany.exception.ResourceNotFoundException;
import com.mycompany.model.Buy;
import com.mycompany.model.Store;
import com.mycompany.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class BuyController {

    @Autowired
    BuyService service;


    @GetMapping("/buy")
    public List<Buy> getAllBuy(){
        return service.findAll();
    }

    @GetMapping("/buy/{id}")
    public ResponseEntity<Buy> addBuy(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
       Buy buy = service.findById(id);
        return ResponseEntity.ok().body(buy);
    }
    @PostMapping("/buy")
    public void createBuy(@RequestBody Buy buy){
        service.save(buy);
    }

    @DeleteMapping("/buy/{id}")
    public HashMap<String, Boolean> deleteStore(@PathVariable(value = "id") Integer id)throws ResourceNotFoundException{

        service.deleteById(id);
        HashMap<String,Boolean> responce=new HashMap<>();
        responce.put("Deleted", true);
        return responce;

    }

    @PatchMapping("/buy/{id}")
    public HashMap<String, Boolean> updateBook(@PathVariable(value = "id") Integer id, @RequestBody Buy buy)throws ResourceNotFoundException{
        service.update(id,buy);
        HashMap<String,Boolean> responce=new HashMap<>();
        responce.put("Update", true);
        return responce;
    }


    @PutMapping("/buy/{id}")
    public HashMap<String, Boolean> fullUpdateStore(@PathVariable(value = "id") Integer id, @RequestBody Buy buy)throws ResourceNotFoundException{
        service.fullUpdate(id, buy);
        HashMap<String,Boolean> responce=new HashMap<>();
        responce.put("FullUpdate", true);
        return responce;
    }

    @GetMapping("/buy/month-where-buy")
    public List<String> monthWhereBuy(){
        return service.monthWhereBuy();
    }
    @GetMapping("/buy/get-surname-and-shop")
    public List<String> getSurnameAndShop(){
        return service.getSurnameAndShop();
    }
    @GetMapping("/buy/get-data-surname-discount-book-name-num")
    public List<String> getDateSurnameDiscountBookNameNum(){
        return service.getDateSurnameDiscountBookNameNum();
    }
    @GetMapping("/buy/get-buy-total-more60000")
    public List<String> getBuyTotalMore60000(){
        return service.getBuyTotalMore60000();
    }
    @GetMapping("/buy/get-buy-in-customer-district")
    public List<String> getBuyInCustomerDistrict(){
        return service.getBuyInCustomerDistrict();
    }
    @GetMapping("/buy/get-store-not-avtoz-and-district-from10to15")
    public List<String> getStoreNotInAvtozAndDistricttFrom10To15(){
        return service.getStoreNotInAvtozAndDistricttFrom10To15();
    }

    @GetMapping("/buy/get-book-buy-details")
    public  List<String> getBookBuyDetails(){
        return service.getBookBuyDetails();
    }


}
