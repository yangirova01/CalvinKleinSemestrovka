package ru.itis.services;

import ru.itis.models.Product;
import ru.itis.repositories.BasketRepository;

import java.util.List;

public class BasketServiceImpl implements BasketService {

    private BasketRepository basketRepository;

    public BasketServiceImpl(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    @Override
    public void save(Long userId, Long productId) {
        basketRepository.save(userId, productId);
    }

    @Override
    public List<Product> getForUser(Long userId) {
        return basketRepository.getByUserId(userId);
    }

    public void deleteProductForUser(Long userId, int id) {
        basketRepository.deleteProductByUserId(userId, id);
    }

    @Override
    public void deleteForUser(Long userId) {
        basketRepository.deleteByUserId(userId);
    }

    @Override
    public List<Product> findAllCheaperAndType(String price, String type) {
        return basketRepository.findAllCheaperAndType(price,type);
    }
}
