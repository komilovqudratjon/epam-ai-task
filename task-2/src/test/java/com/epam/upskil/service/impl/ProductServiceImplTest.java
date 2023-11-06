package com.epam.upskil.service.impl;

import com.epam.upskil.model.Product;
import com.epam.upskil.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * @className: ProductServiceImplTest  $
 * @description: TODO
 * @date: 06 November 2023 $
 * @time: 11:04 PM 08 $
 * @author: Qudratjon Komilov
 */
@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
        product.setId(1L);
        product.setName("Test Product");
        product.setDescription("Test Description");
        product.setPrice(new BigDecimal("9.99"));
        product.setQuantity(100);
    }

    @Test
    void getAllProducts() {
        // Arrange
        when(productRepository.findAll()).thenReturn(Collections.singletonList(product));

        // Act
        List<Product> products = productService.getAllProducts();

        // Assert
        assertThat(products).isNotNull();
        assertThat(products.size()).isEqualTo(1);
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void getProductById() {
        // Arrange
        when(productRepository.findById(anyLong())).thenReturn(Optional.of(product));

        // Act
        Product foundProduct = productService.getProductById(1L);

        // Assert
        assertThat(foundProduct).isNotNull();
        assertThat(foundProduct.getId()).isEqualTo(product.getId());
        verify(productRepository, times(1)).findById(anyLong());
    }

    @Test
    void saveProduct() {
        // Arrange
        when(productRepository.save(any(Product.class))).thenReturn(product);

        // Act
        Product savedProduct = productService.saveProduct(product);

        // Assert
        assertThat(savedProduct).isNotNull();
        assertThat(savedProduct.getName()).isEqualTo("Test Product");
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    void updateProduct() {
        // Arrange
        Product updatedInfo = new Product();
        updatedInfo.setId(1L);
        updatedInfo.setName("Updated Product");
        updatedInfo.setDescription("Updated Description");
        updatedInfo.setPrice(new BigDecimal("19.99"));
        updatedInfo.setQuantity(200);

        when(productRepository.findById(anyLong())).thenReturn(Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(updatedInfo);

        // Act
        Product updatedProduct = productService.updateProduct(1L, updatedInfo);

        // Assert
        assertThat(updatedProduct).isNotNull();
        assertThat(updatedProduct.getName()).isEqualTo("Updated Product");
        assertThat(updatedProduct.getDescription()).isEqualTo("Updated Description");
        assertThat(updatedProduct.getPrice()).isEqualTo(new BigDecimal("19.99"));
        assertThat(updatedProduct.getQuantity()).isEqualTo(200);

        verify(productRepository, times(1)).findById(anyLong());
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    void deleteProduct() {
        // Arrange
        doNothing().when(productRepository).delete(any(Product.class));
        when(productRepository.findById(anyLong())).thenReturn(Optional.of(product));

        // Act
        productService.deleteProduct(1L);

        // Assert
        verify(productRepository, times(1)).delete(any(Product.class));
        verify(productRepository, times(1)).findById(anyLong());
    }
}