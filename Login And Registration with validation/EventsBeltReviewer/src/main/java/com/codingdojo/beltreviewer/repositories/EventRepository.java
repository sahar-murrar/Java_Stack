package com.codingdojo.beltreviewer.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.beltreviewer.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long>{
//	Event findEvent(Long id);
	List<Event> findByStateEvent(String state);
	List<Event> findByStateEventIsNot(String state);
}
