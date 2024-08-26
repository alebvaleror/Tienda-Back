package com.unir.tienda.controller;

import org.springframework.http.HttpStatus; // 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.Collections;
import java.util.List;
import java.util.Map;

//Importacion de los datos de productos
import com.unir.tienda.model.request.CreateProductRequest;
import com.unir.tienda.model.pojo.Product;
import com.unir.tienda.service.ProductsService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductsController {

    private final ProductsService service;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {

        List<Product> products = service.getProducts();
        if (products != null) {
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable String productId) {
        
        Product product = service.getProduct(productId);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String productId) {
        Boolean removed = service.removeProduct(productId);
        if (Boolean.TRUE.equals(removed)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> getProduct(@RequestBody CreateProductRequest request) {
        Product createdProduct = service.createProduct(request);
        if (createdProduct != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}

