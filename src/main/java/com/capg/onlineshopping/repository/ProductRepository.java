package com.capg.onlineshopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capg.onlineshopping.entity.Category;
import com.capg.onlineshopping.entity.Product;

import jakarta.transaction.Transactional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByBrand(String brand);
	
//	List<Product> findByCategory_Id(int categoryId);
	
//	Optional<Product> findByProductIdAndCategory(int productId,int categoryId);

	
	@Query(value="select * from product where price  < :userPrice",nativeQuery=true)
	List<Product> findByPriceLessThan(@Param("userPrice") int price);
	
	
	@Query(value="select * from product where price > :userPrice",nativeQuery=true)
   List<Product> findByGreaterThan(@Param("userPrice") int price);
	
	
	 @Query(value="select * from product  where price  between :minPrice and :maxPrice",nativeQuery=true)
	    List<Product> findProductsByPriceRange(int minPrice, int maxPrice);
	 
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Product p where p.productId=?1 AND p.category=?2")
	void deleteByProductIdAndCategory(int productid, Category category);	
}
