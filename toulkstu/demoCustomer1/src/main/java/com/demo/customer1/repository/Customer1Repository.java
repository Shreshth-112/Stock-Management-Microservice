package com.demo.customer1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.customer1.model.Customer1;

@Repository
public interface Customer1Repository extends JpaRepository<Customer1, Long>{

}

