# Order Service

A microservices-based food delivery backend built with Spring Boot.

## Architecture
```
[Client] → [Restaurant Service :8081] ← [Order Service :8082]
```

Order Service calls Restaurant Service via REST to validate 
menu items and calculate total price before placing an order.

## Tech Stack
- Java 17
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- RestTemplate (inter-service communication)

## Services
| Service | Port | Database |
|---|---|---|
| Restaurant Service | 8081 | restaurant_db |
| Order Service | 8082 | order_db |

## Endpoints

### Restaurant Service
- POST /restaurants
- GET /restaurants
- GET /restaurants/{id}
- POST /restaurants/{id}/menu
- GET /restaurants/{id}/menu
- GET /restaurants/{id}/menu/{menuItemId}

### Order Service
- POST /orders
- GET /orders/{id}
- GET /orders/user/{userId}
- PATCH /orders/{id}/status

## Setup
1. Clone both repos
2. Create PostgreSQL databases: restaurant_db and order_db
3. Copy application.properties.example → application.properties
4. Fill in your DB credentials
5. Run Restaurant Service first, then Order Service

## Key Concepts Demonstrated
- Microservices architecture
- Inter-service REST communication
- Independent databases per service
- Global exception handling
