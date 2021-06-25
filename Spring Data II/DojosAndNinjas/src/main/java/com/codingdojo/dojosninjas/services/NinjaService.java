package com.codingdojo.dojosninjas.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosninjas.models.Dojo;
import com.codingdojo.dojosninjas.models.Ninja;
import com.codingdojo.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;

	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}

	public Ninja createNinja(Ninja n) {
		return ninjaRepository.save(n);
	}
	public ArrayList<Ninja> findAllDojoNinjas(Dojo d){
		List <Ninja> allNinjas= ninjaRepository.findAll();
		ArrayList<Ninja> allDojoNinjas= new ArrayList<Ninja>();
		for(int i=0; i<allNinjas.size(); i++) {
			Dojo dojo=allNinjas.get(i).getDojo(); 
			if(dojo.getId() == d.getId()) {
				allDojoNinjas.add(allNinjas.get(i));
				
			}
		}
		return allDojoNinjas;
			
	}

}
