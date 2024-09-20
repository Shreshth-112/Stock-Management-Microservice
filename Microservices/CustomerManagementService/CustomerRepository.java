package com.customer.customer.CustomerRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.customer.CustomersData.CustomerData;

public interface CustomerRepository extends JpaRepository<CustomerData,Long>{

}
