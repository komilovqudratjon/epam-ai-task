package com.epam.upskil.repository;

import com.epam.upskil.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @className: ProductRepository  $
 * @description: TODO
 * @date: 06 November 2023 $
 * @time: 4:29 PM 54 $
 * @author: Qudratjon Komilov
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // CRUD operations are inherently defined
}
