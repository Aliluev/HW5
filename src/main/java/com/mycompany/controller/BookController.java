package com.mycompany.controller;

import com.mycompany.exception.ResourceNotFoundException;
import com.mycompany.model.Book;

import com.mycompany.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService service;

    @GetMapping("/book")
    public List<Book> getAllBook(){
        return service.findAll();
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> addBook(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        Book book  = service.findById(id);
        return ResponseEntity.ok().body(book);
    }
    @PostMapping("/book")
    public void createBook(@RequestBody Book book){
        service.save(book);
    }

    @DeleteMapping("/book/{id}")
    public HashMap<String, Boolean> deleteBook(@PathVariable(value = "id") Integer id)throws ResourceNotFoundException{

        service.deleteById(id);
        HashMap<String,Boolean> responce=new HashMap<>();
        responce.put("Deleted", true);
        return responce;

    }

    @PatchMapping("/book/{id}")
    public HashMap<String, Boolean> updateBook(@PathVariable(value = "id") Integer id, @RequestBody Book book)throws ResourceNotFoundException{
        service.update(id,book);
        HashMap<String,Boolean> responce=new HashMap<>();
        responce.put("Update", true);
        return responce;
    }


    @PutMapping("/book/{id}")
    public HashMap<String, Boolean> fullUpdateBook(@PathVariable(value = "id") Integer id, @RequestBody Book book)throws ResourceNotFoundException{
        service.fullUpdate(id, book);
        HashMap<String,Boolean> responce=new HashMap<>();
        responce.put("FullUpdate", true);
        return responce;
    }

}
