package com.codingdojo.dojosninjas.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.dojosninjas.models.Dojo;
import com.codingdojo.dojosninjas.models.Ninja;
import com.codingdojo.dojosninjas.services.DojoService;
import com.codingdojo.dojosninjas.services.NinjaService;

@Controller
public class DojoController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;

	
	public DojoController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	@RequestMapping("dojos/new")
	public String createDojo(Model model) {
		model.addAttribute("dojo", new Dojo());
		return "createDojo.jsp";
	}
	@RequestMapping("/dojos/new/create")
	public String process_creating_dojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "createDojo.jsp";
		}
		dojoService.createDojo(dojo);
		return "redirect:/dojos/new";
		
	}
	@RequestMapping("/dojo/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo d= dojoService.findDojo(id);
		ArrayList<Ninja> allDojoNinjas= ninjaService.findAllDojoNinjas(d);
		model.addAttribute("allDojoNinjas", allDojoNinjas);
		return "showDojo.jsp";
	}
	
	

}
