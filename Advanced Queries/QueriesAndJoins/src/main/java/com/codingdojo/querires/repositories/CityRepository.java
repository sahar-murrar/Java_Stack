package com.codingdojo.querires.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.querires.models.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
	List<City> findAll();
	
	@Query(value = "select  countries.name as country, count(countries.id) as total_cities FROM cities \r\n"
			+ "INNER JOIN countries ON countries.id = cities.country_id\r\n"
			+ "group by countries.id \r\n"
			+ "ORDER BY count(countries.id) DESC;" + "", nativeQuery = true)
	List<Object[]> numberOfCitiesForEachCountry();
	
	@Query(value="select  cities.name as city,  cities.population, countries.name FROM cities \r\n"
			+ "JOIN countries ON countries.id = cities.country_id\r\n"
			+ "where countries.name = \"Mexico\" and cities.population > 500000\r\n"
			+ "order by population Desc;", nativeQuery = true)
	List<Object[]> allMexicoCities();
	
	@Query(value="select  countries.name as country, cities.name as city, cities.district, cities.population FROM cities \r\n"
			+ "INNER JOIN countries ON countries.id = cities.country_id\r\n"
			+ "where countries.name=\"Argentina\"  and cities.district=\"Buenos Aires\" and cities.population > 500000;", nativeQuery = true)
	List<Object[]> allArgentinaCities();
}