package com.demo.vacuum.ProductService.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.vacuum.ProductService.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{
	Optional<Product> findById(int id);
}
