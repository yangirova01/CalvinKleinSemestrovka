package ru.itis.util;

import ru.itis.models.Product;
import ru.itis.repositories.ProductRepository;
import java.util.List;

public class ProductsUtil {

//    static WomanRepository womanRepository;
//    static ManRepository manRepository;
//    static KidsRepository kidsRepository;
//
//
//
//    public ProductsUtil(
//            WomanRepository womanRepository,
//            ManRepository manRepository,
//            KidsRepository kidsRepository) {
//
//        this.womanRepository = womanRepository;
//        this.manRepository = manRepository;
//        this.kidsRepository = kidsRepository;
//    }
//
//    public List<Woman> getWoman() {
//        return womanRepository.findAll();
//    }
//
//    public List<Man> getMan() {
//        return manRepository.findAll();
//    }
//
//    public List<Kids> getKids() {
//        return kidsRepository.findAll();
//    }

    private  ProductRepository productRepository;

    public ProductsUtil(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
