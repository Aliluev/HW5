package com.mycompany.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @Column(name = "book_name")
    private String name;
    @Column(name = "book_price")
    private Integer price;
    @Column(name = "book_storage")
    private String storage;
    @Column(name = "book_count")
    private Integer count;
}
