package com.codingdojo.productscategories.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.productscategories.models.Category;
import com.codingdojo.productscategories.models.Product;
import com.codingdojo.productscategories.repositories.CategoryRepository;
import com.codingdojo.productscategories.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	public ProductService(ProductRepository productRepository,CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}
	public Product createProduct(Product p) {
		return productRepository.save(p);
	}
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	public Product findProduct(Long id) {
		return productRepository.findById(id).orElse(null); 
	}
	public List<Category> productCategory(Product p){
		return p.getCategories();
	}
	public ArrayList<Category> productNullCategory(Product p){
		ArrayList<Category> remainedCategories= new ArrayList<Category>();
		List<Category> productCategories= productCategory(p);
		List<Category> allCategories=categoryRepository.findAll();
		for(int i=0; i<allCategories.size(); i++) {
			if(!productCategories.contains(allCategories.get(i))) {
				remainedCategories.add(allCategories.get(i));
			}
		}
		return remainedCategories;
	}
	public List<Category> addCategory(Category c, Product p){
		List<Category> productCategories=productCategory(p);
		productCategories.add(c);
		return productCategories;
		
	}
	public Product updateProduct(Product p, List<Category> productCategories) {
		p.setUpdatedAt(new Date());
		p.setCategories(productCategories);
		return productRepository.save(p);
	}


	
	

}
