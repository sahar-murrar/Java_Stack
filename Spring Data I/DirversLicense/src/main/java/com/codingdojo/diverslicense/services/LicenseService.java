package com.codingdojo.diverslicense.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.diverslicense.models.License;
import com.codingdojo.diverslicense.models.Person;
import com.codingdojo.diverslicense.repositories.LicenseRepository;
import com.codingdojo.diverslicense.repositories.PersonRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepository;
	private final PersonRepository personRepository;
	public static String LicenseNumber="000000";

	public LicenseService(LicenseRepository licenseRepository, PersonRepository personRepository) {
	     this.licenseRepository = licenseRepository;
	     this.personRepository=personRepository ;
	 }

	 public License createLicense(License l) {
		 String Number=generateLicenseNumber(l);
		 System.out.println(Number);
		 l.setNumber(Number);
	     return licenseRepository.save(l);
	 }
	 
		public List<Person> findPersonsWithoutLicense(){
			List<Person> personsWithoutLiicense= new ArrayList<Person>();
			List<Person> allPersons= personRepository.findAll();
			for(int i=0; i<allPersons.size(); i++) {
				if(allPersons.get(i).getLicense() == null) {
					personsWithoutLiicense.add(allPersons.get(i));
				}
			}
			return personsWithoutLiicense;
			
		}
		public String generateLicenseNumber(License l) {
			if(LicenseNumber.equals("000000")) {
				LicenseNumber="000001";
				l.setNumber(LicenseNumber);
				return LicenseNumber;
			}
			else {
				int num= Integer.parseInt(LicenseNumber);
				num++;
				String Number= String.valueOf(num);
				while(Number.length() !=6) {
					Number="0"+Number;
				}
				LicenseNumber=Number;
				l.setNumber(LicenseNumber);
				return LicenseNumber;
			}
		}
	 

}
