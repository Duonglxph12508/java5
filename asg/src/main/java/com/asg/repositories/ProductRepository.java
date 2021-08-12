package com.asg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.asg.entity.Categories;
import com.asg.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query("SELECT entity FROM Product entity WHERE available = 1  ")
	public List<Product> findProd(); 
	public List<Product> findByCate(Categories cate); 
}
