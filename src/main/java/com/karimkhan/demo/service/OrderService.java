package com.karimkhan.demo.service;

import com.karimkhan.demo.client.RestaurantClient;
import com.karimkhan.demo.dto.MenuItemDTO;
import com.karimkhan.demo.enums.OrderStatus;
import com.karimkhan.demo.exception.ResourceNotFoundException;
import com.karimkhan.demo.model.Order;
import com.karimkhan.demo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestaurantClient restaurantClient;

    public Order placeOrder(Order order) {

        MenuItemDTO menuItem = restaurantClient.getMenuItem(order.getRestaurantId(), order.getMenuItemId());

        if (menuItem == null || !menuItem.isAvailable()) {
            throw new ResourceNotFoundException("Menu item not available");
        }

        // calculate total price automatically
        order.setTotalPrice(menuItem.getPrice() * order.getQuantity());

        return orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
    }

    public List<Order> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    public Order updateOrderStatus(Long id, OrderStatus status) {
        Order order = getOrderById(id);
        order.setStatus(status);
        return orderRepository.save(order);
    }
}