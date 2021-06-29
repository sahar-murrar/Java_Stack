package com.codingdojo.beltreviewer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.beltreviewer.models.Attend;
@Repository
public interface AttendRepository extends CrudRepository<Attend, Long> {
//	User findByEmail(String email);

}
