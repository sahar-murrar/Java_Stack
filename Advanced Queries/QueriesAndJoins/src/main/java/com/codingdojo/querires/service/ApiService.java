package com.codingdojo.querires.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.querires.repositories.CityRepository;
import com.codingdojo.querires.repositories.CountryRepositary;
import com.codingdojo.querires.repositories.LanguageRepositary;

@Service
public class ApiService {
	private final CityRepository cityRepository;
	private final CountryRepositary countryRepository;
	private final LanguageRepositary languageRepositary;

	public ApiService(CityRepository cityRepository, CountryRepositary countryRepository,
			LanguageRepositary languageRepositary) {
		this.cityRepository = cityRepository;
		this.countryRepository = countryRepository;
		this.languageRepositary = languageRepositary;
	}

	public List<Object[]> countriesSpeak() {

		return countryRepository.countriesSpeaksSlovene();

	}

	public List<Object[]> numberOfCitiesForEachCountry() {
		return cityRepository.numberOfCitiesForEachCountry();
	}

	public List<Object[]> coutriesLanguage() {

		return languageRepositary.coutriesLanguage();

	}

	public List<Object[]> allMexicoCities() {

		return cityRepository.allMexicoCities();

	}
	public List<Object[]> countriesSurface(){
		return countryRepository.countriesSurface();
	}
	public List<Object[]> countriesGovermentAndSurface(){
		return countryRepository.countriesGovermentAndSurface();
	}
	public List<Object[]> allArgentinaCities(){
		return cityRepository.allArgentinaCities();
	}
	public List<Object[]> numberOfCountries(){
		return countryRepository.numberOfCountries();
	}
}
