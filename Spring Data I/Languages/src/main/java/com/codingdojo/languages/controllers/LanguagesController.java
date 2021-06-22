package com.codingdojo.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.languages.models.Languages;
import com.codingdojo.languages.repositories.LnaguageRepository;
import com.codingdojo.languages.services.LanguagesService;

@Controller
public class LanguagesController {

	private final LanguagesService languageService;

	public LanguagesController(LanguagesService languageService) {
		this.languageService = languageService;
	}

	@RequestMapping("/languages")
	public String index(Model model) {
		List<Languages> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		model.addAttribute("language", new Languages());
		return "index.jsp";
	}

	@RequestMapping(value = "/languages", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Languages language, BindingResult result, Model model) {
		languageService.createLanguage(language);
		return "redirect:/languages";
	}

	@RequestMapping(value = "/languages/{id}", method = RequestMethod.DELETE)
	public String deleteLanguage(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}

	@RequestMapping(value = "/languages/{id}/edit")
	public String process_update(Model model, @PathVariable("id") Long id) {
		Languages lang= languageService.findLanguage(id);
		model.addAttribute("language", new Languages());
		model.addAttribute("languageId", id);
		model.addAttribute("name", lang.getName());
		model.addAttribute("creator", lang.getCreator());
		model.addAttribute("currentVersion", lang.getCurrentVersion());
		return "editLanguage.jsp";
	}

	@RequestMapping(value = "/languages/{id}", method = RequestMethod.PUT)
	public String editLanguage(@Valid @ModelAttribute("language") Languages language, BindingResult result, @PathVariable("id") Long id) { 
		if (result.hasErrors()) {
			return "editLanguage.jsp";
		} else {
			languageService.updateLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping("/languages/{id}")
	public String viewLanguage(@PathVariable("id") Long id, Model model) {
		Languages language= languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "viewLanguage.jsp";
	}
}
