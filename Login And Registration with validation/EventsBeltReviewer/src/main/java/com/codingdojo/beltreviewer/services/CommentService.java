package com.codingdojo.beltreviewer.services;

import org.springframework.stereotype.Service;

import com.codingdojo.beltreviewer.models.Comment;
import com.codingdojo.beltreviewer.repositories.CommentRepository;

@Service
public class CommentService {
	private final CommentRepository commentRepository;

	public CommentService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	public Comment createComment(Comment comment) {
		return commentRepository.save(comment);

	}
	
	public Comment updateComment(Comment comment) {
		return commentRepository.save(comment);
	}

}
