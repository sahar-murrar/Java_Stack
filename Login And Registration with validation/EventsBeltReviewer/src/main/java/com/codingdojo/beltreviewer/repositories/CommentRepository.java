package com.codingdojo.beltreviewer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.beltreviewer.models.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

}
