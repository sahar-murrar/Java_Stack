package com.codingdojo.overflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.overflow.models.Tag;
import com.codingdojo.overflow.repositories.QuestionRepository;
import com.codingdojo.overflow.repositories.TagRepository;

@Service
public class TagService {
	private final TagRepository tagRepository;
	private final QuestionRepository questionRepository;

	public TagService(TagRepository tagRepository, QuestionRepository questionRepository) {
		this.tagRepository = tagRepository;
		this.questionRepository = questionRepository;
	}

	public Tag craeteTag(Tag t) {
		List<Tag> allTags = findAll();
		if (!allTags.contains(t)) {
			return tagRepository.save(t);
		}
		return t;
	}

	public Tag findTag(Long id) {
		return tagRepository.findById(id).orElse(null);
	}

	public List<Tag> findAll() {
		return tagRepository.findAll();
	}
	public Tag findBySubject(String subject) {
		return tagRepository.findBySubject(subject);
	}

}
