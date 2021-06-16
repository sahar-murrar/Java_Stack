package com.codingdojo.dojosurvey;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DojoSurveyController {

	@RequestMapping("")
	public String dojoSurvey() {
		return "index.jsp";
	}

	@RequestMapping("/info")
	public String info() {

		return "Info.jsp";
	}

	@RequestMapping(value = "/process_result", method = RequestMethod.POST)
	public String process_result(HttpSession session, @RequestParam(value = "name") String name,
			@RequestParam(value = "location") String dojoLocation, @RequestParam(value = "language") String favLanguage,
			@RequestParam(value = "comment") String comment) {
		session.setAttribute("name", name);
		session.setAttribute("location", dojoLocation);
		session.setAttribute("language", favLanguage);
		session.setAttribute("comment", comment);

		return "redirect:/info";
	}

}
