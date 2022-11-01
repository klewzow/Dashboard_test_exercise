package com.gmail.klewzow.Repositoties;

import com.gmail.klewzow.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


    Customer findByName(String customerName);

    @Query(value = "select   count(*) FROM customers", nativeQuery = true)
    String findStatistic();
}
