package ru.itis.repositories;

import ru.itis.models.Product;
import ru.itis.models.User;

import java.util.List;

public interface BasketRepository extends CrudRepository<Product> {
    void save(Long user, Long entity);
    void deleteByUserId(Long userId);
    List<Product> getByUserId(Long userId);
     List<Product> findAllCheaperAndType(String price, String type);
     void deleteProductByUserId(Long userId, int id);
}
