package com.finalSprint.customer.TestCase;



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

import com.finalSprint.customer.exceptions.InvalidValueException;
import com.finalSprint.customer.feignClient.CustomerFeign;
import com.finalSprint.customer.model.Customer;
import com.finalSprint.customer.model.Product;
import com.finalSprint.customer.repository.CustomerRepository;
import com.finalSprint.customer.service.CustomerService;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository repository;

    @Mock
    private CustomerFeign client;

    @InjectMocks
    private CustomerService service;

    private Customer customer;
    private Product product;

   

   

    @Test
    void testFindAllCustomers() {
        when(repository.findAll()).thenReturn(Arrays.asList(customer));

        List<Customer> customers = service.findAllCustomers();

        assertNotNull(customers);
        assertEquals(1, customers.size());
        verify(repository, times(1)).findAll();
    }

  

    @Test
    void testDeleteCustomer() throws Exception {
        when(repository.existsById(anyLong())).thenReturn(true);
        doNothing().when(repository).deleteById(anyLong());

        service.deleteCustomer(1L);

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
