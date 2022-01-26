package com.mycompany.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "buy")
@Data
public class Buy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "buy_id")
    private int id;

    @Column(name = "buy_date")
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "book_count")
    private int count;

    private int total;

}
