package com.codingdojo.diverslicense.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.diverslicense.models.Person;
import com.codingdojo.diverslicense.services.PersonService;

@Controller
public class PersonController {
	private final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@RequestMapping("/persons/new")
	public String index(Model model) {
		model.addAttribute("persons", new Person());
		return "index.jsp";
	}
	
	@RequestMapping("/persons/new/create")
	public String createPerson(@Valid @ModelAttribute("persons") Person person, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		personService.createPerson(person);
		return "redirect:/persons/new";
	}
	
}
