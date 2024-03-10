package org.example.thymeleafproductspring.service;

import org.example.thymeleafproductspring.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{
    public static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Ca", 1000, "ngon", "Sông" ));
        products.put(2, new Product(2, "Ga", 1000, "ngon", "gà nhà " ));
        products.put(3, new Product(3, "Vit", 1000, "ngon", "nhà nuôi" ));
        products.put(4, new Product(4, "Heo", 1000, "ngon", "Trong chuồng" ));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Product findByName(String name) {
        for (Product product : products.values()){
            if (product.getName().equals(name)){
                return product;
            }
        }
        return null;
    }
}
