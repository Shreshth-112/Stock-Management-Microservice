package com.payment.Bill.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.Bill.Order.Order;
import com.payment.Bill.Repository.OrderRepository;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Optional<Order> getOrderById(long orderId) {
        return orderRepository.findById(orderId);
    }

    public String generateBill(Order order) {
        return "********** Bill **********\n" +
               "Order ID: " + order.getOrderId() + "\n" +
               "Customer ID: " + order.getCustomerId() + "\n" +
               "Product ID: " + order.getProductId() + "\n" +
               "Product Quantity: " + order.getProductQuantity() + "\n" +
               "Total Cost: $" + order.getTotalCost() + "\n" +
               "*************************";
    }
}
