package com.demo.vacuum.ProductService.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.vacuum.ProductService.dao.ProductRepository;
import com.demo.vacuum.ProductService.dto.Productdto;
import com.demo.vacuum.ProductService.model.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository repository;
	@Override
	public Product addNewProduct(Productdto product) {
		Product productInfo = new Product();
		productInfo.setModelNo(product.getModelNo());
		productInfo.setName(product.getName());
		productInfo.setProblemStatement(product.getProblemStatement());
		productInfo.setPurchaseDate(LocalDateTime.now());
		return repository.save(productInfo);
	}

	@Override
	public List<Product> showAllProduct() {
		return repository.findAll();
	}

	@Override
	public Product findById(int id) {
		Optional<Product> product = repository.findById(id);
		if(product.isPresent()) {
			return product.get();
		}
		
		return null;
	}

	@Override
	public Product updateProduct(Productdto product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteProduct(int id) {
		Optional<Product> product = repository.findById(id);
		if(product.isPresent()) {
			return "Product delete successfully";
		}
		return "Product delete failed";
	}

	@Override
	public List<Product> searchProducts(String field) {
		List<Product> products = new ArrayList<>();
		if(field != null) {
			field = field.toLowerCase();
			for(Product product : repository.findAll()) {
				if(product.getName().toLowerCase().contains(field)) {
					products.add(product);
				}
			}
		}
		
		return products;
	}

}
