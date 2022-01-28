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




}
