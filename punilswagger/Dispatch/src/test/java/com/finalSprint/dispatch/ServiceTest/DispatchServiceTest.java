package com.finalSprint.dispatch.ServiceTest;



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
import org.springframework.http.ResponseEntity;

import com.finalSprint.dispatch.exception.InvalidValueException;
import com.finalSprint.dispatch.feign.DispatchFeign;
import com.finalSprint.dispatch.model.Dispatch;
import com.finalSprint.dispatch.model.Product;
import com.finalSprint.dispatch.repository.DispatchRepository;
import com.finalSprint.dispatch.service.DispatchService;

@ExtendWith(MockitoExtension.class)
public class DispatchServiceTest {

    @Mock
    private DispatchRepository dispatchRepository;

    @Mock
    private DispatchFeign client;

    @InjectMocks
    private DispatchService dispatchService;

    private Dispatch dispatch;
    private Product product;

   

 

    @Test
    void testFindAll() {
        when(dispatchRepository.findAll()).thenReturn(Arrays.asList(dispatch));

        List<Dispatch> dispatches = dispatchService.findAll();

        assertNotNull(dispatches);
        assertEquals(1, dispatches.size());
        verify(dispatchRepository, times(1)).findAll();
    }



    @Test
    void testGetDispatcherByAddress() throws Exception {
        when(dispatchRepository.findByCustomerAddress(anyString())).thenReturn(Arrays.asList(dispatch));

        List<Dispatch> dispatches = dispatchService.getDispatcherByAddress("Address1");

        assertNotNull(dispatches);
        assertEquals(1, dispatches.size());
        verify(dispatchRepository, times(1)).findByCustomerAddress("Address1");
    }

    @Test
    void testDeleteDispatcher() throws Exception {
        when(dispatchRepository.existsById(anyLong())).thenReturn(true);
        doNothing().when(dispatchRepository).deleteById(anyLong());

        dispatchService.deleteDispatcher(1L);

        verify(dispatchRepository, times(1)).existsById(1L);
        verify(dispatchRepository, times(1)).deleteById(1L);
    }

  
 
}

