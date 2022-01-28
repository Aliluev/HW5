package com.mycompany.repository;

import com.mycompany.model.Buy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyRepository extends JpaRepository<Buy,Integer> {

    //Всех различных месяцев, когда производились покупки
    @Query(value = "SELECT DISTINCT to_char(buy_date, 'month') FROM buy", nativeQuery = true)
    List<String> monthWhereBuy();

    //фамилию покупателя и название магазина, где производилась покупка;
    @Query(value = "SELECT c.customer_sname, s.store_name FROM buy b" +
            " INNER JOIN customer c on c.customer_id = b.customer_id" +
            " INNER JOIN store s on s.store_id = b.store_id", nativeQuery = true)
    List<String> getSurnameAndShop();


    //дату, фамилию покупателя, скидку, название и количество купленных книг.
    @Query(value = "SELECT b.buy_date, c.customer_sname, c.discount, bk.book_name, b.book_count FROM buy b" +
            " INNER JOIN customer c on c.customer_id = b.customer_id" +
            " INNER JOIN book bk on bk.book_id = b.book_id", nativeQuery = true)
    List<String> getDateSurnameDiscountBookNameNum();

    //номер заказа, фамилию покупателя и дату для покупок, в которых было продано
    //книг на сумму не меньшую чем 60000 руб.
    @Query(value = "SELECT b.id , c.customer_sname, b.buy_date FROM buy b " +
            " INNER JOIN customer c on c.customer_id = b.customer_id WHERE b.total > 60000", nativeQuery = true)
    List<String> getBuyTotalMore60000();

    //покупки, сделанные покупателем в своем районе не ранее марта месяца.
    //Вывести фамилию покупателя, район, дату. Произвести сортировку
    @Query(value = "SELECT c.customer_sname, c.customer_district, b.buy_date FROM buy b " +
            "INNER JOIN customer c on c.customer_id = b.customer_id " +
            "INNER JOIN store s on s.store_id = b.store_id " +
            "WHERE c.district = s.district" +
            "AND EXTRACT (MONTH FROM buy_date) > 3 " +
            "ORDER BY buy_date", nativeQuery = true)
    List<String> getBuyInCustomerDistrict();


    //магазины, расположенные в любом районе, кроме Автозаводского, где покупали
    //книги те, у кого скидка от 10 до 15 %;
    @Query(value = "SELECT s.store_name, s.district FROM buy b " +
            "INNER JOIN store s on s.store_id = b.store_id " +
            "INNER JOIN customer c on c.customer_id = b.customer_id " +
            "WHERE (c.discount >= 10 AND c.discount <= 15) AND s.district NOT LIKE 'Avtozavodskiy'", nativeQuery = true)
    List<String> getStoreNotInAvtozAndDistricttFrom10To15();

    //данные по покупке книг (название, район складирования, количество),
    //приобретенных в районе складирования и содержащихся в запасе более 10 штук.
    //Включить данные о стоимости и отсортировать по возрастанию.
    @Query(value = "SELECT bk.book_name, bk.book_storage, bk.book_count, bk.book_price FROM buy b " +
            "INNER JOIN books bk on bk.book_id = b.book_id " +
            "INNER JOIN store s on s.store_id = b.store_id " +
            "WHERE s.district = bk.book_storage " +
            "AND bk.book_count >= 10 " +
            "ORDER BY bk.book_price", nativeQuery = true)
    List<String> getBookBuyDetails();







}
