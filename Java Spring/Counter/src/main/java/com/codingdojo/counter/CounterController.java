package com.codingdojo.counter;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	int counter=0;
	@RequestMapping("/your_server")
	public String home(Model model, HttpSession session) {
		counter++;
		session.setAttribute("counter", counter);
		return "index.jsp";
		}
	
	@RequestMapping("/your_server/counter")
	public String counter(Model model, HttpSession session) {
		if (session.getAttribute("counter") !=null) {
			model.addAttribute("counter", session.getAttribute("counter"));
			return "counter.jsp";
		
			
		}
		else {
			model.addAttribute("counter",0);
			return "counter.jsp";
			
		}
		
		
		}
	
	@RequestMapping("/your_server/addTwo")
	public String addTwo(Model model, HttpSession session) {
		if (session.getAttribute("counter") !=null) {
			counter+=2;
			Integer x=Integer.parseInt(session.getAttribute("counter").toString())+2;
			session.setAttribute("counter", x);
			model.addAttribute("counter", session.getAttribute("counter"));
			return "addTwo.jsp";
		
			
		}
		else {
			model.addAttribute("counter",0);
			return "addTwo.jsp";
			
		}
		
		
		}
	
	@RequestMapping("/reset")
	public String reset(Model model, HttpSession session) {
		counter=0;
		session.setAttribute("counter", counter);
		model.addAttribute("counter", session.getAttribute("counter"));
		return "redirect:/your_server/counter";
		
	}

}
