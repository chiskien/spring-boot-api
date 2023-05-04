package com.example.springbootapi.services;

import com.example.springbootapi.exceptions.NotFoundIdException;
import com.example.springbootapi.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService {
    private final List<Product> products = new ArrayList<>();

    @Autowired
    public ProductService() {
        products.add(new Product(1, "Mango"));
        products.add(new Product(2, "Grape"));
        products.add(new Product(3, "Melon"));
        products.add(new Product(4, "Apple"));
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getById(Integer id) {
        return products.stream().filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(NotFoundIdException::new);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void deleteProduct(Integer id) {

        var product = getById(id);
        if (product != null) {
            products.remove(product);
        } else {
            throw new NotFoundIdException();
        }
    }
}
