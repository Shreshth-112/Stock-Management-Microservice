package com.payment.Bill.conroller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.payment.Bill.Order.Order;
import com.payment.Bill.Order.PrintUtil;
import com.payment.Bill.Service.OrderService;
import com.payment.Bill.Service.PdfService;

import java.io.IOException;

import javax.print.PrintException;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/order/{orderId}/bill")
    public String getOrderBill(@PathVariable long orderId) {
        Optional<Order> orderOptional = orderService.getOrderById(orderId);
        if (orderOptional.isPresent()) {
            return orderService.generateBill(orderOptional.get());
        } else {
            return "Order not found.";
        }
    }
}
