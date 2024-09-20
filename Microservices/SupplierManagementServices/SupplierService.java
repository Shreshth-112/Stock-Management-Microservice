package com.suppliers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suppliers.model.Supplier;
import com.suppliers.repository.SupplierRepository;

@Service
public class SupplierService {
	
	@Autowired
    SupplierRepository supplierRepository;

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(Long SupplierId) {
        return supplierRepository.findById(SupplierId).orElse(null);
    }

    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public void deleteSupplier(Long SupplierId) {
        supplierRepository.deleteById(SupplierId);
    }

}
