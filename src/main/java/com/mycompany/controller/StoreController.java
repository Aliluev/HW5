package com.mycompany.controller;

import com.mycompany.exception.ResourceNotFoundException;
import com.mycompany.model.Book;
import com.mycompany.model.Store;
import com.mycompany.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StoreController {

    @Autowired
    StoreService service;

    @GetMapping("/store")
    public List<Store> getAllStore(){
        return service.findAll();
    }

    @GetMapping("/store/{id}")
    public ResponseEntity<Store> addStore(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        Store store = service.findById(id);
        return ResponseEntity.ok().body(store);
    }
    @PostMapping("/store")
    public void createStore(@RequestBody Store store){
        service.save(store);
    }

    @DeleteMapping("/store/{id}")
    public HashMap<String, Boolean> deleteStore(@PathVariable(value = "id") Integer id)throws ResourceNotFoundException{

        service.deleteById(id);
        HashMap<String,Boolean> responce=new HashMap<>();
        responce.put("Deleted", true);
        return responce;

    }

    @PatchMapping("/store/{id}")
    public HashMap<String, Boolean> updateBook(@PathVariable(value = "id") Integer id, @RequestBody Store store)throws ResourceNotFoundException{
        service.update(id,store);
        HashMap<String,Boolean> responce=new HashMap<>();
        responce.put("Update", true);
        return responce;
    }


    @PutMapping("/store/{id}")
    public HashMap<String, Boolean> fullUpdateStore(@PathVariable(value = "id") Integer id, @RequestBody Store store)throws ResourceNotFoundException{
        service.fullUpdate(id, store);
        HashMap<String,Boolean> responce=new HashMap<>();
        responce.put("FullUpdate", true);
        return responce;
    }







}
