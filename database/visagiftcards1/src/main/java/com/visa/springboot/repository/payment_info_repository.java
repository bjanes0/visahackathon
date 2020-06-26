package com.visa.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visa.springboot.model.payment_info;

@Repository
public interface payment_info_repository extends JpaRepository<payment_info,String>{

}
