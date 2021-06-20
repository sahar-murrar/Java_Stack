package com.codingdojo.updatadelete.controllers;

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

import com.codingdojo.updatadelete.models.Book;
import com.codingdojo.updatadelete.services.BookService;

@Controller
public class BooksController {
	private final BookService bookService;

	public BooksController(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "/books/index.jsp";
	}

	@RequestMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "/books/new.jsp";
	}

	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "/books/new.jsp";
		} else {
			bookService.createBook(book);
			return "redirect:/books";
		}
	}
	@RequestMapping(value = "/books/{id}", method = RequestMethod.POST)
	public String show(@PathVariable("id") Long id, Model model) {
		Book book= bookService.findBook(id);
		model.addAttribute("book", book);
		return "/books/show.jsp";
	}
	
	@RequestMapping(value ="/books/{id}/edit")
	public String editBook(@PathVariable("id") Long id, Model model) {
		Book book= bookService.findBook(id);
		model.addAttribute("book", book);
		return "/books/editBook.jsp";
	}
	
	@RequestMapping(value ="/books/updateBook/{id}", method = RequestMethod.POST)
	public String updateBook(@PathVariable("id") Long id, Model model,  @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="numberOfPages") Integer numOfPages) {
		Book book= bookService.updateBook(id, title, desc, lang, numOfPages);
		return "redirect:/books";
	}
	
	@RequestMapping(value ="/books/deleteBook/{id}", method = RequestMethod.POST)
	public String deleteBook(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return "redirect:/books";
		
	}
	
}