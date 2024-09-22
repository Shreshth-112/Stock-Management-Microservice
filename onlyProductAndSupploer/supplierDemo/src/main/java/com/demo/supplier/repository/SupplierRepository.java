package com.demo.supplier.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.supplier.entity.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long>{
	List<Supplier> findBySupplierId(Long supplierId); 

}
