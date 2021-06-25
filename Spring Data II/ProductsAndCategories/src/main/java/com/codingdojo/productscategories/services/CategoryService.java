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
public class CategoryService {
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

	public CategoryService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}
	public Category createCategory(Category c) {
		return categoryRepository.save(c);
	}
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	public Category findCategory(Long id) {
		return categoryRepository.findById(id).orElse(null); 
	}
	public Category findCategory(String name) {
		return categoryRepository.findByName(name);
	}
	public List<Product> categoryProducts(Category c){
		return c.getProducts();
	}
	public ArrayList<Product> categoryNullProducts(Category c){
		ArrayList<Product> remainedProducts= new ArrayList<Product>();
		List<Product> categoryProducts= categoryProducts(c);
		List<Product> allProducts=productRepository.findAll();
		for(int i=0; i<allProducts.size(); i++) {
			if(!categoryProducts.contains(allProducts.get(i))) {
				remainedProducts.add(allProducts.get(i));
			}
		}
		return remainedProducts;
	}
	public List<Product> addProduct(Category c, Product p){
		List<Product> categoryProducts=categoryProducts(c);
		categoryProducts.add(p);
		return categoryProducts;
		
	}
	public Category updateCategory(Category c , List<Product> categoryProducts) {
		c.setUpdatedAt(new Date());
		c.setProducts(categoryProducts);
		return categoryRepository.save(c);
	}



}
