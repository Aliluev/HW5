package com.mycompany.repository;

import com.mycompany.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    //Всех различных районов, в которых проживают покупатели
    @Query(value = "SELECT DISTINCT district FROM customer GROUP BY district", nativeQuery = true)
    List<String> districtWhereCustomerLive();

    //Фамилия и размер скидки всех покупателей, проживающих в Нижегородском районе
    @Query(value = "SELECT customer_sname, discount FROM customer WHERE district = 'Nizhegorodskiy' ", nativeQuery = true)
    List<String> surnameDiscountNizhegorodskiy();




}
