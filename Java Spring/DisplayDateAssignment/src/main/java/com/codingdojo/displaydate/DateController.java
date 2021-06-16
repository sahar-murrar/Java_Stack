package com.codingdojo.displaydate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.time.format.DateTimeFormatter;  

import java.time.LocalDateTime;
import java.util.Date;


@Controller
public class DateController {
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		DateTimeFormatter date = DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy"); 
		LocalDateTime now = LocalDateTime.now(); 
		model.addAttribute("date",date.format(now));
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		DateTimeFormatter time = DateTimeFormatter.ofPattern("hh:mm a"); 
		LocalDateTime now = LocalDateTime.now();  
		model.addAttribute("time",time.format(now));
		return "time.jsp";
	}
	

}
