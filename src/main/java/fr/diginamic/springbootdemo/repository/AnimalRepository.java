package fr.diginamic.springbootdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.diginamic.springbootdemo.model.Animal;
import fr.diginamic.springbootdemo.model.Species;
@Repository
public interface AnimalRepository extends CrudRepository<Animal, Integer>{
//	List<Animal> findBySpeciesCommonName (String espece);
//	List<Animal> findByColor (List<String> List);
	
}
