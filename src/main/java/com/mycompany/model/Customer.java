package com.mycompany.model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;
    @Column(name = "customer_surname")
    private String surname;
    private String district;
    private int discount;
}
