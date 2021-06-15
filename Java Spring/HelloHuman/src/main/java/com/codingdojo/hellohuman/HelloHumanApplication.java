package com.codingdojo.hellohuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloHumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloHumanApplication.class, args);
	}
	
	@RequestMapping("/")
    public String index(@RequestParam(value="name", required=false) String searchName, @RequestParam(value="lastname", required=false) String lastName) {
        return (searchName==null || lastName==null) ? "Hello Human"+"<br>"+"Welcome to SpringBoot!!": "Hello "+searchName+" "+lastName+"<br>"+"Welcome to SpringBoot!!"; 
    }

}
