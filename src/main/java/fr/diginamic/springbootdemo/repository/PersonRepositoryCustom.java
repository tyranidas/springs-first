package fr.diginamic.springbootdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import fr.diginamic.springbootdemo.model.Person;


public interface PersonRepositoryCustom{
	
	
	int deletePersonsWithoutAnimal();
}
