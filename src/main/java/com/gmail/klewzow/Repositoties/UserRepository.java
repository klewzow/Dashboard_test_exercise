package com.gmail.klewzow.Repositoties;

import com.gmail.klewzow.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Element, Long> {
}
