package com.capg.onlineshopping;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.onlineshopping.entity.Category;
import com.capg.onlineshopping.entity.Product;
import com.capg.onlineshopping.exceptions.CategoryIdNotFoundException;
import com.capg.onlineshopping.exceptions.ProdcutIdNotFoundException;
import com.capg.onlineshopping.repository.CategoryRepository;
import com.capg.onlineshopping.repository.ProductRepository;
import com.capg.onlineshopping.service.ProductServiceImpl;

@SpringBootTest
public class ProductServiceTest {
	
	
	
	@Mock
    private ProductRepository productRepository;
 
    @Mock
    private CategoryRepository categoryRepository;
 
    @InjectMocks
    private ProductServiceImpl productService;
 
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
 
    @Test
    void testAddProduct_Success() {
        Category category = new Category();
        category.setId(1);
        category.setName("Electronics");
 
        Product product = new Product();
        product.setName("Laptop");
        product.setQuantity(10);
        product.setBrand("HP");
        product.setDescription("Powerful laptop");
        product.setPrice(1000);
        product.setCategory(category);
 
        when(categoryRepository.existsById(category.getId())).thenReturn(true);
        when(categoryRepository.findById(category.getId())).thenReturn(java.util.Optional.of(category));
        when(productRepository.save(product)).thenReturn(product);
 
        assertDoesNotThrow(() -> productService.addProduct(product));
    }
 
    @Test
    void testAddProduct_CategoryNotFound() {
        Product product = new Product();
        product.setName("Laptop");
        product.setQuantity(10);
        product.setBrand("HP");
        product.setDescription("Powerful laptop");
        product.setPrice(1000);
 
        when(categoryRepository.existsById(1)).thenReturn(false);
 
        assertThrows(CategoryIdNotFoundException.class, () -> productService.addProduct(product));
    }
 
    @Test
    void testGetAllProducts_Success() {
        List<Product> products = Arrays.asList(
                new Product(1, "Laptop", 10, "HP", "Powerful laptop", 1000, new Category(1, "Electronics")),
                new Product(2, "Smartphone", 20, "Samsung", "High-performance smartphone", 800, new Category(2, "Electronics")));
 
        when(productRepository.findAll()).thenReturn(products);
 
        List<Product> result = productService.getAllProducts();
 
        assertEquals(products.size(), result.size());
        assertEquals(products.get(0).getName(), result.get(0).getName());
        assertEquals(products.get(1).getName(), result.get(1).getName());
    }
 
//    @Test
//    void testUpdateProductById_Success()  {
//        int productId = 1;
//        Category category = new Category();
//        category.setId(1);
//        category.setName("Electronics");
// 
//        Product existingProduct = new Product(productId, "Laptop", 10, "HP", "Powerful laptop", 1000, category);
//        Product updatedProduct = new Product(productId, "Updated Laptop", 15, "Dell", "High-performance laptop", 1200, category);
// 
//        when(productRepository.existsById(productId)).thenReturn(true);
//        when(productRepository.findById(productId)).thenReturn(java.util.Optional.of(existingProduct));
//        when(productRepository.save(updatedProduct)).thenReturn(updatedProduct);
// 
//        Product result = productService.updateProductById(productId, updatedProduct.getPrice(), updatedProduct.getQuantity());
// 
//        assertEquals(updatedProduct.getName(), result.getName());
//        assertEquals(updatedProduct.getDescription(), result.getDescription());
//        assertEquals(updatedProduct.getBrand(), result.getBrand());
//        assertEquals(updatedProduct.getPrice(), result.getPrice());
//        assertEquals(updatedProduct.getQuantity(), result.getQuantity());
//    }
 
    @Test
    void testUpdateProductById_NotFound() {
        int productId = 1;
 
        when(productRepository.existsById(productId)).thenReturn(false);
 
        assertThrows(ProdcutIdNotFoundException.class, () ->
                productService.updateProductById(productId, 1200, 15));
    }
    @Test
    void testAddProduct_CategoryIdNotFound() {
        Product product = new Product();
        Category category = new Category();
        category.setId(1);
        product.setCategory(category);

        when(categoryRepository.existsById(1)).thenReturn(false);

        assertThrows(CategoryIdNotFoundException.class, () -> productService.addProduct(product));
    }
 
//    @Test
//    void testDeleteProductById_Success() {
//        int productId = 1;
//        int categoryId = 1;
// 
//        when(productRepository.existsById(productId)).thenReturn(true);
//        when(categoryRepository.existsById(categoryId)).thenReturn(true);
// 
//        assertDoesNotThrow(() -> productService.deleteProductById(productId, categoryId));
//    }

    @Test
    void testDeleteProductById_Success() throws ProdcutIdNotFoundException {
        int productId = 1;
        int categoryId = 1;

        Product product = new Product();
        Category category = new Category();
        category.setId(categoryId);
        product.setCategory(category);

        when(productRepository.existsById(productId)).thenReturn(true);
        when(categoryRepository.findById(categoryId)).thenReturn(Optional.of(category));

        assertEquals("Product Deleted Successfully" + productId, productService.deleteProductById(productId, categoryId));
    }
    
    @Test
    void testDeleteProductById_NotFound() {
        int productId = 1;
        int categoryId = 1;
 
        when(productRepository.existsById(productId)).thenReturn(false);
 
        assertThrows(ProdcutIdNotFoundException.class, () ->
                productService.deleteProductById(productId, categoryId));
    }
}
