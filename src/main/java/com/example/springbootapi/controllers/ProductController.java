package com.example.springbootapi.controllers;

import com.example.springbootapi.models.Product;
import com.example.springbootapi.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class ProductController {

    private final ProductService productService;
    private final Logger logger = Logger.getLogger(ProductController.class.getName());

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/hello")
    public String ciao() {
        return "ciao";
    }

    @GetMapping("/products")
    public List<Product> productList() {
        return productService.getProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getById(@PathVariable Integer id) {
        var existedProduct = productService.getById(id);
        ResponseEntity<Product> responseEntity;
        if (existedProduct != null) {
            responseEntity = ResponseEntity.status(HttpStatus.ACCEPTED)
                    .header("isRaw", "false")
                    .header("original", "Vietnam")
                    .body(existedProduct);
        } else {
            responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return responseEntity;
    }

    @PostMapping("/addProduct")
    public ResponseEntity<List<Product>> postProduct(@RequestBody Product product) {
        logger.info("Add Product Successfully" + product.toString());
        productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProducts());
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
        logger.info("Delete product with " + id + " successfully");
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.getProducts());
    }
}
