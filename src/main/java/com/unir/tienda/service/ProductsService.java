package com.unir.tienda.service;

import com.unir.tienda.model.request.CreateProductRequest; // 
import com.unir.tienda.model.pojo.Product; // 

import java.util.List;

public interface ProductsService {
    List<Product> getProducts();
    Product getProduct(String productId);
    Boolean removeProduct(String productId);
    Product createProduct(CreateProductRequest request);
}
