package com.epam.upskil.service;

import com.epam.upskil.model.Product;

import java.util.List;

/**
 * @className: ProductService  $
 * @description: TODO
 * @date: 06 November 2023 $
 * @time: 4:30 PM 19 $
 * @author: Qudratjon Komilov
 */
public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product saveProduct(Product product);

    Product updateProduct(Long id, Product productDetails);

    void deleteProduct(Long id);
}