package org.example.thymeleafproductspring.service;

import org.example.thymeleafproductspring.model.Product;

import java.util.List;
import java.util.Map;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    Product findById(int id);
    void update(int id, Product product);
    void remove(int id);
    Product findByName(String name);
}
