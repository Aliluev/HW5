package com.mycompany.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "store")
@Data
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Integer id;
    @Column(name = "store_name")
    private String name;
    private String district;
    private Integer commission;

}
