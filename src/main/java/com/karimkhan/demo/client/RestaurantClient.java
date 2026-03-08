package com.karimkhan.demo.client;

import com.karimkhan.demo.dto.MenuItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class RestaurantClient {

    private final RestTemplate restTemplate;

    private static final String RESTAURANT_SERVICE_URL = "http://localhost:8081";

    public MenuItemDTO getMenuItem(Long restaurantId, Long menuItemId) {
        String url = RESTAURANT_SERVICE_URL + "/restaurants/" + restaurantId + "/menu/" + menuItemId;
        return restTemplate.getForObject(url, MenuItemDTO.class);
    }
}