package com.codingdojo.overflow.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.overflow.models.Answer;
import com.codingdojo.overflow.models.Question;
import com.codingdojo.overflow.models.Tag;
import com.codingdojo.overflow.services.AnswerService;
import com.codingdojo.overflow.services.QuestionService;
import com.codingdojo.overflow.services.TagService;

@Controller
public class QuestionController {
	private final QuestionService questionService;
	private final TagService tagService;
	private final AnswerService answerService;

	public QuestionController(QuestionService questionService, TagService tagService, AnswerService answerService) {
		this.questionService = questionService;
		this.tagService = tagService;
		this.answerService = answerService;
	}

	@RequestMapping("/questions")
	public String allQuestions(Model model) {
		List<Question> allQuestions = questionService.findAll();
		model.addAttribute("allQuestions", allQuestions);
		return "allQuestions.jsp";
	}

	@RequestMapping("/questions/new")
	public String createQuestion(Model model) {
//		model.addAttribute("questions", new Question());
		return "createQuestion.jsp";
	}

	@RequestMapping(value = "/questions/new/create", method = RequestMethod.POST)
	public String process_creating_question(Model model, @RequestParam("question") String qustion,
			@RequestParam("tags") String tags) {
		Question newQuestion = new Question();
		newQuestion.setQuestion(qustion);
		if (tags.length() > 0) {
			List<String> arr = Arrays.asList(tags.split(","));
			if (arr.size() > 3) {
				return "redirect:/questions/new";
			} else {
				List<Tag> questionTagsList = new ArrayList<Tag>();
				Tag newTag;
				for (String tag : arr) {
					if (tagService.findBySubject(tag) == null) {// if this tag is not found in the database
						newTag = new Tag();
						newTag.setSubject(tag);
						tagService.craeteTag(newTag); // create it
						newTag = tagService.findTag(newTag.getId());// retrive it by the id
					} else {// if the tag is already in the database then retrive it by the subject.
						newTag = tagService.findBySubject(tag);

					}
					questionTagsList.add(newTag);// add the tag in both cases to the question tags list.
				}
				newQuestion.setTags(questionTagsList);// set the tags list of the new question to the list we created
														// and added the tags to it above.
				questionService.createQuestion(newQuestion); // save the question
			}
		}
		return "redirect:/questions";

	}
	@RequestMapping(value="/questions/{id}")
	public String showQuestionInfo(@PathVariable("id")Long id, Model model) {
		Question q= questionService.findQuestion(id);
		model.addAttribute("question", q);
		List<Answer> answersList= answerService.findQuestionAnswers(q);
		model.addAttribute("answerList", answersList);
		model.addAttribute("answers", new Answer());
		return "showQuestionInfo.jsp";
	}
	
	@RequestMapping(value="/answers/process/{id}", method= RequestMethod.POST)
	public String processQuestionAnswer(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute("answers") Answer answer, BindingResult result, @RequestParam("answer") String answerr) {
		if(result.hasErrors()) {
			return "showQuestionInfo.jsp";
		}
		
		Question q = questionService.findQuestion(id);
		List<Answer> questionAnswers= q.getAnswers();
		Answer ans= new Answer(answerr,q);
		questionAnswers.add(ans);
		answerService.creatAnswer(ans);
		return "redirect:/questions/"+id;
	}
	

}
