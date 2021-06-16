package com.codingdojo.thecode;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TheCodeController {
	@RequestMapping("")
	public String code() {
		return "index.jsp";
		
	}
	@RequestMapping(value="/process_code", method=RequestMethod.POST)
	public String process_code(Model model, @RequestParam(value="code") String code) {
		if(code.equals("bushido")) {
			return "redirect:/code";
		}
		else {
			return "redirect:/code_error";
		}
		
		
	}
	
	@RequestMapping("/code")
	public String secretPage() {
		return "secret.jsp";
	}
	
	@RequestMapping("/code_error")
	public String code_error(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("error", "You must train harder!");
		return "redirect:/";
	}
	

}
