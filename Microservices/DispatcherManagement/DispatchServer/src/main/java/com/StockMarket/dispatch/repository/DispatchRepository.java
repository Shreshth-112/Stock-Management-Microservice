package com.StockMarket.dispatch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StockMarket.dispatch.entity.Dispatcher;

@Repository
public interface DispatchRepository  extends JpaRepository<Dispatcher,Long>{
	
	List<Dispatcher> findByCustomerAddress(String customerAddress);
}
