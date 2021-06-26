package com.codingdojo.overflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.overflow.models.Question;
import com.codingdojo.overflow.repositories.AnswerRepository;
import com.codingdojo.overflow.repositories.QuestionRepository;
import com.codingdojo.overflow.repositories.TagRepository;

@Service
public class QuestionService {
	private final TagRepository tagRepository;
	private final QuestionRepository questionRepository;
	private final AnswerRepository answerRepository;

	public QuestionService(TagRepository tagRepository, QuestionRepository questionRepository,
			AnswerRepository answerRepository) {
		this.tagRepository = tagRepository;
		this.questionRepository = questionRepository;
		this.answerRepository = answerRepository;
	}
	public Question createQuestion(Question q) {
		return questionRepository.save(q);
	}

	public Question findQuestion(Long id) {
		return questionRepository.findById(id).orElse(null);
	}

	public List<Question> findAll() {
		return questionRepository.findAll();
	}


}
