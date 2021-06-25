package com.codingdojo.productscategories.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.productscategories.models.Category;
import com.codingdojo.productscategories.models.Product;
import com.codingdojo.productscategories.services.CategoryService;
import com.codingdojo.productscategories.services.ProductService;

@Controller
public class ProductControler {
	private final ProductService productService;
	private final CategoryService categoryService;
	public ProductControler(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	@RequestMapping("/products/new")
	public String index(Model model) {
		model.addAttribute("product", new Product());
		return "createProduct.jsp";
	}
	@RequestMapping("/products/new/create")
	public String createLicenses(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "createProduct.jsp";
		}
		productService.createProduct(product);
		return "redirect:/products/new";
	}
	@RequestMapping("/products/{id}")
	public String showProduct(@PathVariable("id")Long id, Model model) {
		Product p= productService.findProduct(id);
		List<Category> productCategories= productService.productCategory(p);
		ArrayList<Category> remainedCategories= productService.productNullCategory(p);
		model.addAttribute("productCategories", productCategories);
		model.addAttribute("remainedCategories", remainedCategories);
		model.addAttribute("product", p);
		return "showProductInfo.jsp";
		
	}
	@RequestMapping(value="/products/addCategory", method  = RequestMethod.POST)
	public String addCategory(@RequestParam("category") Long categoryId, @RequestParam("product") Long productId) {
		Category c= categoryService.findCategory(categoryId);
		Product p= productService.findProduct(productId);
		List <Category> productCategories=productService.addCategory(c, p);
		p.setCategories(productCategories);
		productService.updateProduct(p,productCategories);
		String path="redirect:/products/"+productId;
		return path;
		
	}
	

	
}
