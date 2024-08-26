package com.unir.tienda.data;

import org.springframework.data.jpa.repository.JpaRepository;
import com.unir.tienda.model.pojo.Product;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
}
