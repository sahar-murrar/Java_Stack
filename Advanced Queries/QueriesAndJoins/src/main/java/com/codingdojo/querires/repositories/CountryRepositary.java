package com.codingdojo.querires.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.querires.models.Country;

@Repository
public interface CountryRepositary extends CrudRepository<Country, Long> {
	List<Country> findAll();
	
	@Query(value = "select language, percentage, countries.name FROM languages \r\n"
			+ "INNER JOIN countries ON countries.id = languages.country_id\r\n" + "where language =\"Slovene\"\r\n"
			+ "ORDER BY percentage DESC;\r\n" + "", nativeQuery = true)
	List<Object[]> countriesSpeaksSlovene();
	
	@Query(value="select countries.name, countries.population, countries.surface_area from countries\r\n"
			+ "where surface_area < 501 and population > 100000;", nativeQuery = true)
	List<Object[]> countriesSurface();
	
	@Query(value="select countries.name as country, government_form, countries.surface_area, countries.life_expectancy from countries\r\n"
			+ "where countries.government_form=\"Constitutional Monarchy\" \r\n"
			+ "and countries.surface_area > 200 and countries.life_expectancy >75;",nativeQuery = true)
	List<Object[]> countriesGovermentAndSurface();
	
	@Query(value="select countries.region, count(countries.region) from countries\r\n"
			+ "group by countries.region -- it will count the  rows that have the same value of country region\r\n"
			+ "ORDER BY count(countries.region) DESC;\r\n"
			+ "", nativeQuery = true)
	List <Object[]> numberOfCountries();

}
