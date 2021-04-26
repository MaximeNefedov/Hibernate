package ru.netology.products_dao.repositories;

import ru.netology.products_dao.models.Order;

import java.util.List;

public interface ProductsRepository {
    List<Order> getOrdersByName(String name);
}
