package com.abdias.market.domain.repository;

import com.abdias.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {
    List<Product> getAll();

    Optional<List<Product>> getByCategory(int categoryId);

    Optional<List<Product>> getScarseProducts(int quantity);

    Optional<Product> getProduct(int productId);

    Product save(Product product);
}