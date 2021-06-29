package com.codingdojo.beltreviewer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.beltreviewer.models.Event;
import com.codingdojo.beltreviewer.repositories.EventRepository;

@Service
public class EventService {
	private final EventRepository eventRepository;

	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	public Event createEvent(Event event) {
		return eventRepository.save(event);

	}

	public List<Event> findAll() {
		return (List<Event>) eventRepository.findAll();
	}

	public List<Event> findByState(String state) {
		return eventRepository.findByStateEvent(state);
	}

	public List<Event> findByStateIsNot(String state) {
		return eventRepository.findByStateEventIsNot(state);
	}

	public Event findEventById(Long id) {
		Optional<Event> e = eventRepository.findById(id);

		if (e.isPresent()) {
			return e.get();
		} else {
			return null;
		}
	}

	public Event updateEvent(Event event) {
		return eventRepository.save(event);
	}
	
	public void deleteEvent(Event e) {
		eventRepository.delete(e);
	}

}
