package com.codingdojo.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.dojosninjas.models.Dojo;
import com.codingdojo.dojosninjas.models.Ninja;
import com.codingdojo.dojosninjas.services.DojoService;
import com.codingdojo.dojosninjas.services.NinjaService;

@Controller
public class NinjaController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;

	
	public NinjaController(NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}


	@RequestMapping("ninjas/new")
	public String createNinja(Model model) {
		model.addAttribute("ninja", new Ninja());
		List<Dojo> allDojos=dojoService.findAll();
		model.addAttribute("allDojos", allDojos);
		return "createNinja.jsp";
	}
	@RequestMapping("/ninjas/new/create")
	public String process_ninja_creation(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "createNinja.jsp";
		}
		ninjaService.createNinja(ninja);
		return "redirect:/ninjas/new";
		
	}
	
	


}
