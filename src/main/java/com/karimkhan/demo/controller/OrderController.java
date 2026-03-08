package com.karimkhan.demo.controller;

import com.karimkhan.demo.enums.OrderStatus;
import com.karimkhan.demo.model.Order;
import com.karimkhan.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(order);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUser(@PathVariable Long userId) {
        return orderService.getOrdersByUser(userId);
    }

    @PatchMapping("/{id}/status")
    public Order updateStatus(@PathVariable Long id, @RequestParam OrderStatus status) {
        return orderService.updateOrderStatus(id, status);
    }
}