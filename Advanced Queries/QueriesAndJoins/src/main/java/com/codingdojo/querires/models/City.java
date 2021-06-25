package com.codingdojo.querires.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cities")
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	public String name;
	public String country_code;
	public String district;
	public int poplation;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="country_id")
    private Country country;
    
    public City() {
        
    }

	public City(String name, String country_code, String district, int poplation, Country country) {
		this.name = name;
		this.country_code = country_code;
		this.district = district;
		this.poplation = poplation;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPoplation() {
		return poplation;
	}

	public void setPoplation(int poplation) {
		this.poplation = poplation;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	
    
    
}
