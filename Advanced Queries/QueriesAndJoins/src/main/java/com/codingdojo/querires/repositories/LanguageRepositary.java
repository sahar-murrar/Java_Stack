package com.codingdojo.querires.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.querires.models.Language;

@Repository
public interface LanguageRepositary extends CrudRepository<Language, Long> {
	List<Language> findAll();

	@Query( value = "select countries.name, language, percentage FROM languages \r\n"
			+ "INNER JOIN countries ON countries.id = languages.country_id\r\n"
			+ "where percentage > 89\r\n"
			+ "order by languages.percentage Desc;", nativeQuery = true )
	List<Object[]>  coutriesLanguage();

}
