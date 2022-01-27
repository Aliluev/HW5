package com.mycompany.service;

import com.mycompany.exception.ResourceNotFoundException;
import com.mycompany.model.Book;
import com.mycompany.model.Customer;
import com.mycompany.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository repository;

    public List<Book> findAll(){
        return repository.findAll();
    }

    public Book findById(Integer id) throws ResourceNotFoundException {
        Book book  = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Contact not found:"+ id)
        );
        return book;
    }

    public void save(Book book){
        int i=1;
        while(true){
            if(repository.findById(i).isPresent()){
                i++;
            }else break;
        }
        book.setId(i);
        repository.save(book);
    }

    public void deleteById(Integer id) throws ResourceNotFoundException {
        Book book  = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Contact not found:"+ id)
        );
        repository.delete(book);
    }



    public void update(Integer id, Book updateBook)throws ResourceNotFoundException{
        Book book  = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Contact not found:"+ id)
        );
        if(updateBook.getName()!=null){
            book.setName(updateBook.getName());
        }

        if(updateBook.getStorage()!=null){
            book.setStorage(updateBook.getStorage());
        }
        if(updateBook.getPrice()!=null){
            book.setPrice(updateBook.getPrice());
        }

        if(updateBook.getCount()!=null){
            book.setCount(updateBook.getCount());
        }

        repository.save(book);
    }

    public void fullUpdate(Integer id, Book updateBook)throws ResourceNotFoundException{
        Book book  = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Contact not found:"+ id)
        );

        book.setName(updateBook.getName());
        book.setStorage(updateBook.getStorage());
        book.setPrice(updateBook.getPrice());
        book.setCount(updateBook.getCount());

        repository.save(book);
    }










}
