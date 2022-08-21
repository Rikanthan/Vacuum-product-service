package com.demo.vacuum.ProductService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.vacuum.ProductService.dto.Productdto;
import com.demo.vacuum.ProductService.model.Product;
import com.demo.vacuum.ProductService.service.ProductServiceImpl;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	@Autowired
	ProductServiceImpl productService;
	
	@PostMapping
	public Product createProduct(@RequestBody Productdto product) {
		return productService.addNewProduct(product);
	}
	@GetMapping
	public List<Product> showAllProducts(){
		return productService.showAllProduct();
	}
	@GetMapping("/searchBy")
	public List<Product> searchProduct(@RequestParam String name){
		return productService.searchProducts(name);
	}
	@DeleteMapping
	public String deleteProduct(@RequestParam int id) {
		return productService.deleteProduct(id);
	}
}
