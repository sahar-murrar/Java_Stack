package com.codingdojo.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Languages;
import com.codingdojo.languages.repositories.LnaguageRepository;

@Service
public class LanguagesService {
	// adding the language repository as a dependency
	private final LnaguageRepository languageRepository;

	public LanguagesService(LnaguageRepository languageRepository) {
	     this.languageRepository = languageRepository;
	 }

	// returns all the languages
	public List<Languages> allLanguages() {
		return languageRepository.findAll();
	}
	 // creates a language
	 public Languages createLanguage(Languages l) {
	     return languageRepository.save(l);
	 }
	 
	 // retrieves a language
	 public Languages findLanguage(Long id) {
	     Optional<Languages> optionalLanguage = languageRepository.findById(id);
	     if(optionalLanguage.isPresent()) {
	         return optionalLanguage.get();
	     } else {
	         return null;
	     }
	 }
	 public Languages updateLanguage(Long id, String name, String creator, String currentVersion) {
		 Languages language= findLanguage(id);
		 language.setName(name);
		 language.setCreator(creator);
		 language.setCurrentVersion(currentVersion);
		 return languageRepository.save(language);
		 
	 }
	 public Languages updateLanguage(Languages language) {
//		 Languages l=findLanguage(language.getId());
//		 l.setName(language.getName());
//		 l.setCreator(language.getCreator());
//		 l.setCurrentVersion(language.getCurrentVersion());
		 return languageRepository.save(language);
		 
	 }
	 public void deleteLanguage(Long id) {
		 Optional<Languages> optionalLanguage = languageRepository.findById(id);
	     if(optionalLanguage.isPresent()) {
	    	 languageRepository.deleteById(id);
	     }
	     else {
	    	 System.out.println("There is no Language with this id");
	     }
	 }

}
