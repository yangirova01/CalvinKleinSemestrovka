package ru.itis.services;

import ru.itis.models.Product;

import java.util.List;

public interface BasketService {
    void save(Long userId, Long productId);
    List<Product> getForUser(Long userId);
    void deleteForUser(Long userId);
    List<Product> findAllCheaperAndType(String price,String type);
    void deleteProductForUser(Long userId, int id);
}
