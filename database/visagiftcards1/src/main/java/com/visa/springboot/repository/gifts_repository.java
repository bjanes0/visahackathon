package com.visa.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visa.springboot.model.gifts;



@Repository
public interface gifts_repository extends JpaRepository<gifts, String> {

}
