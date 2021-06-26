package com.codingdojo.overflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.overflow.models.Answer;
import com.codingdojo.overflow.models.Question;
import com.codingdojo.overflow.repositories.AnswerRepository;
import com.codingdojo.overflow.repositories.QuestionRepository;

@Service
public class AnswerService {
	private final QuestionRepository questionRepository;
	private final AnswerRepository answerRepository;

	public AnswerService(QuestionRepository questionRepository, AnswerRepository answerRepository) {
		this.questionRepository = questionRepository;
		this.answerRepository = answerRepository;
	}
	public List<Answer> findAll(){
		return answerRepository.findAll();
		
	}
	public List<Answer> findQuestionAnswers(Question q){
		List<Answer> allAnswers= findAll();
		List<Answer> questionAnswersList= new ArrayList<Answer>();
		for(int i=0; i<allAnswers.size(); i++) {
			if(allAnswers.get(i).getQuestion()==q) {
				questionAnswersList.add(allAnswers.get(i));
				
			}
		}
		
		return questionAnswersList;
	}
	public Answer creatAnswer(Answer a) {
		return answerRepository.save(a);
	}

}
