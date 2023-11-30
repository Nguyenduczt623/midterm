package com.example.MidTerm.repositories;

import com.example.MidTerm.models.Product;
import com.example.MidTerm.models.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Integer> {
    ProductDetail findByProduct(Product product);

    void deleteProductDetailById(int id);
}
