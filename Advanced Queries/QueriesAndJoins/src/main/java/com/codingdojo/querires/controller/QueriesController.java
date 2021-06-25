package com.codingdojo.querires.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.querires.service.ApiService;

@Controller
public class QueriesController {
	private final ApiService apiService;

	public QueriesController(ApiService apiService) {
		this.apiService = apiService;
	}
	@RequestMapping("/")
	public String handler(Model model) {
		
		List <Object[]> speaks = apiService.countriesSpeak();
		List <Object[]> query2 = apiService.numberOfCitiesForEachCountry();
		List <Object[]> query3 = apiService.allMexicoCities();
		List <Object[]> query4 = apiService.coutriesLanguage();
		List <Object[]> query5 = apiService.countriesSurface();
		List <Object[]> query6 = apiService.countriesGovermentAndSurface();
		List <Object[]> query7 = apiService.allArgentinaCities();
		List <Object[]> query8 = apiService.numberOfCountries();
		
		model.addAttribute("Speaks", speaks);
		model.addAttribute("query2", query2);
		model.addAttribute("query4", query4);
		model.addAttribute("query3", query3);
		model.addAttribute("query5", query5);
		model.addAttribute("query6", query6);
		model.addAttribute("query7", query7);
		model.addAttribute("query8", query8);
		return "index.jsp";
		
	}
	

}
