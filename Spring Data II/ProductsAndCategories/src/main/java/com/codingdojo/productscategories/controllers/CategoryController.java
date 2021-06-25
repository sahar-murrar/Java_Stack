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
public class CategoryController {
	private final ProductService productService;
	private final CategoryService categoryService;
	public CategoryController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	@RequestMapping("/categories/new")
	public String index(Model model) {
		model.addAttribute("category", new Category());
		return "createCategory.jsp";
	}
	@RequestMapping("/categories/new/create")
	public String createLicenses(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "createCategory.jsp";
		}
		categoryService.createCategory(category);
		return "redirect:/categories/new";
	}
	@RequestMapping("/categories/{id}")
	public String showProduct(@PathVariable("id")Long id, Model model) {
		Category c= categoryService.findCategory(id);
		List<Product> categoryProducts= categoryService.categoryProducts(c);
		ArrayList<Product> remainedProducts= categoryService.categoryNullProducts(c);
		model.addAttribute("categoryProducts", categoryProducts);
		model.addAttribute("remainedProducts", remainedProducts);
		model.addAttribute("category", c);
		return "showCategoryInfo.jsp";
		
	}
	@RequestMapping(value="/categories/addProduct", method  = RequestMethod.POST)
	public String addCategory(@RequestParam("category") Long categoryId, @RequestParam("product") Long productId) {
		Product p= productService.findProduct(productId);
		Category c= categoryService.findCategory(categoryId);
		List <Product> categoryProducts=categoryService.addProduct(c, p);
		c.setProducts(categoryProducts);
		categoryService.updateCategory(c, categoryProducts);
		String path="redirect:/categories/"+categoryId;
		return path;
		
	}
	

}
