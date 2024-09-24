package com.finalSprint.product.serviceTest;



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

import com.finalSprint.product.exceptions.InvalidValueException;
import com.finalSprint.product.model.Product;
import com.finalSprint.product.repository.ProductRepository;
import com.finalSprint.product.service.ProductServices;

@ExtendWith(MockitoExtension.class)
public class ProductServicesTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductServices service;

    private Product product;

   


 

   

  

    @Test
    void testDeleteById() throws Exception {
        when(repository.existsById(anyLong())).thenReturn(true);
        doNothing().when(repository).deleteById(anyLong());

        service.deleteById(1L);

        verify(repository, times(1)).existsById(1L);
        verify(repository, times(1)).deleteById(1L);
    }

 
}

