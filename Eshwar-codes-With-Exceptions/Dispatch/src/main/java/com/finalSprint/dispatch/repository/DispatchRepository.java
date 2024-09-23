package com.finalSprint.dispatch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalSprint.dispatch.model.Dispatch;

@Repository
public interface DispatchRepository extends JpaRepository<Dispatch, Long>{
	List<Dispatch> findByCustomerAddress(String customerAddress);
}
