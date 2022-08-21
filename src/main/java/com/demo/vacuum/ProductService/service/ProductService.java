package com.demo.vacuum.ProductService.service;

import java.util.List;

import com.demo.vacuum.ProductService.dto.Productdto;
import com.demo.vacuum.ProductService.model.Product;

public interface ProductService {
	Product addNewProduct(Productdto product);
	
	List<Product> showAllProduct();
	
	Product findById(int id);
	
	Product updateProduct(Productdto product);
	
	String deleteProduct(int id);
	
	List<Product> searchProducts(String field);
}
