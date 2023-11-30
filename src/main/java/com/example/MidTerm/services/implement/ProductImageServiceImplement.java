package com.example.MidTerm.services.implement;

import com.example.MidTerm.models.Product;
import com.example.MidTerm.models.ProductImage;
import com.example.MidTerm.repositories.ProductImageRepository;
import com.example.MidTerm.services.ProductImageService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Transactional
@Service
public class ProductImageServiceImplement implements ProductImageService {

    @Autowired
    ProductImageRepository productImageRepository;

    @Override
    public List<ProductImage> findAll() {
        return productImageRepository.findAll();
    }

    @Override
    public List<ProductImage> getAllImageOfProduct(Product product) {
        return productImageRepository.findAllByProduct(product);
    }

    @Override
    public Page<ProductImage> PagingAllProductImg(int offset, int pageSize) {
        return productImageRepository.findAll(PageRequest.of(offset,pageSize).withSort(Sort.by("id").descending()));
    }

    @Override
    public void save(ProductImage productImage) {
        productImageRepository.save(productImage);
    }

    @Override
    public ProductImage getProductImgById(Integer id) {
        return productImageRepository.getById(id);
    }

    @Override
    public void deleteProductImg(int id) {
        productImageRepository.deleteProductImageById(id);
    }
}
