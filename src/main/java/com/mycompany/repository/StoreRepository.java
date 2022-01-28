package com.mycompany.repository;

import com.mycompany.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store,Integer> {

    //названия магазинов Сормовского или Советского района
    @Query(value = "SELECT store_name FROM store WHERE district = 'Sormovskiy' OR district = 'Sovetskiy'", nativeQuery = true)
    List<String> storeSormovoOrSovetskiy();

}
