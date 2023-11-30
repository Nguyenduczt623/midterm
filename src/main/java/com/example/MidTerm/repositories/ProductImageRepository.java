package com.example.MidTerm.repositories;

import com.example.MidTerm.models.Product;
import com.example.MidTerm.models.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {

    List<ProductImage> findAll();

    List<ProductImage> findAllByProduct(Product product);

    void deleteProductImageById(int id);
}
