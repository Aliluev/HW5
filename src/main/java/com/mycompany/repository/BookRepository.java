package com.mycompany.repository;

import com.mycompany.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    //Всех различных названий и стоимостей книг
    @Query(value = "SELECT DISTINCT book_name AS name, book_price AS price FROM book", nativeQuery = true)
    List<String> AllNameAndPrice();

    @Query(value = "SELECT book_name AS name , book_price AS price FROM book WHERE name LIKE '%Windows%' OR price >= 20000", nativeQuery = true)
    List<String> nameWindowsOrPriceMore20000();

}
