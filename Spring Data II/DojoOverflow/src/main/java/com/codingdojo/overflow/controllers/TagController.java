package com.codingdojo.overflow.controllers;

import org.springframework.stereotype.Controller;

import com.codingdojo.overflow.services.TagService;

@Controller
public class TagController {
	private final TagService tagService;

	public TagController(TagService tagService) {
		this.tagService = tagService;
	}

}
