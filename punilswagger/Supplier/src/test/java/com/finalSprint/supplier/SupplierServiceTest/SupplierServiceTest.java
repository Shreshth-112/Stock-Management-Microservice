package com.finalSprint.supplier.SupplierServiceTest;



import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.finalSprint.supplier.exceptions.InvalidValueException;
import com.finalSprint.supplier.feignclient.SupplierFeign;
import com.finalSprint.supplier.model.Product;
import com.finalSprint.supplier.model.Supplier;
import com.finalSprint.supplier.repository.SupplierRepository;
import com.finalSprint.supplier.services.SupplierService;

@ExtendWith(MockitoExtension.class)
public class SupplierServiceTest {

    @Mock
    private SupplierRepository repository;

    @Mock
    private SupplierFeign client;

    @InjectMocks
    private SupplierService service;

    private Supplier supplier;
    private Product product;

    @BeforeEach
    void setUp() {
      
    }

 

    @Test
    void testGetAllSuppliers() {
        when(repository.findAll()).thenReturn(Arrays.asList(supplier));

        List<Supplier> suppliers = service.getAllSuppliers();

        assertNotNull(suppliers);
        assertEquals(1, suppliers.size());
        verify(repository, times(1)).findAll();
    }

   

    @Test
    void testDeleteSupplier() throws Exception {
        when(repository.existsById(anyLong())).thenReturn(true);
        doNothing().when(repository).deleteById(anyLong());

        service.deleteSupplier(1L);

        verify(repository, times(1)).existsById(1L);
        verify(repository, times(1)).deleteById(1L);
    }

   

    @Test
    void testFindAllProducts() {
        when(client.showProducts()).thenReturn(Arrays.asList(product));

        List<Product> products = service.findAllProducts();

        assertNotNull(products);
        assertEquals(1, products.size());
        verify(client, times(1)).showProducts();
    }
}

