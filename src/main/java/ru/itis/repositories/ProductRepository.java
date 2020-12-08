package ru.itis.repositories;

import ru.itis.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product> {
    Optional<List<Product>> findByType(String type);
    Long getId(Product product);

}
