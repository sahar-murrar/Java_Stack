package com.codingdojo.diverslicense.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.diverslicense.models.License;
import com.codingdojo.diverslicense.models.Person;
import com.codingdojo.diverslicense.services.LicenseService;
import com.codingdojo.diverslicense.services.PersonService;

@Controller
public class LicenseController {
	private final LicenseService licenseService;
	private final PersonService personService;

	public LicenseController(LicenseService licenseService, PersonService personService) {
		this.licenseService = licenseService;
		this.personService=personService;
	}
	@RequestMapping("/licenses/new")
	public String index(Model model) {
		model.addAttribute("licenses", new License());
		List<Person> persons=licenseService.findPersonsWithoutLicense();
		model.addAttribute("persons", persons);
		return "license.jsp";
	}
	
	@RequestMapping("/licenses/new/create")
	public String createLicenses(@Valid @ModelAttribute("licenses") License license, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "license.jsp";
		}
		licenseService.createLicense(license);
		return "redirect:/licenses/new";
	}
	@RequestMapping("/persons/{id}")
	public String viewPersonLicense(@PathVariable("id") Long id, Model model) {
		Person p= personService.findPerson(id);
		License L= p.getLicense();
		model.addAttribute("personName", p.getFirstname()+" " +p.getLastname());
		model.addAttribute("licenseNumber", L.getNumber());
		model.addAttribute("state", L.getState());
		model.addAttribute("expirationDate", L.getExpirationDate());
		return "viewPersonLicense.jsp";
	}
	

}
