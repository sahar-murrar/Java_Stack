package com.codingdojo.dojosninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosninjas.models.Dojo;
import com.codingdojo.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;

	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}

	public Dojo createDojo(Dojo d) {
		return dojoRepository.save(d);
	}

	public Dojo findDojo(Long id) {
		return dojoRepository.findById(id).orElse(null);
	}
	public List<Dojo> findAll(){
		return dojoRepository.findAll();
	}

}
